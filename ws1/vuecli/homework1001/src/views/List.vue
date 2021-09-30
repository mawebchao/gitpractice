<template>
  <div>
    <el-table :data="tableData" style="width: 100%">
      <el-table-column prop="id" label="ID" width="180"></el-table-column>
      <el-table-column prop="name" label="姓名" width="180"></el-table-column>
      <el-table-column prop="age" label="年龄"></el-table-column>
      <el-table-column prop="sex" label="性别"></el-table-column>
    </el-table>
  </div>
</template>

<script lang="ts">
import { Component, Vue } from "vue-property-decorator";
import User from "../model/User";
import axios from 'axios'

@Component
export default class extends Vue {
  tableData: User[] = [];
//   $axios:any;
  async mounted(){
      this.tableData=(await this.$axios.get('/api/user/all')).data
  }
}
</script>

<style scoped>
</style>