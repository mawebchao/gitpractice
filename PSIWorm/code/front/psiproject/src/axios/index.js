import axios from 'axios'
export const defaultAxios= axios.create({
    baseURL: '/api'
})
export const authAxios=axios.create({
    baseURL: 'http://localhost:9000/myauth'
})