import axios from 'axios';
import {getToken} from '@/utils/auth'
import { Message } from 'element-ui';
const service=axios.create({
    baseURL:"localhost:8080",
    timeout:5000
})
//请求拦截    请求之前做的事
//每次请求之前都要带token
service.interceptors.request.use((config)=>{
    console.log("请求拦截");
    if(getToken()){
        config.headers['token']=getToken();
    }
    return config;
},(error)=>{
    return Promise.reject(error);
})
//响应拦截
service.interceptors.response.use(function (response) {
    // 对响应数据做点什么
    console.log("这里是响应拦截：",response);
    const res=response.data;
    if(!res.success){
        Message({
            message:res.message||"请求错误",
            type:"error"
        })
        return Promise.reject(new Error(res.message||"请求错误"))
    }
    return res;
  }, function (error) {
    //判断一些硬性错误
    Message({
        message:error.message,
        type:"error"
    })
    return Promise.reject(error);
  });
export default service