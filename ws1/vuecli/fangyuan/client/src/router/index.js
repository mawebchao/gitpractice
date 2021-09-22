import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

const routes = [
  {
    path:'/register',
    component:()=>import('@/views/Register')
  },
  {
    path:'/login',
    component:()=>import('@/views/Login')
  },
  {
    path:"/",
    component:()=> import( '@/views/Container'),
    redirect:'/detail',
    children:[
      {
        path:"detail",
        component:()=>import('../views/Detail')
      }
    ]
  }
]

const router = new VueRouter({
  routes
})

export default router
