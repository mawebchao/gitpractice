<template>
  <div class="about">
    <router-view/>
    <h1>This is an about page</h1>
    <h2>{{msg}}</h2>
    <button @click="change">按钮</button>
  </div>
</template>


<script>
  export default {
    data(){
      return {
        msg:"hello"
      }
    },
    beforeCreate(){
      console.log("组件创建之前")
    },
    created(){
      console.log("组件创建完毕")
    },
    beforeMount(){
      console.log("组件渲染之前")
    },
    //相当于window.onload
    mounted(){
      console.log("组件渲染之后");
      console.log(this.$route.fullPath)
    },
    beforeUpdate(){
      console.log("组件更新之前")
    },
    updated(){
      console.log("组件更新之后")
    },
    beforeDestroy(){
      console.log("组件销毁之前")
    },
    destroyed(){
      console.log("组件销毁之后")
    },
    methods:{
      change(){
        this.msg="你好"
      }
    }
  }
</script>

<style scoped>

</style>