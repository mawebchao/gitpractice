<template>
  <div>
    <el-container>
      <el-aside width="200px">
        <el-menu default-active="2">
          <my-navitem v-for="(navitem,index) in navitemlist" :key="index">{{navitem}}</my-navitem>
        </el-menu>
      </el-aside>
      <el-container>
        <el-main>
          <router-view />
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script>
import MyNavitem from "./components/MyNavitem";
export default {
  components: { MyNavitem },
  data() {
    return {
      navitemlist: []
    };
  },
  mounted() {
    this.$axios.get("/api/block/all").then(res => {
      console.log("res",res)
      // let cyobj=JSON.parse(res.data.message)
      // console.log(cyobj)
    }).catch((error)=>{
      console.log("error",error)
    });
  }
};
</script>

<style scoped></style>
