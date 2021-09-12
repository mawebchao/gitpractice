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
        meta:{bread:["账户管理","所有人员"],keepalive:true},
        component:()=>import("../views/account/all.vue")
      },
      {
        path:"/account/business",
        name:"Account_Business",
        meta:{bread:["账户管理","业务人员"],keepalive:true},
        component:()=>import("../views/account/business.vue")
      },
      {
        path:"/product/all",
        name:"Product_All",
        meta:["产品管理","全部产品"],
        component:()=>import("../views/product/all.vue")
      },
      {
        path:"/orders/all",
        name:"Orders_All",
        meta:{bread:["订单管理","所有订单"],keepalive:false},
        component:()=>import("../views/orders/all.vue")
      }
    ]
  }
]

const router = new VueRouter({
  routes
})

export default router
