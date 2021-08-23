<template>
  <div id="app">
    <div id="nav">
      <ul>
        <router-link :to="'/page1'" :title="前端/后端开发"><li>前端/后端开发</li></router-link>
        <router-link :to="'/page2'" ><li>大数据/云计算</li></router-link>
        <router-link :to="'/page3'" :title="移动开发/游戏"><li>移动开发/游戏</li></router-link>
        <router-link :to="'/page4'" :title="物联网/测试"><li>物联网/测试</li></router-link>
      </ul>
    </div>
    <router-view/>
  </div>
</template>

<style lang="less">
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

#nav {
  padding: 30px;

  a {
    font-weight: bold;
    color: #2c3e50;

    &.router-link-exact-active {
      color: #42b983;
    }
  }
  ul{
    list-style: none;
    display: inline-block;
    width: 10em;
    margin-left: 2em;
    float: left;
  }
}
</style>
