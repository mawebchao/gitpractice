<template>
  <div>
    <div class="tabsWrapClass">
      <!-- <el-tabs v-model="activeName" @tab-click="handleClick" class="tabsClass">
        <el-tab-pane label="角色权限管理" name="perman">
          <RolePermissionMan />
        </el-tab-pane>
        <el-tab-pane label="角色成员管理" name="memman">
          <RoleMemberMan />
        </el-tab-pane>
      </el-tabs>-->
      <div class="tabWrapClass">
        <div class="tabClass" @click="changeComponentIndex(0)" :class="selectedTabIndex==0?'selectTabClass':''">角色权限管理</div>
        <div class="tabClass" @click="changeComponentIndex(1)" :class="selectedTabIndex==1?'selectTabClass':''">角色成员管理</div>
        <el-button class="savebuttonclass" type="primary" @click="batchSave">保存</el-button>
      </div>

      <component :is="currentComponent" :ref="currentComponent"></component>
    </div>
  </div>
</template>

<script lang="ts">
import { Component, Vue } from "vue-property-decorator";
import RoleMemberMan from "./RoleMemberMan.vue";
import RolePermissionMan from "./RolePermissionMan.vue";
@Component({
  components: {
    RoleMemberMan,
    RolePermissionMan
  }
})
export default class extends Vue {
  selectedTabIndex=0;
  nowComponentIndex = 0;
  activeName = "perman";
  componentArr = [ "RolePermissionMan","RoleMemberMan"];
  get currentComponent() {
    return this.componentArr[this.nowComponentIndex];
  }
  changeComponentIndex(index: number) {
    this.nowComponentIndex = index;
    this.selectedTabIndex=index;
  }
  batchSave(){
    (this.$refs[this.currentComponent] as any).$emit("childBatchSaveMethod")
  }
}
</script>

<style scoped lang="less">
// .tabsWrapClass {
//   display: flex;
//   justify-content: center;
//   .tabClass {
//     font-family: "Times New Roman";
//     margin-left: 15px;
//   }
// }
// .tabsClass {
//   width: 400px;
// }
.tabWrapClass{
  width: 100%;
  display:flex;
  justify-content: center;
  position: relative;
  .tabClass{
    margin-left: 15px;
    cursor: pointer;
  }
  .savebuttonclass{
    position: absolute;
    right: 0;
    top: -10px;
  }
}
.selectTabClass{
  border-bottom:1px solid blue;
}
</style>