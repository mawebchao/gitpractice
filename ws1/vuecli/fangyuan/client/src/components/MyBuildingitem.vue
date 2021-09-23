<template>
  <div>
    <!-- <p>{{datetime}}</p> -->
    <el-menu-item v-if="!buildingitem.hasChildren" :index="buildingitem.id+''">{{buildingitem.NAME}}</el-menu-item>
    <el-submenu v-if="buildingitem.hasChildren" :index="buildingitem.id+''">
      <template slot="title">{{buildingitem.NAME}}</template>
      <el-menu-item
        v-for="item in buildingitem.children"
        :key="item.id"
        @click="routeToBlock(item)"
      >{{item.sno}}单元</el-menu-item>
    </el-submenu>
  </div>
</template>

<script>
export default {
  props: ["buildingitem"],
  methods: {
    routeToBlock(block) {
      this.$store.commit("setBuildingId", { newbuildingid: block.buildingid });
      this.$store.commit("setBlockId", { newblockid: block.sno });
      // console.log(this.$store.state.buildingid,this.$store.state.blockid)
    }
  },
  data() {
    return {
      datetime: this.$g_data.dateTime
    };
  },
  created() {
    // 回调执行函数 监控命名规则为 watch_+变量名
    this.g_bus.$on("watch_dateTime", (res) => {
      // 具体函数内容
      console.log(res)
      this.datetime=res
    });
  }
};
</script>

<style scoped>
.el-menu-item.is-active {
  color: #000;
}
.el-submenu .el-menu-item {
  margin-left: 60px;
}
</style>