<template>
  <div class="allContainerClass">
    <!-- 定义布局容器 -->
    <el-container class="home-container">
      <!-- 定义头标签 -->
      <el-header>
        <div>
          <img src="../assets/warehouse.png" width="50" height="50" />
          <span>进销存后台管理系统</span>
        </div>
        <!-- <el-button type="info">退出</el-button> -->
        <div @click="showSelectingDialogue=!showSelectingDialogue">
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
        <el-aside width="350px">
          <div class="newRoleButtonWrapClass">
            <el-button native-type="button" class="newRoleButtonClass">新建角色</el-button>
          </div>
          <div class="roleSearchInputWrapClass">
            <el-input
              type="text"
              placeholder="搜索角色"
              size="medium"
              class="roleSearchInputClass"
              v-model="inputedSearchRoleName"
            />
            <i
              class="el-icon-search searchIconClass"
              @click="filterRoleListByNameWithFuzzyMatching"
            ></i>
          </div>
          <el-menu
            background-color="#2C3E50"
            text-color="#fff"
            active-text-color="#4094ff"
            unique-opened
            router
            class="menuClass"
          >
            <el-menu-item
              v-for="(role,index) in nowRoleList"
              :key="role.id"
              :class="indexInRoleList==index?'roleClassInHighlight':'roleClassNotInHighlight'"
              @click="changeIndexInRoleList(index)"
            >
              <!-- @click="defaultActiveMenu(childrenMenu.path)" -->
              <template slot="title">
                <i class="el-icon-menu"></i>
                <span>{{role.name}}</span>
              </template>
            </el-menu-item>
          </el-menu>
        </el-aside>

        <!-- 定义主页面结构-->
        <el-main class="contentclass">
          <transition name="fade">
            <el-card class="box-card" v-show="showSelectingDialogue">
              <ul>
                <li
                  @click="oauthCheck('权限管理')"
                  @mouseenter="mouseenter_f(0)"
                  @mouseleave="mouseleave_f"
                  :class="nowlistindex==0?'onclass':''"
                >权限管理</li>
                <li
                  @click="logout"
                  @mouseenter="mouseenter_f(1)"
                  @mouseleave="mouseleave_f"
                  :class="nowlistindex==1?'onclass':''"
                >退出</li>
              </ul>
            </el-card>
          </transition>
          <!--主要内容组件-->
          <RoleMan/>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script lang="ts">
import { Component, Vue } from "vue-property-decorator";
import { defaultAxios } from "../axios/index";
import  RoleMan  from "../components/RoleMan.vue";

@Component({
  components: {
    RoleMan
  }
})
export default class extends Vue {
  inputedSearchRoleName = "";
  rolelist = [];
  nowRoleList = [];
  showSelectingDialogue = false;
  isCollapseTransition = false;
  nowlistindex = -1;
  indexInRoleList = 1;
  mouseenter_f(index: number) {
    this.nowlistindex = index;
  }
  logout() {
    window.sessionStorage.removeItem("token");
    this.$router.push("/login");
  }
  mouseleave_f() {
    this.nowlistindex = -1;
  }
  filterRoleListByNameWithFuzzyMatching() {
    this.nowRoleList = this.rolelist.filter(
      (role: any) => role.name == this.inputedSearchRoleName
    );
  }
  changeIndexInRoleList(newIndex: number) {
    this.indexInRoleList = newIndex;
  }
  mounted() {
    defaultAxios.get("/sys/role/get/getAllInList/4").then(res => {
      this.rolelist = res.data.data;
      this.nowRoleList = this.rolelist;
    });
  }
}
</script>

<style scoped lang="less">
.roleClassInHighlight {
  background-color: #b3e0ff !important;
}
.roleClassNotInHighlight {
  background-color: #d3e7fb !important;
}
.menuClass {
  li {
    // background-color: #d3e7fb !important;
    color: black !important;
  }
}
.roleSearchInputWrapClass {
  text-align: center;
  margin-top: 10px;
  position: relative;
  .searchIconClass {
    position: absolute;
    right: 13%;
    top: 11px;
    cursor: pointer;
  }
}
.roleSearchInputClass {
  width: 80%;
}
.newRoleButtonWrapClass {
  text-align: center;
  margin-top: 10px;
}
.newRoleButtonClass {
  background: #107fff;
  color: white;
}
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
  background-color: #d3e7fb;
  height: 100%;
  width: 90px;
  border-right: 1px solid darkgrey;
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