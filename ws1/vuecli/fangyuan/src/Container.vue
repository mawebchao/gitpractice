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
import MyNavitem from './components/MyNavitem'
export default {
    components:{MyNavitem},
    data(){
        return{
            navitemlist:[]
        }
    },
    mounted(){
      console.log("def")
      this.$axios.get('/api').then((res)=>{
        console.log(res)
      })
    }
};
</script>

<style scoped></style>
