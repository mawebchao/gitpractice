<template>
  <div class="outerWrapperClass">
    <el-table :data="appList" border>
      <el-table-column prop="name" label="应用权限" width="350px"></el-table-column>
      <el-table-column label="操作权限" width="350px">
        <template slot-scope="scope">
          <!-- slot-scope="scope" -->
          <el-checkbox-group v-model="scope.row.operationList">
            <el-checkbox label="save">暂存</el-checkbox>
            <el-checkbox label="submit">提交</el-checkbox>
            <el-checkbox label="delete">删除</el-checkbox>
          </el-checkbox-group>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script lang="ts">
import { Component, Vue } from "vue-property-decorator";
import { defaultAxios } from "../axios/index";

@Component
export default class extends Vue {
  appList = [];

  mounted() {
    defaultAxios.get("/sys/operation/8").then(res => {
      this.appList = res.data.data;
    });
  }
}
</script>

<style scoped lang="less">
.outerWrapperClass {
  margin-top: 12px;
}
</style>