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
          >下一个病患</el-button
        >
        <el-button
          style="float: right; margin-right: 8px"
          type="primary"
          icon="el-icon-circle-plus"
          @click="addOutpatientDoctor"
          >上班开始叫号</el-button
        >
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
    let username = window.sessionStorage.getItem("username");
    let keshi = window.sessionStorage.getItem("keshi");
    if (roleIds.indexOf("10") != -1) {
      let data = new FormData();
      data.append("queue_name", keshi);
      data.append("name", username);
      defaultAxios.post("/rgt/outPatient/addDoctor", data).then((res: any) => {
        if (res.data === "") {
          let now = this;
          let timer = setInterval(async function () {
            let result: any = await defaultAxios.get(
              `/rgt/outPatient/recursive/nextPatient/${username}`
            );
            if (result !== "") {
              now.$message("患者" + result.data.name + "来到诊室");
              clearInterval(timer);
            }
          }, 1000);
        } else {
          console.log(res);
          this.$message("患者" + res.data.name + "来到诊室");
        }
      });
    }
  }

  addPatient() {
    let roleIds: any[] = JSON.parse(window.sessionStorage.getItem("roleIds"));
    let username = window.sessionStorage.getItem("username");
    let keshi = window.sessionStorage.getItem("keshi");
    if (roleIds.indexOf("10") != -1) {
      let data = new FormData();
      data.append("username", username);
      data.append("queue_name", keshi);
      defaultAxios
        .post("/rgt/outPatient/doctor/nextPatient", data)
        .then((res) => {
          // console.log(res);
          if (res.data === "") {
            let now = this;
            let timer = setInterval(async function () {
              let result: any = await defaultAxios.get(
                `/rgt/outPatient/recursive/nextPatient/${username}`
              );
              if (result !== "") {
                now.$message("患者" + result.data.name + "来到诊室");
                clearInterval(timer);
              }
            }, 1000);
          } else {
            console.log(res);
            this.$message("患者" + res.data.name + "来到诊室");
          }
        });
    }
  }
}
</script>

<style lang="scss" scoped></style>
