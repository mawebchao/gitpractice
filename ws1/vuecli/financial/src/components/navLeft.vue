<template>
  <div>
    <h1 class="title">樱花金融后台管理系统</h1>
    <el-menu background-color="#001529" text-color="#fff" :router="true">
      <Menus v-for="(item,index) in menuData" :menu="item" :key="index" :index="item.url"></Menus>
    </el-menu>
  </div>
</template>

<script>
import Menus from "../components/menu";
import { get } from "../utils/http";
export default {
  data() {
    return {
      menuData: []
    };
  },
  methods: {
    handleOpen(key, keyPath) {
      console.log(key, keyPath);
    },
    handleClose(key, keyPath) {
      console.log(key, keyPath);
    }
  },
  mounted() {
    get("/menu").then(res => {
      console.log(res);
      this.menuData = res.data;
    });
  },
  components: {
    Menus
  }
};
</script>

<style scoped>
.title{line-height: 100px;background: #001529;color: white;}
.el-menu{border:none;}
</style>