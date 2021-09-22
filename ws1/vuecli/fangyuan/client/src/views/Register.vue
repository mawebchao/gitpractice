<template>
  <div class="wrapclass">
    <el-card class="box-card">
      <div slot="header" class="clearfix">
        <span class="titleclass">房源系统用户注册</span>
        <el-form
          :model="regisForm"
          :rules="rules"
          ref="regisForm"
          label-width="100px"
          class="formclass"
        >
          <el-form-item
            label="身份证号"
            prop="idnumber"
            class="contentitemclass"
          >
            <el-input v-model="regisForm.idnumber"></el-input>
          </el-form-item>
          <el-form-item label="用户名" prop="username" class="contentitemclass">
            <el-input v-model="regisForm.username"></el-input>
          </el-form-item>
          <el-form-item label="密码" prop="password" class="contentitemclass">
            <el-input v-model="regisForm.password" type="password"></el-input>
          </el-form-item>
          <el-form-item class="contentitemclass">
            <el-button
              type="primary"
              @click="register('regisForm')"
              style="margin-left:-10rem"
              >注册</el-button
            >
          </el-form-item>
        </el-form>
        <div style="display:flex;margin-bottom:-3rem">
          <span style="display:inline-block;"
            ><router-link to="/login">&lt;&lt;返回</router-link></span
          >
        </div>
      </div>
    </el-card>
  </div>
</template>

<script>
export default {
  data() {
    return {
      regisForm: { username: "", password: "", idnumber: "" },
      rules: {
        username: [
          { required: true, message: "请输入用户名", trigger: "blur" },
          { min: 8, message: "长度不得小于 8 个字符", trigger: "blur" },
        ],
        password: [{ required: true, message: "请选择密码", trigger: "blur" }],
        idnumber: [
          { required: true, message: "请输入身份证号", trigger: "blur" },
          { min: 18, max: 18, message: "长度必须为18位", trigger: "blur" },
        ],
      },
    };
  },
  methods: {
    register(formName) {
      this.$refs[formName].validate(async (valid) => {
        if (valid) {
          const result = await this.$axios.post("/koa/user/create", {
            username: this.regisForm.username,
            password: this.regisForm.password,
            idnumber: this.regisForm.idnumber,
          });
          if (result.data === "success") {
            this.$message({
              message: "恭喜你，注册成功",
              type: "success",
            });
            this.$router.push("/detail");
          }else if(result.data === "not found"){
            this.$message.error(result.data);
          }else{
            this.$message.error('该用户名已被注册');
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
  margin-left: -5rem;
}
.formclass {
  margin-top: 6rem;
}
.titleclass {
  font-size: 4rem;
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
