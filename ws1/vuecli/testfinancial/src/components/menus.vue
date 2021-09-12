<template>
  <div>
    <slot></slot>
    <el-menu-item v-if="!menuitemdata.children" :index="menuitemdata.url">
      <i :class="menuitemdata.icon"></i>
      {{menuitemdata.name}}</el-menu-item>
    <el-submenu v-if="menuitemdata.children" :index="menuitemdata.url">
      <template slot="title">
        <i :class="menuitemdata.icon"></i>
        {{menuitemdata.name}}
      </template>
      <nav-menu v-for="item in menuitemdata.children" :key="item.url" :menuitemdata="item"></nav-menu>
    </el-submenu>
  </div>
</template>

<script>
export default {
  name: "NavMenu",
  props: {
    menuitemdata: {
      type: Object,
      required: true
    }
  },
};
</script>

<style scoped>
</style>