<template>
  <div>
    <el-card shadow="hover">
      <div slot="header" class="clearfix">
        <span>新增病人</span>
        <!-- style="float: right; padding: 3px 0"  -->
        <el-button
          style="float: right"
          type="primary"
          icon="el-icon-upload2"
          @click="addRegister"
          >添加病患</el-button
        >
      </div>
      <el-form ref="form" :model="form" label-width="80px">
        <el-form-item label="活动时间">
          <el-col :span="11">
            <el-date-picker
              type="date"
              placeholder="选择日期"
              v-model="form.date"
              style="width: 100%"
            ></el-date-picker>
          </el-col>
        </el-form-item>
        <el-form-item label="患者姓名">
          <el-input v-model="form.name" placeholder="患者姓名"></el-input>
        </el-form-item>
        <el-form-item label="病因">
          <el-select v-model="form.reason" placeholder="病因">
            <el-option label="内科" value="hospital_nk"></el-option>
            <el-option label="皮肤科" value="hospital_pfk"></el-option>
          </el-select>
          <!-- <el-input v-model="form.reason" placeholder="病因"></el-input> -->
        </el-form-item>
      </el-form>
    </el-card>
  </div>
</template>

<script lang="ts">
import { Component, Vue } from "vue-property-decorator";
import { defaultAxios } from "../axios/index";

@Component
export default class extends Vue {
  form = {};

  addRegister() {
    let data = new FormData();
    data.append("queue_name", (this.form as any).reason);
    data.append("msg", (this.form as any).name);
    //注册病患，把病患信息放进队列
    defaultAxios.post("/rgt/register", data)
  }
}
</script>

<style scoped></style>
