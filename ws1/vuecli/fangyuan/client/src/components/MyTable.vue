<template>
  <div :style="{width:tableitemwidth}">
    <el-table
      :data="tableData"
      :row-style="{height:rowheight+'rem'}"
      :border="true"
      :row-class-name="tableRowClassName"
    >
      <el-table-column label="房号">
        <template slot-scope="scope">
          <span :style="{display:'inline-block',width:'100%',lineHeight:rowheight+'rem',textAlign:'center',fontSize:rowheight/3+'rem'}">{{ scope.row.NAME.substr(-3,3) }}</span>
        </template>
      </el-table-column>
      <!-- <el-table-column label="房源信息" width="0%" min-width="0%">
        <template slot-scope="scope">
          <p>单价: {{ scope.row.price }}</p>
          <p>面积: {{ scope.row.square }}</p>
          <p>总价: {{ scope.row.totalPrice }}</p>
        </template>
      </el-table-column>
      <el-table-column label="状态" prop="status" width="0%" min-width="0%"></el-table-column>
      <el-table-column label="业主信息" prop="username" width="0%" min-width="0%"></el-table-column> -->
    </el-table>
  </div>
</template>

<script>
export default {
  props: ["tableData", "tableitemwidth","rowheight"],
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
.cell{font-size: 20px;text-align: center;}
</style>