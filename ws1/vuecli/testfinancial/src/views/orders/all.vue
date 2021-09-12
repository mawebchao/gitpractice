<template>
  <div>
    <el-breadcrumb separator="/" style="margin-bottom:20px">
      <el-breadcrumb-item v-for="(item,index) in routeitems" :key="index">{{item}}</el-breadcrumb-item>
    </el-breadcrumb>
    <el-row>
      <el-col>
        <el-card>
          <el-radio-group v-model="nowradio">
            <el-radio-button label="1">待审核</el-radio-button>
            <el-radio-button label="2">审核中</el-radio-button>
            <el-radio-button label="3">审核通过</el-radio-button>
            <el-radio-button label="4">审核拒绝</el-radio-button>
            <el-radio-button label="5">已放款</el-radio-button>
          </el-radio-group>
          <keep-alive>
            <component :is="nowradiocomponent"></component>
          </keep-alive>
        </el-card>
      </el-col>
    </el-row>
  </div>
</template>

<script>
import BreadCrumb from "../../mixins/breadcrumb";
import myradio1 from "./myradios/radio1";
import myradio2 from "./myradios/radio2";
export default {
  mixins: [BreadCrumb],
  data() {
    return {
      nowradio: "1"
    };
  },
  computed: {
    nowradiocomponent() {
      return "myradio" + this.nowradio;
    }
  },
  components: {
    myradio1,
    myradio2
  }
};
</script>

<style scoped>
</style>