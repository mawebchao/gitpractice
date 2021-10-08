import './index.css'
import React from 'react'
import { getHouseDetail, getLocation } from '../../utils/service'
// import {setNewCenter} from '../../utils/bmap/center.js'
import { getNowPositionCenter,addOverlay } from '../../utils/bmap'

const BMapGL = window.BMapGL
//圆点的半径
const circleRadius=35
export default class Map extends React.Component {

    async componentDidMount() {
        var map = new BMapGL.Map("container");          // 创建地图实例
        var point = new BMapGL.Point(121.5361245, 31.29397421);  // 创建点坐标 
        map.centerAndZoom(point, 12);
        map.enableScrollWheelZoom(true);
        let { label, value } = await getLocation();
        //调用地图覆盖物渲染函数
        
        //定位到当前位置
        getNowPositionCenter(map, label,10,null)
        //获取城市下的房源数据数据
        let houseDetailList=await getHouseDetail(value)
        //添加所有覆盖物
        houseDetailList.map(({coord:{longitude,latitude},label:subLabel,count,value:subValue})=>{
            addOverlay(map,longitude,latitude,circleRadius,{subLabel,count,subValue}) 
        })

        
    }
    render() {
        return (
            <div className="map" >
                <div id="container"></div>
            </div>
        )
    }
}