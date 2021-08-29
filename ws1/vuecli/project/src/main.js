import Vue from 'vue'
import App from './vue路由二.vue'
import axios from 'axios'
//webpack配置
//如果当前目录下存在router文件夹，那么是去引入router文件夹下的index.js文件
//如果当前目录下不存在router文件夹，会寻找当前目录下的router.vue文件
//如果不存在vue文件，那么会优先去寻找router.js文件

//使用路由的步骤：
//1.定义路由组件：单文件组件
//2.定义路由配置项
//3.创建路由实例，传入配置项
//4.在main.js中引入路由（挂载）

//路由的视图显示
//router-view标签，标签写在哪儿，路由就会渲染到哪里,router-view是用来规定路由的显示位置
import router from './router'
import store from './store'

Vue.config.productionTip = false
Vue.prototype.$axios=axios
//axios.get('请求地址',params:请求参数).then()
//axios.post('请求地址',params:请求参数).then()
new Vue({
  router,
  store,
  render: h => h(App)
  //等同于render:h=>{return h(App)}
  //等同于render:function(h){return h(App)}
  //等同于render:function(createElement){return createElement(App)}
  
}).$mount('#app')
