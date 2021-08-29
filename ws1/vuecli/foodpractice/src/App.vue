<template>
  <div id="app">
    <router-view />
    <div class="tabbar">
      <div>
        <router-link to="/">首页</router-link>
      </div>
      <div>
        <router-link to="/classify">分类</router-link>
      </div>
      <div>
        <router-link to="/collection">收藏</router-link>
      </div>
      <div>
        <router-link to="/my">我的</router-link>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  
}
</script>
<style scoped>
.tabbar{position:fixed;bottom: 0;display: flex;justify-items: center;width: 100%;background: #0dc4b4;height: 40px;box-shadow: 9px -7px 20px 0px #89d1cb;}
.tabbar div{width: 25%;text-align: center;line-height: 40px;} 
</style>>


