<template>
  <div>
    <el-menu-item v-if="!navitem.hasChildren" :index="navitem.id+''">{{navitem.name}}</el-menu-item>
    <el-submenu
      v-if="navitem.hasChildren"
      :index="navitem.id+''"
    >
      <template slot="title">{{navitem.name}}</template>
      <my-buildingitem v-for="item in navitem.children" :key="item.id" :buildingitem="item"></my-buildingitem>
    </el-submenu>
  </div>
</template>

<script>
import MyBuildingitem from "./MyBuildingitem";
export default {
  name: "MyEstateitem",
  props: ["navitem"],
  methods: {
  },
  mounted() {
    
  },
  components: { MyBuildingitem }
};
</script>

<style scoped>
</style>