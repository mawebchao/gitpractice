<template>
  <div>
    <el-tabs v-model="activetab" @tab-click="handleClick">
      <el-tab-pane label="汽车消费" name="carconsumption">
        <el-table
          ref="multipleTable"
          :data="tableData"
          tooltip-effect="dark"
          style="width: 100%"
          :fit="true"
        >
          <el-table-column type="index" width="50" label="序号"></el-table-column>
          <el-table-column prop="name" label="产品名称" width="120"></el-table-column>
          <el-table-column prop="type" label="产品类别" show-overflow-tooltip width="100px"></el-table-column>
          <el-table-column prop="rate" label="利率" show-overflow-tooltip width="70px"></el-table-column>
          <el-table-column prop="date" label="开放日期" show-overflow-tooltip width="140px"></el-table-column>
          <el-table-column label="状态" show-overflow-tooltip width="70px">
            <template slot-scope="scope">
              <span>{{ scope.row.status==1?"已禁用":"已启用" }}</span>
            </template>
          </el-table-column>
          <el-table-column prop="highest" label="最高分期数（月）" show-overflow-tooltip width="140px"></el-table-column>
          <el-table-column prop="number" label="申请客户数量" show-overflow-tooltip width="150px"></el-table-column>
          <el-table-column prop="total" label="累计签约金额" show-overflow-tooltip></el-table-column>
          <el-table-column prop="average" label="件均" show-overflow-tooltip></el-table-column>
          <el-table-column label="操作" show-overflow-tooltip>
            <template slot-scope="scope">
              <el-button
                size="medium"
                :type="scope.row.status==1?'danger':'success'"
              >{{scope.row.status==1?'禁用':'启用'}}</el-button>
            </template>
          </el-table-column>
        </el-table>
      </el-tab-pane>
      <el-tab-pane label="房产消费" name="estateconsumption">配置管理</el-tab-pane>
      <el-tab-pane label="抵押贷款" name="mortgage">角色管理</el-tab-pane>
      <el-tab-pane label="其他" name="others">定时任务补偿</el-tab-pane>
    </el-tabs>
  </div>
</template>

<script>
import { get } from "@/utils/http";
export default {
  methods: {
    handleClick() {}
  },
  mounted() {
    console.log("radio1模块被重新加载了");
    get("/productList").then(res => {
      console.log(res);
      this.tableData = res.data.list;
    });
  },
  data() {
    return {
      tableData: [],
      activetab: "carconsumption"
    };
  }
};
</script>

<style scoped>
</style>