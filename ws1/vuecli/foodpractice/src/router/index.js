import Vue from 'vue'
import VueRouter from 'vue-router'
import Index from '../components/Index'
import Classify from '../components/Classify'
import Collection from '../components/Collection'
import My from '../components/My'
import List from '../components/List'
import Detail from '../components/Detail'
Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Index',
    component: Index
  },
  {
    path: '/classify',
    name: 'Classify',
    component: Classify
  },
  {
    path: '/collection',
    name: 'Collection',
    component: Collection
  },
  {
    path: '/my',
    name: 'My',
    component: My
  },
  {
    path: '/list',
    name: 'List',
    component: List
  },
  {
    path: '/detail',
    name: 'Detail',
    component: Detail
  }
  
  
]

const router = new VueRouter({
  routes
})

export default router
