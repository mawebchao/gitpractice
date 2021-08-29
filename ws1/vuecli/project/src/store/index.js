import Vue from 'vue'
import Vuex from 'vuex'
import moduleA from './moduleA/index'
import moduleB from './moduleB/index'
Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    sex:1,
    msg:"我是可以共享的数据",
    rmb:100,
    person:{
      name:"小明",
      age:18
    }
  },
  //修改state的唯一的途径--->mutations
  mutations: {
    pay(state){
      state.rmb=state.rmb-1
    },
    make(state,payload){
      state.rmb=state.rmb+payload.money
    },
    change(state){
      state.person.sex="男";
    }
  },
  actions: {
  },
  getters:{
    meiyuan:(state)=>(rate)=>{return state.rmb/rate},
    gender:(state)=>{
      return state.sex==1?"男":"女";
    },
    info(state){
      return state.rmb+"元";
    }
  },
  modules:{
    moduleA,
    moduleB
  }
})
