import axios from 'axios'
import { getToken } from '../utils/auth'
import { Message } from 'element-ui';
const service = axios.create({
    baseURL: 'localhost:8080',
    timeout: 1000
});
//请求拦截
service.interceptors.request.use(function (config) {
    if (getToken()) config.headers['token'] = getToken()
    return config;
}, function (error) {
    return Promise.reject(error);
});
//相应拦截
service.interceptors.response.use(function (response) {
    if (!response.data.success) {
        Message({
            showClose: true,
            message: '用户名或密码错误',
            type: 'error'
        })
        return Promise.reject(response.data.message);
    }
    return response.data;
}, function (error) {
    // Do something with response error
    return Promise.reject(error);
});
export default service