import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import elementui from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css';
import "@/common/common.css"
import '@/permission.js'
require("./mock/mock.js");
import moment from 'moment'
import axios from 'axios'
import Plugin from 'v-fit-columns';
Vue.use(Plugin);
Vue.prototype.$moment=moment
Vue.prototype.$axios=axios
Vue.config.productionTip = false
Vue.use(elementui);
new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
