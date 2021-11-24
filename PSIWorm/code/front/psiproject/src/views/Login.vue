<template>
  <div class="outClass">
    <div class="container">
      <form class="login-form">
        <h1>please login</h1>
        <div class="inputWrapClass">
          <div class="form-control">
            <input type="text" class="input" v-model="loginForm.username" required />
            <!-- onchange="{this.onChange.bind(this,item.key)}" -->

            <label>
              <span
                :style="[{ transitionDelay: 50 * index + 'ms' }]"
                v-for="(chara, index) in 'username'.split('')"
                :key="index"
              >{{ chara }}</span>
            </label>
          </div>
          <div class="form-control">
            <input type="password" class="input" v-model="loginForm.password" required />
            <!-- onchange="{this.onChange.bind(this,item.key)}" -->

            <label>
              <span v-for="(chara, index) in 'password'.split('')" :key="index">{{ chara }}</span>
            </label>
          </div>
        </div>
        <div class="form-control">
          <button type="button" class="btn" @click="login">login</button>
        </div>
        <div class="form-control">
          Don't have an account?
          <a href="/" target="_blank" rel="noopener noreferrer">register</a>
        </div>
      </form>
    </div>
  </div>
</template>

<script lang="ts">
import { Component, Vue } from "vue-property-decorator";
import { defaultAxios } from "../axios/index";
@Component
export default class extends Vue {
  $loginFormRef: any;
  data() {
    return {
      loginForm: {
        username: "",
        password: ""
      }
    };
  }
  resetBtn() {
    //this对象代表当前组件对象
    //console.log(this)
    //实现数据重置
    this.$loginFormRef = this.$refs.loginFormRef;
    this.$loginFormRef.resetFields();
  }
  async login() {
    const { data: result } = await defaultAxios.get("/myauth/oauth/token", {
      params: {
        username: this.$data.loginForm.username,
        password: this.$data.loginForm.password,
        client_id: "gateway-client",
        grant_type: "password",
        client_secret:"123456"
      }
    });
    console.log(result)
    if (result.access_token === null) return this.$message.error("用户登陆失败");
    this.$message.success("用户登录成功");

    //获取用户token信息
    let token = result.access_token;
    window.sessionStorage.setItem("token", token);
    //用户登录成功之后,跳转到home页面
    this.$router.push("/");
  }
}
</script>

<style scoped lang="less">
.outClass {
  background: linear-gradient(180deg, #a2aaf0, #202cda);
  height: 100%;
  display: flex;
}
.container {
  position: relative;
  background: radial-gradient(#e9c2a2, #dda565, #eba140, #ec7a10);
  border-radius: 15px;
  padding: 30px 40px;
  display: flex;
  justify-content: center;
  width: 50%;
  margin: auto;
}
.container form h1 {
  margin-bottom: 30px;
  text-align: center;
  color: #fff;
  text-transform: uppercase;
  font-size: 26px;
  letter-spacing: 2px;
}
.container form .form-control {
  position: relative;
  width: 350px;
  margin: 20px 0 20px;
  color: #fff;
  font-size: 15px;
}
.container form .form-control .input {
  display: block;
  width: 100%;
  color: #fff;
  background-color: transparent;
  outline: none;
  border: none;
  border-bottom: 4px solid #fff;
  font-size: 18px;
  padding: 15px 0;
}
.container form .form-control input:focus,
.container form .form-control input:valid {
  color: #2396ef;
  border-color: #2396ef;
}
.container form .form-control .input:focus + label span,
.container form .form-control .input:valid + label span {
  transform: translateY(-34px);
  color: #2396ef;
}
.container form .form-control label {
  position: absolute;
  left: 0;
  top: 15px;
  color: #fff;
}
.container form .form-control label span {
  display: inline-block;
  min-width: 5px;
  transition: all 0.3s cubic-bezier(0.47, 0, 0.745, 0.715);
  font-size: 22px;
}
.container form .form-control .btn {
  display: inline-block;
  width: 100%;
  padding: 16px 18px;
  outline: none;
  border-radius: 5px;
  border: 1px solid #a381f3;
  background: linear-gradient(90deg, #b57fe7 20%, #b521e2 80%);
  cursor: pointer;
  color: #fff;
  text-transform: capitalize;
  font-size: 18px;
}
.container form .form-control .btn:hover {
  border-color: #ad75e0;
  background: linear-gradient(90deg, #a15ce2 20%, #b10ee2 80%);
}
.container form .form-control a {
  text-decoration: none;
  color: #4c5cec;
  font-size: 20px;
  text-transform: capitalize;
}
.login_container {
  background-color: #2b4b6b;
  height: 100%;
}

.login_box {
  width: 450px;
  height: 300px;
  background-color: #ffffff;
  /* 设定圆弧角*/
  border-radius: 10px;
  position: absolute;
  left: 50%;
  top: 50%;
  transform: translate(-50%, -50%);

  .avatar_box {
    height: 130px;
    width: 130px;
    border: 1px solid #eeeeee;
    border-radius: 50%;
    padding: 10px;
    box-shadow: 0 0 10px #dddddd; /* 添加阴影*/
    position: absolute; /* 绝对定位*/
    left: 50%; /* 距离左侧50%*/
    transform: translate(-50%, -50%); /*回调50%*/
    background-color: #ffffff;
    img {
      height: 100%;
      width: 100%;
      border-radius: 50%;
      background-color: #eeeeee;
    }
  }

  .btns {
    display: flex;
    justify-content: flex-end;
  }

  .login_form {
    position: absolute;
    bottom: 0;
    width: 100%;
    padding: 0 20px;
    box-sizing: border-box;
  }
}
</style>
