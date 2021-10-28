import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Index',
    component: ()=>import("../views/Index.vue")
  },
  {
    path: '/login',
    name: 'Login',
    component: ()=>import("../views/Login.vue")
  }
]

const router = new VueRouter({
  routes
})

router.beforeEach((to, from, next) => {
  const token = window.sessionStorage.getItem("token")
  if (to.path === '/login') {
    if (token)
      return next('/')
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
