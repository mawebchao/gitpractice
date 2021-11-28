<template>
  <div class="outerWrapperClass">
    <el-table :data="appList" border>
      <el-table-column prop="name" label="应用权限" width="550px"></el-table-column>
      <el-table-column label="操作权限" width="750px">
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
    this.$nextTick(function() {
      this.$on("childBatchSaveMethod", function() {
        // console.log("批量保存appList", this.appList);
        let appListToSave:any=[]
        this.appList.forEach(element => {
          let nowElement=element;
          let nowOperationList=[]
          element.operationList.forEach(operation => {
            if(operation!=""){
              // operation=operation.
              console.log(operation)
              nowOperationList.push(operation)
            }
          });
          nowElement.operationList=nowOperationList
          appListToSave.push(nowElement)
        });
        console.log("this.appListToSave", appListToSave);
        let roleId = 8;
        defaultAxios
          .post(`/sys/operation/batchAdd?roleId=${roleId}`, appListToSave)
          .then(res => {
            console.log(res);
          });
      });
    });
    defaultAxios.get("/sys/operation/8").then(res => {
      this.appList = res.data.data;
      // console.log(this.appList);
    });
  }
}
</script>

<style scoped lang="less">
.outerWrapperClass {
  margin-top: 12px;
}
</style>