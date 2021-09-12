<template>
  <div>
    <el-breadcrumb separator="/" style="margin-bottom:20px">
      <el-breadcrumb-item v-for="(item,index) in routeitems" :key="index">{{item}}</el-breadcrumb-item>
    </el-breadcrumb>
    <el-card style="margin-bottom:20px">
      <el-row :gutter="20">
        <el-col :span="6">
          <div class="grid-content bg-purple">
            <el-input v-model="searchobj.name" placeholder="产品名称"></el-input>
          </div>
        </el-col>
        <el-col :span="6">
          <div class="grid-content bg-purple;">
            <el-select v-model="searchobj.lilv" placeholder="利率" style="width:100%">
              <el-option
                v-for="item in options"
                :key="item.value"
                :label="item.label"
                :value="item.value"
              ></el-option>
            </el-select>
          </div>
        </el-col>
        <el-col :span="6">
          <div class="grid-content bg-purple">
            <el-date-picker
              v-model="searchobj.datespan"
              type="datetimerange"
              range-separator="至"
              start-placeholder="开始日期"
              end-placeholder="结束日期"
              align="right"
            ></el-date-picker>
          </div>
        </el-col>
        <el-col :span="4" :offset="2">
          <div class="grid-content bg-purple">
            <el-button type="primary">查询</el-button>
            <el-button type="primary">重置</el-button>
            <span class="el-dropdown-link" v-show="!dropdownvisible" @click="dropdownvisible=true;">
              展开
              <i class="el-icon-arrow-down el-icon--right"></i>
            </span>
            <span class="el-dropdown-link" v-show="dropdownvisible" @click="dropdownvisible=false;">
              收起
              <i class="el-icon-arrow-up el-icon--right"></i>
            </span>
          </div>
        </el-col>
      </el-row>
      <el-row :gutter="20" v-show="dropdownvisible" style="margin-top:20px">
        <el-col :span="6">
          <div class="grid-content bg-purple">
            <el-input v-model="searchobj.name" placeholder="产品类别"></el-input>
          </div>
        </el-col>
        <el-col :span="6">
          <div class="grid-content bg-purple">
            <el-input v-model="searchobj.name" placeholder="最高分期数"></el-input>
          </div>
        </el-col>
        <el-col :span="6">
          <div class="grid-content bg-purple">
            <el-input v-model="searchobj.name" placeholder="状态"></el-input>
          </div>
        </el-col>
      </el-row>
    </el-card>
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
    <el-row>
      <el-col>
        <el-pagination
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
          :current-page="currentPage4"
          :page-sizes="[100, 200, 300, 400]"
          :page-size="100"
          layout="total, sizes, prev, pager, next, jumper"
          :total="400"
        ></el-pagination>
      </el-col>
    </el-row>
  </div>
</template>

<script>
import BreadCrumb from "../../mixins/breadcrumb";
import { get } from "../../utils/http";
export default {
  mixins: [BreadCrumb],
  data() {
    return {
      currentPage4:100,
      tableData: [],
      searchobj: {
        name: "",
        datespan: [],
        lilv: ""
      },
      options: [
        {
          value: "1.8",
          label: "1.8"
        },
        {
          value: "2.6",
          label: "2.6"
        },
        {
          value: "3",
          label: "3"
        },
        {
          value: "3.4",
          label: "3.4"
        },
        {
          value: "4",
          label: "4"
        }
      ],
      dropdownvisible: false
    };
  },
  methods: {
    dropdownclickevent() {
      console.log("下拉框被点击了");
    },
    handleSizeChange(){},
    handleCurrentChange(){}
  },
  mounted() {
    get("/productList").then(res => {
      console.log(res);
      this.tableData = res.data.list;
    });
  }
};
</script>

<style scoped>
input.el-input__inner {
  width: 245.25px;
}
.el-dropdown-link {
  cursor: pointer;
  color: #409eff;
}
</style>