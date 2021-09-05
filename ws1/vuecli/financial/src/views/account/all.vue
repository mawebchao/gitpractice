<template>
  <div>
    <el-breadcrumb separator="/">
      <el-breadcrumb-item v-for="(item,index) in breadlist" :key="index">{{item}}</el-breadcrumb-item>
    </el-breadcrumb>
    <el-card style="margin-bottom:10px;">
      <el-row>
        <el-col :span="8">
          
        </el-col>
      </el-row>
    </el-card>
  </div>
</template>

<script>
import breadCrumb from "@/mixins/breadcrumb.js";
export default {
  mixins: [breadCrumb],
  methods:{
    
  }
};
//混入
</script>

<style scoped>
</style>