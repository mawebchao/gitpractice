<template>
  <div class="headerwrap">
    <div style="float:left;">
      <i class="el-icon-s-order" style="font-size:3rem"></i>
    </div>
    <div style="float:right">
      <el-button @click="showCrate()">新建</el-button>
      <el-dropdown style="margin-left:0.8rem">
        <span class="el-dropdown-link">
          全部
          <i class="el-icon-arrow-down el-icon--right"></i>
        </span>
        <el-dropdown-menu slot="dropdown">
          <el-dropdown-item :command="0">工作</el-dropdown-item>
          <el-dropdown-item :command="1">学习</el-dropdown-item>
          <el-dropdown-item :command="2">生活</el-dropdown-item>
        </el-dropdown-menu>
      </el-dropdown>
    </div>
  </div>
</template>

<script lang="ts">
import { Component, Vue } from "vue-property-decorator";

@Component
export default class extends Vue {
  showCrate(){
    console.log("gtdf")
    this.$store.commit('showWindow',{"isShow":true})
  }
}
</script>

<style scoped>
.headerwrap {
  margin-top: 1rem;
  margin-left: 0.5rem;
  margin-right: 0.5rem;
}
</style>