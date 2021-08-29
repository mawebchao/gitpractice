<template>
  <div>
    <router-view />
    <div class="tabbar">
      <div class="wrap">
        <div><router-link to="/">首页</router-link></div>
        <div><router-link to="/classify">分类</router-link></div>
        <div><router-link to="/collection">收藏</router-link></div>
        <div><router-link to="/mine">我的</router-link></div>
      </div>
    </div>
  </div>
</template>

<script>
export default {};
</script>

<style scoped>
.tabbar {
  position: fixed;
  bottom: 0;
  height: 60px;
  background: #f4f4f4;
  border-top: 1px solid;
  width: 100%;
}
.wrap {
  height: 60px;
  display: flex;
  justify-content: space-around;
  align-items: center;
  padding: 10px, 10px;
}

</style>