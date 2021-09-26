import Vue from 'vue'
import Vuex from 'vuex'
import Config from '../config/config'
import RecordHelper from '../utils/RecordHelper_controller'

Vue.use(Vuex)
export default new Vuex.Store({
  state: {
    dataHelper:new RecordHelper(),
    cateList:Config.cateList
  },
  mutations: {
  },
  actions: {
  },
  modules: {
  }
})
