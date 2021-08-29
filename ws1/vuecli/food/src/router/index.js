import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

const routes = [
  {
    path:'/',
    name:'Index',
    component:()=>import("../views/Index")
  },
  {
    path:'/classify',
    name:'Classify',
    component:()=>import("../views/Classify")
  },
  {
    path:'/collection',
    name:'Collection',
    component:()=>import("../views/Collection")
  },
  {
    path:'/mine',
    name:'Mine',
    component:()=>import("../views/Mine")
  },
  {
    path:'/list',
    name:'List',
    component:()=>import("../views/List")
  }
]

const router = new VueRouter({
  routes
})

export default router
