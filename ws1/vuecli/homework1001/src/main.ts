import Vue from 'vue'
import App from './App'
import 'element-ui/lib/theme-chalk/index.css';
import router from './router'
import store from './store'
import ElementUI from 'element-ui'
import axios from 'axios'
import func from './model/User'
import VueQuillEditor from 'vue-quill-editor'

/* 导入富文本编辑器对应的样式 */
import 'quill/dist/quill.core.css' // import styles
import 'quill/dist/quill.snow.css' // for snow theme
import 'quill/dist/quill.bubble.css' // for bubble theme
Vue.use(func)
Vue.config.productionTip = false
Vue.use(ElementUI)
Vue.prototype.$axios=axios
axios.defaults.baseURL = 'http://localhost:8091'
Vue.prototype.$newUser=(id:number,name:string)=>alert("frd")
Vue.use(VueQuillEditor)

Vue.filter("priceFormat",function(price){

  return (price / 100).toFixed(2)
})
new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
