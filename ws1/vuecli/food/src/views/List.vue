<template>
  <div>我是列表页面</div>
</template>

<script>
export default {
  mounted() {
    this.$axios
      .get("/api", {
        params: { num: 10, keyword: this.searchValue, appkey: "50a66ecc80aa2503" }
      })
      .then(res => {
        console.log(res);
      });
  },
  computed:{
      searchValue(){
          console.log("$route改变了");
          return this.$route.query.search;
      }
  }
};
</script>

<style scoped>
</style>