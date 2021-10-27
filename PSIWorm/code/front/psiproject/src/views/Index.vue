<template>
  <div>
    <!-- 定义布局容器 -->
    <el-container class="home-container">
      <!-- 定义头标签 -->
      <el-header>
        <div>
          <img src="../assets/warehouse.png" width="50" height="50"/>
          <span>进销存后台管理系统</span>
        </div>
        <el-button type="info">退出</el-button>
      </el-header>

      <!-- 定义中间区域-->
      <el-container>
        <!-- 当打开左侧菜单时 宽度为200, 当不打开时为默认值-->
        <el-aside :width="true ? '64px' : '200px' ">
          <!-- 这是左侧菜单-->

          <!--定义折叠项-->
          <div class="leftCollapse">|||</div>

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
            <el-submenu :index="menu.id+''" v-for="menu in menuList" :key="menu.id">
              <!-- 定义一级菜单模版 -->
              <template slot="title">
                <!-- 定义左侧图标-->
                <i :class="menuIcon[menu.id]"></i>
                <!-- 定义菜单名称-->
                <span>{{menu.name}}</span>
              </template>
              <!-- 定义二级菜单 -->
              <el-menu-item
                :index="childrenMenu.path"
                v-for="childrenMenu in menu.children"
                :key="childrenMenu.id"
                @click="defaultActiveMenu(childrenMenu.path)"
              >
                <template slot="title">
                  <i class="el-icon-menu"></i>
                  <span>{{childrenMenu.name}}</span>
                </template>
              </el-menu-item>
            </el-submenu>
          </el-menu>
        </el-aside>

        <!-- 定义主页面结构-->
        <el-main>
          <!-- 定义路由展现页面-->
          <router-view></router-view>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script lang="ts">
import { Component, Vue } from "vue-property-decorator";

@Component
export default class extends Vue {
  menuList = [];
  isCollapse = false;
  isCollapseTransition = false;
}
</script>

<style scoped lang="less">
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