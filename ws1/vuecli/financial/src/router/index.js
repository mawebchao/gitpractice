import Vue from 'vue'
import VueRouter from 'vue-router'
Vue.use(VueRouter)

const routes = [
  { 
    path:'/',
    name:'Layout',
    component:()=>import("@/views/Layout"),
    redirect:"/index",
    children:[
      {
        path:"/index",
        name:"index",
        component:()=>import("@/views/Index")
      },
      {
        path:'/account/all',
        name:"account_all",
        meta:{bread:["账户管理","所有人员"]},
        component:()=>import('@/views/account/all.vue')
      },
    ]
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
