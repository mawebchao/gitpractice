<template>
  <div>
    <el-form label-width="80px" :model="newUser">
      <el-form-item label="姓名">
        <el-input v-model="newUser.name"></el-input>
      </el-form-item>
      <el-form-item label="年龄">
        <el-input v-model="newUser.age"></el-input>
      </el-form-item>
      <el-form-item label="性别">
        <el-radio-group v-model="newUser.sex">
          <el-radio label="男"></el-radio>
          <el-radio label="女"></el-radio>
        </el-radio-group>
      </el-form-item>
    </el-form>
  </div>
</template>

<script lang="ts">
import { Component, Vue } from "vue-property-decorator";
@Component
export default class extends Vue {
  newUser: any= {};
  mounted() {
    console.log(this.$User);
  }
}
</script>

<style scoped>
</style>