<template>
  <div class="talbclass">
    <my-table
      v-for="(tableitem,index) in tableitemlist"
      :tableData="tableitem"
      :itemwidth="itemwidth"
      :key="index"
      class="singletable"
    ></my-table>
    <!-- <el-pagination
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
      :current-page="currentPage"
      :page-size="pageSize"
      layout="total,  prev, pager, next, jumper"
      :total="total"
    ></el-pagination>-->
  </div>
</template>

<script>
function compare(property) {
  return function(a, b) {
    var value1 = a[property];
    var value2 = b[property];
    return value2 - value1;
  };
}
function unique(arr1) {
  const res = new Map();
  return arr1.filter(
    a => !res.has(a.fangjianhao % 10) && res.set(a.fangjianhao % 10, a)
  );
}
// import MyTable from "../components/MyTable";
export default {
  components: {
    "MyTable":()=>{import(/*webpackChunkName:MyTable.js*/'../components/MyTable')}
  },
  methods: {
    // handleSizeChange() {},
    // handleCurrentChange(val) {
    //   this.currentPage = val;
    //   this.nowtableData = this.tableData.filter(
    //     item => item.NAME.charAt(item.NAME.length - 1) == "" + this.currentPage
    //   );
    // }
  },
  data() {
    return {
      tableitemlist: [],
      refresh: false,
      itemwidth: 100
      // currentPage: 1,
      // pageSize: 0,
      // total: 0
    };
  },
  mounted() {},
  computed: {
    nowbuildingid() {
      return this.$store.state.buildingid;
    },
    nowblockid() {
      return this.$store.state.blockid;
    }
  },
  watch: {
    nowbuildingid(newValue) {
      // if (!this.refresh) {
      this.$axios
        .get("/api/block/getAll?id=" + newValue + "&sno=" + this.nowblockid)
        .then(res => {
          let resArr = res.data.data.sort(compare("fangjianhao"));
          let tableitem_fangjianhaolist = unique(resArr);
          this.tableitemlist=[]
          for (var i = 0; i < tableitem_fangjianhaolist.length; i++) {
            let tableitem = resArr.filter(
              item =>
                item.NAME.charAt(item.NAME.length - 1) ==
                "" +
                  tableitem_fangjianhaolist[i].NAME.charAt(item.NAME.length - 1)
            );
            this.tableitemlist.push(tableitem);
          }
          this.itemwidth = 940 / tableitem_fangjianhaolist.length;
        });
      // this.refresh = true;
      // }
    },
    nowblockid(newValue) {
      // if (!this.refresh) {
      this.$axios
        .get("/api/block/getAll?id=" + this.nowbuildingid + "&sno=" + newValue)
        .then(res => {
          let resArr = res.data.data.sort(compare("fangjianhao"));
          let tableitem_fangjianhaolist = unique(resArr);
          this.tableitemlist=[]
          for (var i = 0; i < tableitem_fangjianhaolist.length; i++) {
            let tableitem = resArr.filter(
              item =>
                item.NAME.charAt(item.NAME.length - 1) ==
                "" +
                  tableitem_fangjianhaolist[i].NAME.charAt(item.NAME.length - 1)
            );
            this.tableitemlist.push(tableitem);
          }
          this.itemwidth = 940 / tableitem_fangjianhaolist.length;
        });
      // this.refresh = true;

      // }
    }
  }
};
</script>

<style scoped>
.talbclass {
  display: flex;
}
/* .singletable{width: 200px;} */
</style>