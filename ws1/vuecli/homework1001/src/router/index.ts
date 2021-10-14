import Vue from 'vue'
import VueRouter, { RouteConfig } from 'vue-router'

Vue.use(VueRouter)

const routes: Array<RouteConfig> = [
  {
    path: "/",
    component: () => import('../views/List.vue'),
    redirect: "/login"
  },
  {
    path: "/add",
    component: () => import('../views/Add.vue')
  },
  {
    path: "/login",
    component: () => import('../views/Login.vue')
  },
  {
    path: "/home",
    component: () => import('../views/Home.vue'),
    redirect:'/user',
    children: [
      {
        path: "/user",
        component: () => import('../views/User.vue'),
      },
      {
        path: "/itemCat",
        component: () => import('../views/ItemCat.vue'),
      },
      {
        path: "/item",
        component: () => import('../views/Item.vue')
      },
      {
        path: "/item/addItem",
        component: () => import('../views/AddItem.vue'),
      }
    ]
  }
]

const router = new VueRouter({
  routes
})
router.beforeEach((to, from, next) => {
  const token = window.sessionStorage.getItem("token")
  if (to.path === '/login') {
    if (token)
      return next('/home')
    else
      return next()
  } else {
    if (token)
      return next()
    else
      return next('/login')
  }

})

export default router
