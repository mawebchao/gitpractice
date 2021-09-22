<template>
  <div id="app">
    <!-- <my-container></my-container> -->
    <div>{{xiaoqu}}</div>
    <router-view/>
  </div>
</template>

<script>
// import MyContainer from './Container'
export default {
  name: 'app',
  data(){
    return {
      xiaoqu:""
    }
  },
  components:{
    // MyContainer
  },
  mounted(){
    //请求后端重新加载一遍所有的数据
    // this.$axios.get('/api/block/all').then((res)=>{
    //   console.log(res)
    // })
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 30px;
}
</style>
