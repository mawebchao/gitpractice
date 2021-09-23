<template>
  <div class="talbclass">
    <div style="display:flex;width:100%">
      <my-table
        v-for="(tableitem, index) in tableitemlist"
        :tableData="tableitem"
        :tableitemwidth="tableitemwidth"
        :rowheight="blockheight"
        :key="index"
      ></my-table>
    </div>
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
    (a) => !res.has(a.fangjianhao % 10) && res.set(a.fangjianhao % 10, a)
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
      tableitemwidth: "100%",
      blockheight:"100%"
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
    },
  },
  watch: {
    nowbuildingid(newValue) {
      // if (!this.refresh) {
      this.$axios
        .get("/api/block/getAll?id=" + newValue + "&sno=" + this.nowblockid)
        .then((res) => {
          let resArr = res.data.data.sort(compare("fangjianhao"));
          let tableitem_fangjianhaolist = unique(resArr);
          this.tableitemlist = [];
          for (var i = 0; i < tableitem_fangjianhaolist.length; i++) {
            let tableitem = resArr.filter(
              (item) =>
                item.NAME.charAt(item.NAME.length - 1) ==
                "" +
                  tableitem_fangjianhaolist[i].NAME.charAt(item.NAME.length - 1)
            );
            this.tableitemlist.push(tableitem);
          }
          this.tableitemwidth = 100 / tableitem_fangjianhaolist.length + "%";
          console.log(rowlen)
          let rowlen=Math.ceil((resArr.length/tableitem_fangjianhaolist.length).toFixed(2))
          this.blockheight=80/rowlen
        });
    },
    nowblockid(newValue) {
      // if (!this.refresh) {
      this.$axios
        .get("/api/block/getAll?id=" + this.nowbuildingid + "&sno=" + newValue)
        .then((res) => {
          let resArr = res.data.data.sort(compare("fangjianhao"));
          let tableitem_fangjianhaolist = unique(resArr);
          this.tableitemlist = [];
          for (var i = 0; i < tableitem_fangjianhaolist.length; i++) {
            let tableitem = resArr.filter(
              (item) =>
                item.NAME.charAt(item.NAME.length - 1) ==
                "" +
                  tableitem_fangjianhaolist[i].NAME.charAt(item.NAME.length - 1)
            );
            this.tableitemlist.push(tableitem);
          }
          this.tableitemwidth =
            100 / tableitem_fangjianhaolist.length  + "%";
            let rowlen=Math.ceil((resArr.length/tableitem_fangjianhaolist.length).toFixed(2))
            console.log(rowlen)
          this.blockheight=80/rowlen
        });
      // this.refresh = true;

      // }
    },
  },
};
</script>

<style scoped>
.talbclass {
  display: inline-block;
  height: 100%;
  width: 100%;
}
/* .singletable{width: 200px;} */
</style>
