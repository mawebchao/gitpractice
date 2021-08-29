<template>
  <div>
    <div class="wrap">
      <div class="search_part">
        <input v-model="name" placeholder="搜食谱食材" class="search" />
        <span style="color:white" @click="search">搜索</span>
      </div>
    </div>

    <div>
      <div v-for="item in hot" :key="item.id">
        <div :style="{width:'200px',height:'50px',background:'url('+item.pic+')'}"></div>
        <img :src="item.pic" />
        <p>{{item.name}}</p>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      name: "",
      hot: [],
      tabBar: [{ title: "首页", url: "./../assets/logo.png" }]
    };
  },
  mounted() {
    this.getHot();
  },
  methods: {
    getHot(){
      this.getData("牛肉",4);
    },
    getData(keyword,num) {
      this.$axios
        .get("/api", {
          params: { num: num, keyword: keyword, appkey: "50a66ecc80aa2503" }
        })
        .then(res => {
          this.hot = res.data.result.list;
          console.log(this.hot);
        });
    },
    search(){
      this.$router.push("/list?search="+this.name);
    }
  }
};
</script>

<style scoped>
.bg {
}
.search_part {
  width: 80%;
  margin: auto;
  padding-top: 80px;
}
.wrap {
  background: rgb(27, 26, 31);
  height: 150px;
}
.search {
  width: 100%;
  height: 50px;
  border: none;
  border-radius: 10px;
  outline: none;
}
</style>