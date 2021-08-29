<template>
  <div id="app">
    <div id="nav">
      <!-- <h1>我是{{sex}}的，今年{{age}}岁，有{{money}}元</h1>
      <h2>{{hhh}}</h2> -->
      <h2>{{msg}}</h2>
      <h2>{{info}}</h2>
      <h2>{{txt}}</h2>
      <button @click="pay">花钱</button>
      <button @click="zhuanqian">挣钱</button>
      <router-link :to="{name:'About',params:{id:id}}">about页面</router-link>
      <router-link :to="{name:'Home',params:{id:id}}">home页面</router-link>
      <!-- router-link 
      1.可以用字符串路径
      2.可以用对象,用path或者name跳转都可以 -->
    </div>
    <router-view/>
  </div>
</template>

<script>
import {mapState, mapGetters, mapMutations} from 'vuex'
export default {
  data(){
    return{
      id:123,
      a:1,
      b:2,
      gender:this.$store.getters.meiyuan(8).toFixed(2)
    }
  },
  computed:{
    txt(){
      return this.$store.getters.rmb1
    },
    c(){
      return this.a+this.b;
    },
    ...mapState(["msg"]),
    ...mapGetters(['info'])
  },
  mounted(){
    this.id=456
  },
  methods:{
    ...mapMutations(["pay","make"]),
    zhuanqian(){
      this.make({money:100});
    }
  }
  
}
</script>

<style lang="less">
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

#nav {
  padding: 30px;

  a {
    font-weight: bold;
    color: #2c3e50;

    &.router-link-exact-active {
      color: #42b983;
    }
  }
}
</style>
