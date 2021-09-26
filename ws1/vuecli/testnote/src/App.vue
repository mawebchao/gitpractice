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
  </div>
</template>

<script lang="ts">
import Vue from "vue";
import MyHeader from "./components/MyHeader.vue";
import MyMain from "./components/MyMain.vue";
import RecordCtr from "./utils/RecordHelper_controller";
import Record from './pojo/Record';
export default Vue.extend({
  components: {
    MyHeader,
    MyMain
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
// dataCtr.addRecord(content)
// dataCtr.delRecord(1+"")
</script>

<style lang="less">
#app {
  height: 900px;
}
.el-main,
.el-header {
  padding: 0 !important;
}
</style>
