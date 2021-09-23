<template>
  <div id="app">
    <!-- <my-container></my-container> -->
<<<<<<< HEAD
    {{count}}
    <button @click="add()">按钮</button>
=======
    <div>{{xiaoqu}}</div>
>>>>>>> 0d1ce36dfb08340961ba58686d6a502d6940b330
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
  data(){
    return{
      count:1
    }
  },
  methods:{
    add(){
      this.count++
    }
  },
  mounted(){
    console.log("Rfd")

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
