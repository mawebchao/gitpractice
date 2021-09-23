<template>
  <div class="wrapclass">
    <el-card class="box-card">
      <div slot="header" class="clearfix">
        <span class="titleclass">房源系统白名单</span>
        <el-form
          :model="ruleForm"
          :rules="rules"
          ref="ruleForm"
          label-width="100px"
          class="formclass"
        >
          <el-form-item
            label="身份证号"
            prop="idnumber"
            class="contentitemclass"
          >
            <el-input v-model="ruleForm.idnumber"></el-input>
          </el-form-item>
          <el-form-item class="contentitemclass">
            <el-button
              type="primary"
              @click="getUser('ruleForm')"
              style="margin-left:4rem"
              >添加</el-button
            >
          </el-form-item>
        </el-form>
      </div>
    </el-card>
  </div>
</template>

<script>
export default {
  data() {
    return {
      ruleForm: { property: "" },
      rules: {
        idnumber: [
          { required: true, message: "请输入身份证号", trigger: "blur" },
          { min: 18, max: 18, message: "长度必须为18位", trigger: "blur" },
        ],
      },
    };
  },
  methods: {
    getUser(formName) {
      this.$refs[formName].validate(async (valid) => {
        if (valid) {
          const result = await this.$axios.post("/koa/whitelist/add", {
            idnumber: this.ruleForm.idnumber,
          });
          if (result.data === "failed")
            this.$message.error("该身份证号已经被添加");
          else if (result.data === "success") {
            this.$message({
              message: "恭喜你，添加成功",
              type: "success",
            });
            this.$nextTick(() => {
              this.$refs[formName].resetFields();
            });
          }else{
              return false;
          }
        } else {
          return false;
        }
      });
    },
  },
};
</script>

<style scoped>
.contentitemclass {
  margin-left: -8rem;
}
.formclass {
  margin-top: 6rem;
}
.titleclass {
  font-size: 4rem;
  margin-left: 10rem;
}
.clearfix:before,
.clearfix:after {
  display: table;
  content: "";
}
.clearfix:after {
  clear: both;
}
.wrapclass {
  margin-top: 20rem;
  margin-left: 5rem;
  margin-right: 5rem;
}
</style>
