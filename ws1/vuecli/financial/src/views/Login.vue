<template>
  <div>
    <!-- <el-button :plain="true" @click="open1">成功</el-button>
    <el-button :plain="true" @click="open4">错误</el-button>-->
    <el-row type="flex" justify="center" style="margin-top:100px">
      <el-card class="wrap">
        <div slot="header" class="clearfix">
          <h2 style="text-align:center">蚂蚁金融后台管理系统</h2>
        </div>
        <div>
          <el-form ref="ruleForm" :model="ruleForm" label-width="80px" :rules="rules">
            <el-form-item label="用户名" label-width="70px" prop="name">
              <el-input v-model="ruleForm.name" placeholder="请输入用户名"></el-input>
            </el-form-item>
            <el-form-item label="密码" prop="pass" label-width="70px">
              <el-input
                type="password"
                v-model="ruleForm.pass"
                autocomplete="off"
                placeholder="请输入密码"
              ></el-input>
            </el-form-item>
            <el-form-item>
              <el-button type="primary" @click="onSubmit">登录</el-button>
              <el-button>取消</el-button>
            </el-form-item>
          </el-form>
        </div>
      </el-card>
    </el-row>
    <!-- <button @click="getwithparams">按钮</button> -->
  </div>
</template>

<script>
import { post, get } from "../utils/http";
import { setToken } from "../utils/auth";
export default {
  data() {
    var validateusername = (rule, value, callback) => {
      // 不能为空
      if (value === "") {
        callback(new Error("用户名不能为空"));
      }
      callback();
    };
    var validatepass = (rule, value, callback) => {
      // 需要包含数字和英文字母以及特殊字符，长度不小于8位
      // [0-9].*([a-zA-Z].*[!$#%]|[!$#%].*[a-zA-Z])
      // [a-zA-Z].*([0-9].*[!$#%]|[!$#%].*[0-9])
      // [!$#%].*([0-9].*[a-zA-Z]|[a-zA-Z].*[0-9])
      var patt = /[0-9a-zA-Z%&$#]/;
      console.log(value);
      if (!patt.test(value)) {
        callback(new Error("密码错误!"));
      }
      callback();
    };
    return {
      ruleForm: {
        name: "",
        pass: ""
      },
      rules: {
        pass: [{ validator: validatepass, trigger: "blur" }],
        name: [{ validator: validateusername, trigger: "blur" }]
      }
    };
  },
  methods: {
    onSubmit() {
      this.$refs.ruleForm.validate(valid => {
        if (valid) {
          post("/login", this.ruleForm)
            .then(res => {
              setToken(res.token);
              sessionStorage.setItem("nickname", res.nickname);
              console.log(res.token);
              this.$router.push("/");
            })
            .catch(error => {
              console.log(error);
            });
        }
      });
    },
    successalert() {
      this.$message({
        message: "登录成功",
        type: "success"
      });
    },
    failedalert() {
      this.$message.error("用户名或密码错误");
    },
    getwithparams() {
      get("/getGoodsList/54").then(res => {
        console.log("get带参数测试");

        console.log(res);
      });
    }
  }
};
</script>

<style scoped>
.wrap {
  width: 500px;
}
</style>