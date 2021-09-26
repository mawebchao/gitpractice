import Vue from 'vue'
import VueRouter from 'vue-router'
import validResult from '../utils/auth'
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

router.beforeEach(async (to,from,next) => {
  if(to.path!='/login'){
    if((await new validResult()).data.isValid){
      next()
    }else{
      next('/login')
    }
  }else if(to.path=='/login'){
    if((await new validResult()).data.isValid){
      next('/detail')
    }else{
      next()
    }
  }else{
    next()
  }
  
})

export default router
