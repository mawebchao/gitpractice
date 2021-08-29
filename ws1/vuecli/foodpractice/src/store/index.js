import Vue from 'vue'
import Vuex from 'vuex'
Vue.use(Vuex)

export default new Vuex.Store({
    state:{
        msg:"我是可以共享的数据",
        sex:1
    },
    //类似于计算属性
    getters: {
        gender: (state) => {
          return state.sex==1?"男":"女";
        }
      }
})