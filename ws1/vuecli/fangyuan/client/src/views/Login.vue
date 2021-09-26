<template>
  <div class="wrapclass">
    <el-card class="box-card">
      <div slot="header" class="clearfix">
        <span class="titleclass">房源系统登录入口</span>
        <el-form
          :model="ruleForm"
          :rules="rules"
          ref="ruleForm"
          label-width="100px"
          class="formclass"
        >
          <el-form-item label="用户名" prop="username" class="contentitemclass">
            <el-input v-model="ruleForm.username"></el-input>
          </el-form-item>
          <el-form-item label="密码" prop="password" class="contentitemclass">
            <el-input v-model="ruleForm.password"></el-input>
          </el-form-item>
          <el-form-item class="contentitemclass">
            <el-button type="primary" @click="getUser('ruleForm')" style="margin-left:-10rem">登录</el-button>
            <el-button>重置密码</el-button>
            <el-link href="#" target="_blank" style="margin-left:3rem">忘记密码</el-link>
          </el-form-item>
        </el-form>
        <div style="display:flex;margin-bottom:-3rem">
          <span style="display:inline-block;">
            <router-link to="/register">注册账号</router-link>
          </span>
        </div>
      </div>
    </el-card>
  </div>
</template>

<script>
export default {
  data() {
    return {
      ruleForm: { username: "", password: "" },
      rules: {
        username: [
          { required: true, message: "请输入用户名", trigger: "blur" },
          { min: 8, message: "长度不得小于 8 个字符", trigger: "blur" }
        ],
        password: [{ required: true, message: "请选择密码", trigger: "blur" }]
      }
    };
  },
  methods: {
    getUser(formName) {
      this.$refs[formName].validate(async valid => {
        if (valid) {
          const result = await this.$axios.get("/koa/user", {
            params: {
              username: this.ruleForm.username,
              password: this.ruleForm.password
            }
          });
          
          if (result.data === "failed")
            this.$message.error("用户名或密码不存在");
          else  {
            localStorage.setItem("token",result.data)
            this.$router.push("/");
          }
        } else {
          return false;
        }
      });
    }
  }
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
