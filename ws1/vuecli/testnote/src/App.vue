<template>
  <div id="app">
    <el-container>
      <el-header>
        <my-header />
      </el-header>
      <el-main>
        <my-main />
      </el-main>
    </el-container>
    <my-window v-show="$store.state.showCreate"></my-window>
    
  </div>
</template>

<script lang="ts">
import Vue from "vue";
import MyHeader from "./components/MyHeader.vue";
import MyMain from "./components/MyMain.vue";
import RecordCtr from "./utils/RecordHelper_controller";
import Record from './pojo/Record';
import MyWindow from './components/CreateWindow.vue'
export default Vue.extend({
  components: {
    MyHeader,
    MyMain,
    MyWindow
  }
});

// let dh=new LocalDataHelper("jlData")
// let content = {
//   content: "今天是美好的一天hhhh",
//   title: "今天你在干嘛"
// };
let content1 = {
  content: "frdhjnfk",
  title: "今天你在干嘛"
};
// let dataCtr = new RecordCtr();
// dataCtr.addRecord(content1)
// dataCtr.delRecord(1+"")
</script>

<style lang="less">
#app {
  height: 100%;
  background-image: url("./assets/background.jpg") ;
}
.el-main
{
  padding: 0 !important;
}
.el-header {
  padding: 0 !important;
  background: white;
  height: 80px !important;
}
</style>
