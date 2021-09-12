<template>
  <div>
    <el-container>
      <el-aside width="300px" style="background:#231353;height:100vh">
        <nav-left :menuitems="menuitems"></nav-left>
      </el-aside>
      <el-container>
        <el-header>
          <headers></headers>
        </el-header>
        <el-main>
          <keep-alive v-if="$route.meta.keepalive">
            <router-view />
          </keep-alive>
          <router-view v-if="!$route.meta.keepAlive" />
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script>
import Headers from "../components/header";
import NavLeft from "../components/navleft";
import { get } from "../utils/http.js";
export default {
  data() {
    return {
      menuitems: []
    };
  },
  mounted() {
    get("/menu").then(res => {
      this.menuitems = res.data;
    });
  },
  components: { NavLeft, Headers }
};
</script>

<style scoped>
</style>