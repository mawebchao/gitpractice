<template>
  <div>
    <div class="wrap">
      <input v-model="searchValue" />
      <button style="font-weight:bolder;background:black;border:none;color:white" @click="pushto(searchValue)">搜索</button>
    </div>
    <div>
      <div
        v-for="item in list"
        :key="item.id"
        :style="{fontWeight:'bolder',background:'url('+item.pic+')',backgroundRepeat:'no-repeat' ,width:'234px',height:'234px'}"
        class="itemClass"
        @click="jumptodetail(item.id)"
      >
        <span class="itemtext">{{item.name}}</span>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      searchValue: "",
      list: []
    };
  },
  mounted() {
    this.$axios
      .get("/api/search", {
        params: { keyword: "猪肉", num: 4, appkey: "50a66ecc80aa2503" }
      })
      .then(res => {
        this.list = res.data.result.list;
      });
  },
  methods:{
      pushto(searchValue){
          this.$router.push('/list?searchValue='+searchValue);
      },
      jumptodetail(id){
          this.$router.push('/detail?id='+id);
      }
  }
};
</script>

<style scoped>
.itemtext {
  position: relative;
  top: 150px;
  left: 70px;
  color: #0d6b88;
}
.itemClass {
  margin-left: 20%;
}
.wrap {
  background: black;
  width: 100%;
  height: 80px;
  display: flex;
}
input {
  display: inline-block;
  width: 60%;
  position: relative;
  left: 18%;
  height: 30%;
  top: 35%;
  border-radius: 10px;
}
.wrap button {
  margin-left: 90px;
  width: 40px;
}
</style>