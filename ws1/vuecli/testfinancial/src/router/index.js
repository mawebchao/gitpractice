import Vue from 'vue'
import VueRouter from 'vue-router'
Vue.use(VueRouter)

const routes = [
  {
    path:"/login",
    name:"Login",
    component:()=>import("../views/login.vue")
  },
  {
    path:"/",
    name:"Layout",
    redirect:"/index",
    component:()=>import("../views/layout.vue"),
    children:[
      {
        path:"/index",
        name:"Index",
        component:()=>import("../views/index.vue")
      },
      {
        path:"/account/all",
        name:"Account_All",
        meta:["账户管理","所有人员"],
        component:()=>import("../views/account/all.vue")
      },
      {
        path:"/account/business",
        name:"Account_Business",
        meta:["账户管理","业务人员"],
        component:()=>import("../views/account/business.vue")
      }
    ]
  }
]

const router = new VueRouter({
  routes
})

export default router
