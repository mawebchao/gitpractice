<template>
  <div class="allContainerClass">
    <!-- 定义布局容器 -->
    <el-container class="home-container">
      <!-- 定义头标签 -->
      <el-header>
        <div>
          <img src="../assets/warehouse.png" width="50" height="50" />
          <span>*****后台管理系统</span>
        </div>
        <!-- <el-button type="info">退出</el-button> -->
        <div @click="showSelectingDialogue = !showSelectingDialogue">
          <img src="../assets/headicon.jpg" width="40" height="40" class="headiconclass" />
          <div class="iconrightclass">
            <span>.</span>
            <span>.</span>
            <span>.</span>
          </div>
        </div>
      </el-header>

      <!-- 定义中间区域-->
      <el-container>
        <!-- 当打开左侧菜单时 宽度为200, 当不打开时为默认值-->
        <el-aside :width="isCollapse ? '0.5px' : '200px'">
          <!-- 这是左侧菜单-->

          <!--定义折叠项-->
          <!-- <div class="leftCollapse" @click="collspseClick">|||</div> -->

          <!--
          background-color 定义背景色
          text-color="#fff"  定义文字颜色
          active-text-color="#4094ff" 选中元素的颜色
          unique-opened 是否只保持一个子菜单的展开
          collapse      是否水平折叠收起菜单（仅在 mode 为 vertical 时可用）
          collapse-transition	是否开启折叠动画 默认不要展现
          router 是否使用 vue-router 的模式，启用该模式会在激活导航时以 index 作为 path 进行路由跳转
          -->
          <!-- id,name,path,children -->
          <el-menu
            background-color="#2C3E50"
            text-color="#fff"
            active-text-color="#4094ff"
            unique-opened
            :collapse="isCollapse"
            :collapse-transition="isCollapseTransition"
            router
          >
            <!-- 定义一级菜单 -->
            <el-submenu :index="menu.id + ''" v-for="menu in menuList" :key="menu.id">
              <!-- 定义一级菜单模版 -->
              <template slot="title">
                <!-- 定义左侧图标-->
                <!-- <i :class="menuIcon[menu.id]"></i> -->
                <!-- 定义菜单名称-->
                <span>{{ menu.name }}</span>
              </template>
              <!-- 定义二级菜单 -->
              <el-menu-item
                :index="childrenMenu.path"
                v-for="childrenMenu in menu.children"
                :key="childrenMenu.id"
                @click="activeMenu(childrenMenu.route)"
              >
                <template slot="title">
                  <i class="el-icon-menu"></i>
                  <span>{{ childrenMenu.name }}</span>
                </template>
              </el-menu-item>
            </el-submenu>
          </el-menu>
        </el-aside>
        <div class="collapseButtonClass">
          <div class="collapseIconClass" style="cursor: pointer">
            <i class="el-icon-caret-right" @click="isCollapse = !isCollapse" v-show="isCollapse"></i>
            <i class="el-icon-caret-left" @click="isCollapse = !isCollapse" v-show="!isCollapse"></i>
          </div>
        </div>
        <!-- 定义主页面结构-->
        <el-main class="contentclass">
          <transition name="fade">
            <el-card class="box-card" v-show="showSelectingDialogue">
              <ul>
                <li
                  @click="oauthCheck('权限管理')"
                  @mouseenter="mouseenter_f(0)"
                  @mouseleave="mouseleave_f"
                  :class="nowlistindex == 0 ? 'onclass' : ''"
                >权限管理</li>
                <li
                  @click="logout"
                  @mouseenter="mouseenter_f(1)"
                  @mouseleave="mouseleave_f"
                  :class="nowlistindex == 1 ? 'onclass' : ''"
                >退出</li>
              </ul>
            </el-card>
          </transition>
          <!-- 定义路由展现页面-->
          <router-view></router-view>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script lang="ts">
