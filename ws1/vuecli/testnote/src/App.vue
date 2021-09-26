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
import LocalDataHelper from './utils/LocalDataHelper'
export default Vue.extend({
  components: {
    MyHeader,
    MyMain
  }
});

let dh=new LocalDataHelper("jlData")
let content={
  "content":"今天是美好的一天",
  "title":"今天你在干嘛"
};
dh.addData(JSON.stringify(content))
console.log(dh)

</script>

<style lang="less">
#app {
  height: 900px;
}
.el-main,.el-header{padding: 0 !important;}
</style>
