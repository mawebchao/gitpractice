import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

const routes = [
  {
    path:'/login',
    name:"Login",
    component:()=>import('../views/Login')
  },
  {
    path:"/whitelist",
    name:"WhiteList",
    component:()=>import ('../views/WhiteList')
  }
]

const router = new VueRouter({
  routes
})

export default router
