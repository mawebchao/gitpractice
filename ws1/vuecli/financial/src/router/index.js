import Vue from 'vue'
import VueRouter from 'vue-router'
Vue.use(VueRouter)

const routes = [
  {
    path:'/',
    name:'Layout',
    component:()=>import("@/views/Layout")
  },
  {
    path:'/login',
    name:'Login',
    component:()=>import("@/views/Login")
  },
  {
    path:'*',
    name:"404",
    component:()=>import('@/views/404.vue')
  }
]

const router = new VueRouter({
  routes
})

export default router
