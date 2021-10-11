import { getHouseDetail } from './service'

const BMapGL = window.BMapGL
const myGeo = new BMapGL.Geocoder();


function setNewCenter(map, lng, lat) {
    var point = new BMapGL.Point(lng, lat);
    map.setCenter(point); // 设置地图中心点
}


// 将地址解析结果显示在地图上，并调整地图视野
export function getNowPositionCenter(map, label, zoom, position) {
    if (position === null || position === undefined) {
        myGeo.getPoint(label, function (point) {
            if (point) {
                if (label === '浦东') {
                    point.lat = 31.159254;
                    point.lng = 121.573916;
                }
                // point.lat = 4825907.72;
                // point.lng = 12958160.97;
                map.centerAndZoom(point, zoom < 0 ? map.zoomLevel - zoom : zoom);
            } else {
                alert('您选择的地址没有解析到结果！');
            }
        }, label)
    } else {
        map.centerAndZoom(position, zoom < 0 ? map.zoomLevel - zoom : zoom);
    }

}


export function addOverlay(map, longitude, latitude, circleRadius, { subLabel: nowLabel, count, subValue: nowValue }) {
    var opts = {
        position: new BMapGL.Point(longitude, latitude), // 指定文本标注所在的地理位置
        offset: new BMapGL.Size(-circleRadius, -circleRadius) // 设置文本偏移量
    };
    // 创建文本标注对象
    let label = new BMapGL.Label("", opts);
    label.setContent("<div class='divClass'><div>" + nowLabel + "</div><div>" + count + "套</div></div>")
    // 自定义文本标注样式
    label.setStyle({
        color: 'black',
        borderRadius: '50%',
        borderColor: '#ccc',
        // padding: '10px',
        fontSize: '16px',
        height: '50px',
        width: '50px',
        lineHeight: '140%',
        fontFamily: '微软雅黑',
        backgroundColor: "green",
        textAlign: "center"
    });
    label.addEventListener('click', async function () {

        //定位到当前位置
        getNowPositionCenter(map, nowLabel, -2, { lng: longitude, lat: latitude })
        //获取城市下的房源数据数据
        let houseDetailList = await getHouseDetail(nowValue)
        if (houseDetailList.length === 0) {
            //小区

        } else {
            //非小区
            //清楚当前所有的覆盖物
            await map.clearOverlays();
            //添加所有覆盖物
            houseDetailList.map(({ coord: { longitude, latitude }, label: subLabel, count, value: subValue }) => {
                addOverlay(map, longitude, latitude, circleRadius, { subLabel, count, subValue })
            })
        }



    });
    map.addOverlay(label);
}

// export async function renderOverLays(map,label,value){
//     console.log("vfds",value)
//     //定位到当前位置
//     getNowPositionCenter(map, label)
//     //获取城市下的房源数据数据
//     let houseDetailList = await getHouseDetail(value)
//     //添加所有覆盖物
//     houseDetailList.map(({ coord: { longitude, latitude }, label: subLabel, count }) => {
//         addOverlay(map, longitude, latitude, circleRadius, { subLabel: subLabel, count: count })
//     })
// }
