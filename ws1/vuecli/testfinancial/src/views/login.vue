<template>
  <div id="loginapp">
    <el-card class="box-card" type="flex" justify="center">
      <div slot="header" class="clearfix">
        <h2>樱花金融后台管理系统</h2>
      </div>
      <el-form ref="form" :model="form" label-width="80px">
        <el-form-item label="用户名:" style="margin-top:10px">
          <el-input v-model="form.username" type="text"></el-input>
        </el-form-item>
        <el-form-item label="密码:">
          <el-input v-model="form.password" type="password"></el-input>
        </el-form-item>
        <el-form-item style="margin-left:70px">
          <el-button type="primary" @click="login">登录</el-button>
          <el-button>取消</el-button>
        </el-form-item>
      </el-form>
    </el-card>
  </div>
</template>

<script>
import { post } from "@/utils/http.js";
import { setToken } from "@/utils/auth.js";
export default {
  data() {
    return {
      form: {
        username: "",
        password: ""
      }
    };
  },
  methods: {
    login() {
      post("/login", this.form).then(res => {
         this.$message({
            showClose: true,
            message: '恭喜你，登录成功',
            type: 'success'
        })
        let token=res.token;
        setToken(token);
        sessionStorage.setItem("username",res.nickname);
        this.$router.push('/');
        
      }).catch((error)=>{
        console.log(error)
      });
    }
  }
};
</script>

<style scoped>
.clearfix:before,
.clearfix:after {
  display: table;
  content: "";
}
.clearfix:after {
  clear: both;
}
.clearfix {
  text-align: center;
}
.box-card {
  width: 480px;
}
#loginapp {
  display: flex;
  justify-content: center;
  margin-top: 200px;
}
</style>