<template>
  <div class="mainwrap">
    <memo-item v-for="memoItem in memoItemList" :key="memoItem.id" :memoItem="memoItem"/>
    
  </div>
</template>

<script lang="ts">
import { Component, Vue } from "vue-property-decorator";
import MemoItem from "./MemoItem.vue";
@Component({
  components: {MemoItem}
})
export default class extends Vue {
  memoItemList:any=this.$store.state.dataHelper.getAll()
}
</script>

<style scoped>
.mainwrap {
  background: url("../assets/background.jpg");
  height: 45rem;
  display: flex;
  overflow: hidden;
  flex-flow: wrap;
  margin-top: 1rem;
}
</style>