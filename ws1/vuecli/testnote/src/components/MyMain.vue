<template>
  <!-- <div class="outwrap"> -->
  <!-- <div class="backgroundclass"></div> -->
  <!-- <scroll class="wrapper" > -->
    <div class="mainwrap">
      <memo-item v-for="memoItem in memoItemList" :key="memoItem.id" :memoItem="memoItem" />
    </div>
  <!-- </scroll> -->
  <!-- </div> -->
</template>

<script lang="ts">
import { Component, Vue } from "vue-property-decorator";
import MemoItem from "./MemoItem.vue";

@Component({
  components: { MemoItem }
})
export default class extends Vue {
  memoItemList: any = this.$store.state.dataHelper.getAll();
}
</script>

<style scoped>
.mainwrap {
  height: 45rem;
  display: flex;
  flex-flow: wrap;
  margin-top: 1rem;
  
  /* background-repeat: repeat-y; */
}
.backgroundclass {
  background-image: url("../assets/background.jpg");
  background-attachment: fixed;
  background-position: top center;
  width: 100%;
  height: 100%;
}
.outwrap {
  width: 100%;
  height: 100%;
}
</style>