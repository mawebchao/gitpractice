<template>
  <div class="about">
    <router-view />
    <h1>This is an about page</h1>
    <h2>{{msg}}</h2>
    <h2>{{txt2}}</h2>
    <button @click="change">按钮</button>
  </div>
</template>


<script>
import {mapState} from 'vuex'

export default {
  data() {
    return {
      msg: "hello"
    };
  },
  
  beforeCreate() {
    console.log("组件创建之前");
  },
  created() {
    console.log("组件创建完毕");
  },
  beforeMount() {
    console.log("组件渲染之前");
  },
  //相当于window.onload
  mounted() {
    console.log("组件渲染之后");
    console.log(this.$route.fullPath);
    // this.$axios
    //   .get("https://restapi.amap.com/v3/weather/weatherInfo", {
    //     params: { key: "90fdda31fbfac19b54f1d49b1f04ff50", city: "重庆" }
    //   })
    //   .then(function(response) {
    //     console.log(response);
    //   });
    // var instance = this.$axios.create({
    //   baseURL: "https://restapi.amap.com/v3/weather/weatherInfo",
    //   timeout: 1000
    // });
    // instance.get().then((res)=>{
    //   console.log(res);
    // })
    //跨域问题
    // var instance = this.$axios.create({
    //   baseURL: "/api",
    //   timeout: 1000,
    //   params:{
    //     keyword:"白菜",
    //     num:10,
    //     appkey:"50a66ecc80aa2503"
    //   }
    // });
    // instance.get().then((res)=>{
    //   console.log(res);
    // })
    this.$axios
      .get("/api", {
        params: { keyword: "白菜", num: 10 , appkey: "50a66ecc80aa2503"}
      })
      .then(function(response) {
        console.log(response);
      });
  },
  beforeUpdate() {
    console.log("组件更新之前");
  },
  updated() {
    console.log("组件更新之后");
  },
  beforeDestroy() {
    console.log("组件销毁之前");
  },
  destroyed() {
    console.log("组件销毁之后");
  },
  methods: {
    change() {
      this.msg = "你好";
    }
  },
  computed:{
    ...mapState({
      txt2:(state)=>state.moduleB.txt
    })
  }
};
</script>

<style scoped>
</style>