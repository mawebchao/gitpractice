<template>
  <div>
    <el-table
      :data="tableData"
      :style="{width:itemwidth+'px'}"
      :border="true"
      :row-class-name="tableRowClassName"
    >
      <el-table-column label="房号" width="70%">
        <template slot-scope="scope">
          <span style="margin-left: 10px">{{ scope.row.NAME.substr(-3,3) }}</span>
        </template>
      </el-table-column>
      <el-table-column label="房源信息" width="180">
        <template slot-scope="scope">
          <p>单价: {{ scope.row.price }}</p>
          <p>面积: {{ scope.row.square }}</p>
          <p>总价: {{ scope.row.totalPrice }}</p>
        </template>
      </el-table-column>
      <el-table-column label="状态" prop="status"></el-table-column>
      <el-table-column label="业主信息" prop="username"></el-table-column>
    </el-table>
  </div>
</template>

<script>
export default {
  props: ["tableData", "itemwidth"],
  mounted() {
    // console.log(this.itemwidth)
  },
  watch: {
    tableData() {
      // console.log("tableData改变了")
    }
  },
  methods: {
    tableRowClassName(row) {
      console.log(row.row);
      switch (row.row.xsstatus) {
        case "已售":
          return "ys";
        case "大定":
          return "dd";
        case "小定":
          return "xd";
        case "锁定":
          return "sd";
        case "未售":
          return "ws";
      }
    }
  }
};
</script>

<style>
.el-table .ys {
  background: rgb(237, 120, 120);
}
.el-table .dd {
  background: rgb(247,242,146);
}
.el-table .xd {
  background: rgb(255,165,0);
}
.el-table .sd {
  background: rgb(158,216,243);
}
.el-table .ws {
  background: rgb(147,203,135);
}
</style>