<template>
  <div>
    <!-- <p>{{datetime}}</p> -->
    <!-- <button @click="changedatetime()">按钮</button> -->
    <el-container>
      <el-aside>
        <el-menu text-color="#000" :unique-opened="false" :collapse-transition="true">
          <my-estateitem v-for="(navitem,index) in navitemlist" :key="index" :navitem="navitem"></my-estateitem>
        </el-menu>
      </el-aside>
      <el-container>
        <el-main>
          <!-- <el-button @click="jumptoIdeaSocket()">按钮</el-button> -->
          
          <router-view />
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script>
import MyEstateitem from "./components/MyEstateitem";
import Vue from "vue";
function unique(arr1) {
  const res = new Map();
  return arr1.filter(a => !res.has(a.sno) && res.set(a.sno, a));
}
export default {
  components: { MyEstateitem },
  data() {
    return {
      datetime:this.$g_data.dateTime,
      navitemlist: [],
      ruleForm: {
        id: 2,
        name: "",
        brand: "",
        color: "",
        price: 0,
        type: ""
      }
    };
  },
  beforeCreate() {
    console.log(this.$g_data)
    this.$axios
      .get("/api/estate/all")
      .then(async res => {
        // console.log(res)
        this.navitemlist = this.navitemlist.concat(res.data.data);
        // console.log(this.navitemlist)
        for (var i = 0; i < this.navitemlist.length; i++) {
          await this.$axios
            .get("/api/building/all?id=" + this.navitemlist[i].id)
            .then(async result => {
              
              Vue.set(
                this.navitemlist[i],
                "hasChildren",
                result.data.data.length > 0 ? 1 : 0
              );
              Vue.set(this.navitemlist[i], "children", result.data.data);
              // console.log(this.navitemlist[i].children)
              for (var j = 0; j < this.navitemlist[i].children.length; j++) {
                await this.$axios
                  .get(
                    "/api/block/getAll?id=" +
                      this.navitemlist[i].children[j].sno
                  )
                  .then(result => {
                    Vue.set(
                      this.navitemlist[i].children[j],
                      "children",
                      unique(result.data.data)
                    );
                    if (unique(result.data.data).length > 0) {
                      Vue.set(
                        this.navitemlist[i].children[j],
                        "hasChildren",
                        true
                      );
                    }
                  });
              }
            });
        }
      })
      .catch(error => {
        console.log("error", error);
      });
  },
  created() {
    // 回调执行函数 监控命名规则为 watch_+变量名
    this.g_bus.$on("watch_dateTime", (res) => {
      // 具体函数内容
      console.log(res)
      this.datetime=res
    });
  },
  methods: {
    jumptoIdeaSocket() {
      this.$axios
        .get("/idea/car/save?id=1&brand=BMW&type=435dsf")
        .then(res => {
          console.log(res);
        })
        .catch(error => {
          console.log("error", error);
        });
    },
    changedatetime(){
      console.log("ffrvd")
      this.$g_data.dateTime="2020-1-1 00:00:00"
    }
    
  }
};
</script>

<style scoped>
.el-aside {
  height: 100%;
}
</style>
