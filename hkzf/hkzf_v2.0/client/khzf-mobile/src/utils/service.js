// import request from "request";
import axios from 'axios'
export async function getLocationId(cityName) {
    return (await axios.get("http://localhost:8080/area/info?name="+cityName)).data.body 
}

export async function getHouseDetail(id) {
    return (await axios.get(process.env.LOCAL_URL+"/area/map?id="+id)).data.body 
}

// import request from "request";
export async function getLocation() {
    let loc_obj = JSON.parse(localStorage.getItem("loc_obj"))
    if (loc_obj == null) {
        // return navigator.geolocation.getCurrentPosition(position => {
        //     alert(position)
        //     return position;
        // });
        let cityNamePromise= fetch('/api/location/ip?ak=dvZqOAeuRj6EBGmhhywOds1TANEf6QMQ', {
            method: 'GET'
        }).then(res => {  return res.json(); });
        let {city}=(await cityNamePromise).content.address_detail
        let cityDesc=(await getLocationId(city))
        cityDesc.label=city
        localStorage.setItem("loc_obj",JSON.stringify(cityDesc))
        return cityDesc;
    }
    return new Promise((resolve) => {
        resolve(loc_obj)
    })
    // return null;
}