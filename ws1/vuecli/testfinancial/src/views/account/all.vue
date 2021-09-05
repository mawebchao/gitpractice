<template>
  <div style="height:100vh">
    <el-dialog title="新建角色" :visible.sync="createdialoguevisible" width="30%" center>
      <el-form :model="form" :rules="rules" ref="form">
        <el-form-item label="角色" :label-width="formLabelWidth" prop="role">
          <el-input v-model="form.role" autocomplete="off" placeholder="请输入角色名称"></el-input>
        </el-form-item>
        <el-form-item label="创建原因" :label-width="formLabelWidth" prop="reason">
          <el-input v-model="form.reason" autocomplete="off" placeholder="请输入创建原因"></el-input>
        </el-form-item>
        <el-form-item label="备注" :label-width="formLabelWidth" prop="remark">
          <el-input v-model="form.remark" autocomplete="off" placeholder="请输入备注"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="createdialoguevisible = false">取 消</el-button>
        <el-button type="primary" @click="submitForm()">确 定</el-button>
      </div>
    </el-dialog>
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
        <el-button type="primary" @click="clearvalid('form')">新建角色</el-button>
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
          <el-button size="mini" @click="handleEdit( scope.row)">编辑</el-button>
          <el-button size="mini" type="danger" @click="handleDelete( scope.row)">删除</el-button>
          <el-button
            size="mini"
            :type="scope.row.status==1?'danger':'success'"
          >{{scope.row.status==1?'禁用':'启用'}}</el-button>
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
      nowselecteditems: [],
      form: {
        role: "",
        remark: "",
        reason: ""
      },
      createdialoguevisible: false,
      formLabelWidth: "120px",
      rules: {
        role: [
          { required: true, message: "请输入角色名称", trigger: "blur" },
          { min: 3, max: 5, message: "长度在 3 到 5 个字符", trigger: "blur" }
        ],
        reason: [
          {
            required: true,
            message: "请输入创建原因",
            trigger: "blur"
          }
        ]
      }
    };
  },
  methods: {
    handleSelectionChange(selection) {
      this.nowselecteditems = selection;
    },
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          this.createdialoguevisible = false;
        } else {
          console.log("error submit!!");
          return false;
        }
      });
    },
    clearvalid(formName) {
      this.createdialoguevisible = true;
      this.$nextTick(function() {
        this.form = { role: "", remark: "", reason: "" };
        this.$refs[formName].resetFields();
      });
    },
    handleEdit(nowrow) {
      console.log(nowrow);
      this.createdialoguevisible = true;
      this.$nextTick(function() {
        this.$refs["form"].resetFields();
        this.form = {
          role: nowrow.character,
          remark: nowrow.remark,
          reason: nowrow.reason
        };
      });
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