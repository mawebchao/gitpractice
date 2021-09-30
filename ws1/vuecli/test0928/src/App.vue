<template>
  <div id="app">
    {{msg}}
    <button  @click="addDiv">动态添加组件的按钮</button>
  </div>
</template>

<script>
export default {
  data(){
    return{
      msg:"vue通过extend动态创建全局组件"
    }
  },
  methods:{
    addDiv(){
      this.$toast("老和尚哈哈哈")
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
