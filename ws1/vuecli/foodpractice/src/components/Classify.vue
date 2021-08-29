<template>
  <div class="wrap">
    <div class="left">
      <div
        v-for="item in classifylist"
        :key="item.classid"
        @click="detail(item.classid)"
      >{{item.name}}</div>
    </div>
    <div class="right">
      <div v-for="item in foodlist" :key="item.id">
          <h1>{{item.name}}</h1>
          <p>{{item.content}}</p>
          <h3>原材料</h3>
          <p v-for="step in item.material" :key="step.mname">{{step.mname}}{{step.amount}}</p>
          <h3>烹饪步骤</h3>
          <p v-for="(step,index) in item.process" :key="index">{{index+1}}.{{step.pcontent}}</p>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      classifylist: [],
      foodlist: []
    };
  },
  mounted() {
    this.$axios
      .get("/api/class", { params: { appkey: "50a66ecc80aa2503" } })
      .then(res => {
        this.classifylist = res.data.result;
        this.classifylist = this.classifylist.filter(
          item => item.name == "菜系"
        )[0].list;
        console.log(this.classifylist);
      });
  },
  methods: {
    detail(classid) {
      this.$axios
        .get("/api/byclass", {
          params: {
            classid: classid,
            start: 0,
            num: 10,
            appkey: "50a66ecc80aa2503"
          }
        })
        .then(res => {
          this.foodlist=res.data.result.list;
          console.log(this.foodlist);
        });
    }
  }
};
</script>

<style scoped>
.wrap {
  display: flex;
}
.left {
  width: 20%;
  height: 100vh;
  line-height: 40px;
  text-align: center;
}
.right {
  width: 80%;
  height: 100vh;
  overflow: auto;
}
</style>