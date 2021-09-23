import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    buildingid: "",
    blockid: -1,
    xiaoqu:""
  },
  mutations: {
    setBuildingId(state,payload) {
      state.buildingid = payload.newbuildingid
    },
    setBlockId(state,payload) {
      state.blockid = payload.newblockid
    },
    setXiaoqu(state,payload) {
      state.xiaoqu = payload.newXiaoqu
    }
  },
  actions: {
  },
  modules: {
  }
})
