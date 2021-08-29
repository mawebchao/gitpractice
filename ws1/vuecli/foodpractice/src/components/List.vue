<template>
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
</template>

<script>
export default {
  data() {
      return {
          list:[]
      }
  },
  mounted() {
    this.$axios
      .get("/api/search", {
        params: {
          keyword: this.searchValue,
          num: 10,
          appkey: "50a66ecc80aa2503"
        }
      })
      .then(res => {
        this.list = res.data.result.list;
      });
  },
  computed: {
    searchValue() {
      return this.$route.query.searchValue;
    }
  },
  methods:{
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
</style>