import { Component, Vue } from "vue-property-decorator";
import { defaultAxios } from "../axios/index";
@Component
export default class extends Vue {
  nowlistindex = -1;
  showSelectingDialogue = false;
  menuList = [
    // {
    //   id: 1,
    //   name: "订单管理"
    // }
  ];
  isCollapse = false;
  isCollapseTransition = false;
  mounted() {
    //加载左侧导航栏的菜单信息
    let userId = window.sessionStorage.getItem("userId");
    if (userId == null) {
      this.$router.push("/login");
    }
    defaultAxios.get(`/sys/cat/get/all/${userId}`).then(res => {
      // console.log("/sys/cat/get/all/4",res);
      this.menuList = res.data.data;
    });
  }
  async logout() {
    window.sessionStorage.removeItem("token");
    let res = await defaultAxios.get(
      "/sys/user/getUserByUserId?userId=" +
        window.sessionStorage.getItem("userId")
    );
    // console.log("当前登录的用户信息：",res)
    //判断当前用户的角色，如果是医生，则删除他自己的那个消费者通道，之后它占用的消息会回到reday状态
    let roleIds: any[] = res.data.data.roleIds
      .replace("[", "")
      .replace("]", "")
      .split(",");
    let username = res.data.data.username;
    if (roleIds.indexOf("10") != -1) {
      let data = new FormData();
      data.append("queue_name", "hospital_nk");
      data.append("name", username);
      defaultAxios.post("/rgt/outPatient/logoutDoctor", data);
    }
    this.$router.push("/login");
  }
  oauthCheck(authStr: string) {
    let nowvue = this;
    // let token:string="";
    defaultAxios
      .get("/myauth/oauth/check_token", {
        params: {
          token: window.sessionStorage.getItem("token")
        }
      })
      .then(function(response) {
        console.log(response);
        if (response.data.authorities.indexOf(authStr) != -1)
          nowvue.$router.push("/permission");
        else {
          nowvue.$message.error("没有权限");
        }
      })
      .catch(function(e) {
        //失败时执行catch代码块
        console.log("error", e);
        nowvue.$message.error("登录信息失效");
        nowvue.$router.push("/login");
      });
  }
  mouseenter_f(index: number) {
    this.nowlistindex = index;
  }
  mouseleave_f() {
    this.nowlistindex = -1;
  }
  activeMenu(path) {
    console.log(path)
    this.$router.push(path);
  }
}
</script>

<style scoped lang="less">
.onclass {
  background: rgb(114, 203, 255);
}
.fade-enter-active,
.fade-leave-active {
  transition: opacity 0.8s;
}
.fade-enter, .fade-leave-to /* .fade-leave-active below version 2.1.8 */ {
  opacity: 0;
}
ul {
  list-style: none;
}
.contentclass {
  position: relative;
}
.box-card {
  width: 140px;
  position: absolute;
  right: 10px;
  top: 5px;
  // transition: all 2s cubic-bezier(0.19, 1, 0.22, 1);
  li {
    cursor: pointer;
    margin-top: 10px;
    font-size: 16px;
  }
}
.iconrightclass {
  margin-left: -10px;
  display: flex;
  flex-direction: column;
  justify-content: center;
  height: 60px;
  margin-top: -4px;
  span {
    display: inline-block;
    height: 10px;
    line-height: 5px;
    font-weight: bold;
  }
}
.headiconclass {
  border-radius: 50%;
  cursor: pointer;
}
.collapseButtonClass {
  display: flex;
  background: #fafbfd;
  flex-direction: column;
  justify-content: center;
  width: 10px;
  overflow: hidden;
  .collapseIconClass {
    height: 40px;
    background: #d9dde6;
    display: flex;
    flex-direction: column;
    justify-content: center;
    margin-left: -4px;
  }
}
.allContainerClass {
  height: 100%;
}
.el-header {
  background-color: #557391;
  display: flex; //灵活的盒子容器
  justify-content: space-between; //左右对齐
  align-items: center; //文本元素居中对齐
  color: #ffffff; //设定字体颜色
  padding-left: 1px;

  > div {
    display: flex;
    align-items: center;

    span {
      margin-left: 15px;
      font-size: 25px; //设定字体高度
    }
  }
}

.el-aside {
  background-color: #2c3e50;
  height: 100%;
  width: 90px;
  .el-menu {
    border-right: none;
  }
}

.el-main {
  background-color: #eeeeee;
}

.home-container {
  height: 100%;
  width: 100%;
}

.iconfont {
  margin-right: 8px;
}

.leftCollapse {
  background-color: #708090;
  font-size: 10px;
  line-height: 30px;
  color: #ffffff;
  text-align: center;
  letter-spacing: 4px;
  cursor: pointer;
}
</style>
