import Vue from 'vue'
import App from './App.vue'
import router from './router'
import '../src/common/common.css'
import Axios from 'axios'
Vue.config.productionTip = false
Vue.prototype.$axios=Axios
new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
