<template>
  <div class="wrap">
    <div style="width:100%;height:10%;">
      <div class="titlewrap">
        <span
          style="height:100%;display:inline-block;padding-top:0.2rem;"
        >{{memoItem.data.title}}</span>
      </div>
      <div style="float:right;margin-right:0.2rem;margin-top:0.2rem">
        <i class="el-icon-edit" style="font-size:1.5rem" @click="showEdit()"></i>
        <i class="el-icon-delete" style="font-size:1.5rem"></i>
      </div>
    </div>
    <div style="font-size:0.4rem;margin-top:0.4rem;margin-left:0.3rem;height:10%">
      <span style="font-size:inherit">2020-12-9 00:00</span>
      <span style="font-size:inherit;margin-left:0.3rem">分类:生活</span>
    </div>
    <div class="contentwrap">{{memoItem.data.content}}</div>
  </div>
</template>

<script lang="ts">
import { Component, Vue, Prop } from "vue-property-decorator";
@Component
export default class extends Vue {
  @Prop() memoItem!: any;
  showEdit(){
    let nowMemo=JSON.parse(JSON.stringify(this.memoItem))
    // this.$store.commit('changeNowMemoItem',nowMemo.data)
    this.$store.commit('showWindow',{isShow:true,data:nowMemo.data})
    console.log(this.$store.state.nowEditMemoItem)
    
  }
}
</script>

<style scoped>
.contentwrap {
  margin-left: 0.3rem;
  height: 75%;
  width: 93%;
  border: 0.4px solid rgb(85, 85, 85);
  overflow: scroll;
}
.wrap {
  background: white;
  display: inline-block;
  height: 45%;
  width: 45%;
  margin-left: 2.5%;
  margin-right: 2.5%;
  margin-top: 1rem;
  box-shadow: 0.3rem 0.3rem 0.3rem #474040;
}
.titlewrap {
  height: 100%;
  border-bottom: 2px groove #a0a0a0;
  margin-left: 0.3rem;
  margin-top: 0.1rem;
  width: 6rem;
  float: left;
  overflow:hidden;
  white-space: nowrap;
}
</style>