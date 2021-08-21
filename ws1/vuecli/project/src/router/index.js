import Vue from 'vue'
import VueRouter from 'vue-router'
import routerMap from '../router/routerMap'
//npm install vue-router
//vue引入的所有插件都需要注册(Vue.use(插件名))
Vue.use(VueRouter)


//创建一个路由实例
// 接受路由配置项作为参数
// 路由配置项：就是规定路径和组件的对应关系
const router = new VueRouter({
  routes:routerMap
})

export default router
