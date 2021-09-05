<template>
  <div style="height:100vh">
    <el-breadcrumb separator="/" style="margin-bottom:20px">
      <el-breadcrumb-item v-for="(item,index) in routeitems" :key="index">{{item}}</el-breadcrumb-item>
    </el-breadcrumb>
    <el-row style="margin-bottom:20px">
      <el-col :span="5">
        <el-input placeholder="请输入内容" class="input-with-select">
          <el-button slot="append" icon="el-icon-search"></el-button>
        </el-input>
      </el-col>
      <el-col :span="8" :offset="11" style="display:flex;justify-content: flex-end;">
        <el-button type="primary">新建角色</el-button>
        <el-button type="success" :disabled="!hasselected">启动</el-button>
        <el-button type="warning" :disabled="!hasselected">冻结</el-button>
        <el-button type="danger" :disabled="!hasselected">删除</el-button>
      </el-col>
    </el-row>
    <el-table
      ref="multipleTable"
      :data="tableData"
      tooltip-effect="dark"
      style="width: 100%"
      @selection-change="handleSelectionChange"
      :fit="true"
    >
      <el-table-column type="selection" width="55"></el-table-column>
      <el-table-column type="index" width="50"></el-table-column>
      <!-- <el-table-column label="日期" width="120">
        <template slot-scope="scope">{{ scope.row.date }}</template>
      </el-table-column>-->
      <el-table-column prop="account" label="账户编号" width="120"></el-table-column>
      <el-table-column prop="id" label="账户id" show-overflow-tooltip width="70px"></el-table-column>
      <el-table-column prop="name" label="姓名" show-overflow-tooltip width="70px"></el-table-column>
      <el-table-column prop="character" label="角色" show-overflow-tooltip></el-table-column>
      <el-table-column prop="remark" label="评价" show-overflow-tooltip></el-table-column>
      <el-table-column prop="reason" label="原因" show-overflow-tooltip></el-table-column>
      <el-table-column label="状态" show-overflow-tooltip width="100px">
        <template slot-scope="scope">
          <span>{{ scope.row.status==1?"已禁用":"已启用" }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" show-overflow-tooltip>
        <template slot-scope="scope">
          <el-button size="mini" @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
          <el-button size="mini" type="danger" @click="handleDelete(scope.$index, scope.row)">删除</el-button>
          <el-button size="mini" :type="scope.row.status==1?'danger':'success'" >{{scope.row.status==1?'禁用':'启用'}}</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
import BreadCrumb from "../../mixins/breadcrumb";
import { get } from "../../utils/http";
export default {
  mixins: [BreadCrumb],
  mounted() {
    get("/all").then(res => {
      this.tableData = res.data.list;
    });
  },
  data() {
    return {
      tableData: [],
      nowselecteditems: []
    };
  },
  methods: {
    handleSelectionChange(selection) {
      this.nowselecteditems = selection;
    }
  },
  computed: {
    hasselected() {
      console.log(this.nowselecteditems.length);
      return this.nowselecteditems.length > 0 ? true : false;
    }
  }
};
</script>

<style scoped>
</style>