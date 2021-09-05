<template>
  <div>
    <el-dropdown style="margin-top:30px;float:right;line-height:20px;font-size:20px;">
      <span class="el-dropdown-link">
        欢迎您，
        <span>{{username}}</span>
        <i class="el-icon-arrow-down el-icon--right"></i>
      </span>
      <el-dropdown-menu slot="dropdown">
        <el-dropdown-item>个人中心</el-dropdown-item>
        <el-dropdown-item>修改密码</el-dropdown-item>
        <el-dropdown-item>退出登录</el-dropdown-item>
      </el-dropdown-menu>
    </el-dropdown>
    <div
      style="float:right;font-size:20px;line-height:20px;margin-top:30px;margin-right:30px;font-family:'SongTi';"
    >
      今天是您在樱花金融的第
      <span style="font-size:30px;color:darkblue">{{timein}}</span>天
    </div>
    <div style="clear:both"></div>
  </div>
</template>

<script>
import { get } from "../utils/http.js";
export default {
  data() {
    return {
      timein: "",
    };
  },
  mounted() {
    get("/in").then(res => {
      var totalMinute = this.$moment(this.$moment().locale('zh-cn').format('YYYY-MM-DD HH:mm:ss')).diff(res.time) / (1000 * 60);
      var hours = Math.floor(totalMinute / 60);
      this.timein=Math.floor(hours / 24);
    });
  },
  computed: {
    timespan() {
      return "";
    },
    username(){
      return sessionStorage.getItem("username")
    }
  }
};
</script>

<style scoped>
</style>