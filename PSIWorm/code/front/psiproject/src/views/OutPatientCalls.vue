<template>
  <div>
    <el-card shadow="hover">
      <div slot="header" class="clearfix">
        <span>叫号管理</span>
        <el-button
          style="float: right"
          type="primary"
          icon="el-icon-user-solid"
          @click="addPatient"
        >下一个病患</el-button>
        <el-button
          style="float: right; margin-right:8px"
          type="primary"
          icon="el-icon-circle-plus"
          @click="addOutpatientDoctor"
        >上班开始叫号</el-button>
      </div>
    </el-card>
  </div>
</template>

<script lang="ts">
import { Component, Vue } from "vue-property-decorator";
import { defaultAxios } from "../axios/index";
@Component
export default class extends Vue {
  addOutpatientDoctor() {
    let roleIds: any[] = JSON.parse(window.sessionStorage.getItem("roleIds"));
    let username = JSON.parse(window.sessionStorage.getItem("username"));
    if (roleIds.indexOf("10") != -1) {
      let data = new FormData();
      data.append("queue_name", "hospital_nk");
      data.append("name", username);
      defaultAxios.post("/rgt/outPatient/addDoctor", data).then(res => {
        console.log(res);
        this.$message("患者" + res.data.name + "来到诊室");
      });
    }
  }
  addPatient() {
    let roleIds: any[] = JSON.parse(window.sessionStorage.getItem("roleIds"));
    let username = JSON.parse(window.sessionStorage.getItem("username"));
    if (roleIds.indexOf("10") != -1) {
    //   let data = new FormData();
    //   data.append("queue_name", "hospital_nk");
    //   data.append("name", username);
      defaultAxios.post("/rgt/doctor/nextPatient").then(res => {
        // console.log(res);
        this.$message("患者" + res.data.name + "来到诊室");
      });
    }
  }
}
</script>

<style lang="scss" scoped>
</style>