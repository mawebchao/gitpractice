import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import axios from 'axios'
import './plugins/element.js'
import Global from './global/data.js'


// 全局变量
import g_data from '@/utils/g_data.js'
Vue.prototype.$g_data = g_data


Vue.config.productionTip = false
Vue.use(ElementUI);
Vue.prototype.$axios=axios
Vue.prototype.$global=Global
new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
