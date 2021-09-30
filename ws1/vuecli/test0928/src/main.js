import Vue from 'vue'
import App from './App.vue'
import router from './router'
import toastReg from './js/toast_index.js'
Vue.use(toastReg)
Vue.config.productionTip = false

new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
