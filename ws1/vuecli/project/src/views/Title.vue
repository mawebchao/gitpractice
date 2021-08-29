<template>
  <div>我是About页面的标题{{num}}</div>
</template>

<script>
export default {
  mounted() {
    console.log("rvfsvt"+this.$route);
    this.num = this.$route.params.id;
    //注意只改动态路由参数是不会重新组建生命周期的
  },
  data() {
    return {
      num: ""
    };
  },
  
  watch: {
    $route() {
      this.num = this.$route.params.id;
    }
  },
  beforeRouteEnter(to,from,next) {
    console.log(to,from);
    console.log("beforeRouteEnter");
    next();
  },
  beforeRouteLeave(to,from,next) {
    console.log(this.$route.meta);
    next();
  }
};
</script>

<style scoped>
</style>