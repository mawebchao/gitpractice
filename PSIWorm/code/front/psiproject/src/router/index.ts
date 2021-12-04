import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Index',
    component: ()=>import("../views/Index.vue"),
    children:[
      {
        path: 'registers',
        name: 'Registers',
        component: ()=>import("../views/Registers.vue")
      },
      {
        path: '/calls/outpatient',
        name: 'OutPatientCalls',
        component: ()=>import("../views/OutPatientCalls.vue")
      }
    ]
  },
  {
    path: '/login',
    name: 'Login',
    component: ()=>import("../views/Login.vue")
  },
  {
    path: '/system',
    name: 'System',
    component: ()=>import("../views/System.vue")
  },
  {
    path: '/permission',
    name: 'Permission',
    component: ()=>import("../views/Permission.vue")
  },
  
]

const router = new VueRouter({
  routes
})

// router.beforeEach((to, from, next) => {
//   const token = window.sessionStorage.getItem("token")
//   if (to.path === '/login') {
//     if (token)
//       return next('/')
//     else
//       return next()
//   } else {
//     if (token)
//       return next()
//     else
//       return next('/login')
//   }

// })

export default router
