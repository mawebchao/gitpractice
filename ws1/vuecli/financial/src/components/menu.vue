<template>
  <div>
    <el-menu-item v-if="!menu.children" :index="menu.url">
      <i :class="menu.icon"></i>
      <span slot="title">{{menu.name}}</span>
    </el-menu-item>
    <el-submenu v-else :index="menu.url">
      <template slot="title">
        <i :class="menu.icon"></i>
        <span>{{menu.name}}</span>
      </template>
      <nav-menu v-for="(item,index) in menu.children" :menu="item" :key="index"></nav-menu>
    </el-submenu>
  </div>
</template>

<script>
export default {
  name: "NavMenu",
  props: {
    menu: {
      type: Object,
      required: true
    }
  }
};
</script>

<style scoped>
.el-menu-item{margin-left: 10px;}
</style>