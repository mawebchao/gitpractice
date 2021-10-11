// import request from "request";
import axios from 'axios'
import { BASE_URL } from "./global";
export async function getLocationId(cityName) {
    return (await axios.get(BASE_URL+"/area/info?name="+cityName)).data.body 
}

export async function getHouseDetail(id) {
    return (await axios.get(BASE_URL+"/area/map?id="+id)).data.body 
}

// import request from "request";
export async function getLocation(ip) {
    let loc_obj = JSON.parse(localStorage.getItem("loc_obj"))
    if (loc_obj == null) {
        // return navigator.geolocation.getCurrentPosition(position => {
        //     alert(position)
        //     return position;
        // });
        let cityNamePromise= fetch('/bdapi/location/ip?ak=dvZqOAeuRj6EBGmhhywOds1TANEf6QMQ&ip='+ip, {
            method: 'GET'
        }).then(res => {  return res.json(); });
        let {city}=(await cityNamePromise).content.address_detail
        console.log("city",city)
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