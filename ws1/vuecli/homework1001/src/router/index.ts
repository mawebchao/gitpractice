import Vue from 'vue'
import VueRouter, { RouteConfig } from 'vue-router'

Vue.use(VueRouter)

const routes: Array<RouteConfig> = [
  {
    path:"/",
    component:()=>import('../views/List.vue')
  },
  {
    path:"/add",
    component:()=>import('../views/Add.vue')
  }
]

const router = new VueRouter({
  routes
})

export default router
