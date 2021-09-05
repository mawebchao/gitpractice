<template>
  <div>
    <el-breadcrumb separator="/">
      <el-breadcrumb-item v-for="(item,index) in routeitems" :key="index">{{item}}</el-breadcrumb-item>
    </el-breadcrumb>
  </div>
</template>

<script>
import BreadCrumb from "../../mixins/breadcrumb";

export default {
    mixins: [BreadCrumb]
};
</script>

<style scoped>
</style>