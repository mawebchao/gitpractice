<template>
  <div>详情页</div>
</template>

<script>
export default {
  mounted() {
    this.$axios
      .get("/api/detail", {
        params: {
          id: this.nowId,
          appkey: "50a66ecc80aa2503"
        }
      })
      .then(res => {
        console.log(res)
      });
  },
  computed: {
    nowId() {
      return this.$route.query.id;
    }
  }
};
</script>

<style scoped>
</style>