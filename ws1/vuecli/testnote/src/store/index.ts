import Vue from 'vue'
import Vuex from 'vuex'
import Config from '../config/config'
import RecordHelper from '../utils/RecordHelper_controller'

Vue.use(Vuex)
export default new Vuex.Store({
  state: {
    dataHelper:new RecordHelper(),
    cateList:Config.cateList,
    CateType:Config.CateType,
    showCreate:false,
    nowEditMemoItem:{}
  },
  mutations: {
    showWindow(state,newValue){
      state.showCreate=newValue.isShow;
      state.nowEditMemoItem=newValue.data;
    },
    // changeNowMemoItem(state,newValue){
    //   state.nowEditMemoItem=newValue
    // }
  },
  actions: {
  },
  modules: {
  }
})
