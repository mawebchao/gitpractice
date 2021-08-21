
import Home from '../views/Home.vue'
import About from '../views/About.vue'
import Demo from '../views/Demo.vue'
export default  [
    {
      path: '/',
      name: 'Home',
      component: Home
    },
    {
      path: '/about',
      name: 'About',
      // route level code-splitting
      // this generates a separate chunk (about.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      // component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
      //路由懒加载：提高性能，只要进入到这个路径才会渲染这个组件
      component:About,
      //哪个组件有子路由，就在哪个配置项内加children
      //哪个组件有子路由，就在改组件的模板里面添加router-view
      children:[
        {
          //子路由如果不加“/”，默认是在上级路由的基础上叠加
          path:"title",
          name:"Title",
          component:() => import( '../views/Title.vue')
        },
        {
          path:"cont",
          name:"Cont",
          component:() => import( '../views/Cont.vue')
        }
      ]
    },
    {
      path:'/demo',
      component:Demo
    }
  ]