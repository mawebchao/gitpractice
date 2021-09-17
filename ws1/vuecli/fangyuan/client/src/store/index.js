import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    buildingid: "",
    blockid: -1,
  },
  mutations: {
    setBuildingId(state,payload) {
      state.buildingid = payload.newbuildingid
    },
    setBlockId(state,payload) {
      state.blockid = payload.newblockid
    }
  },
  actions: {
  },
  modules: {
  }
})
