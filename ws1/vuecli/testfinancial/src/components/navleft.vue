<template>
  <div>
    <span
      style="color:white;font-weight:bolder;font-size:20px;text-align:center;display:inline-block;width:100%;line-height:40px;"
    >樱花金融后台管理系统</span>
    <el-menu
      default-active="2"
      class="el-menu-vertical-demo"
      background-color="#231353"
      text-color="white"
      :router="true"
    >
      <menus v-for="(item,index) in menuitems" :key="index" :menuitemdata="item"></menus>
    </el-menu>
  </div>
</template>

<script>
import menus from "../components/menus";
export default {
    props:["menuitems"],
    components:{menus}
};
</script>

<style scoped>
.el-menu-item {
  margin-left: 10px;
}
.el-menu {
  border-right: none;
}
</style>