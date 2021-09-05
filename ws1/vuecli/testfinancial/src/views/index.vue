<template>
  <div>
    <el-row :gutter="24" style="margin-bottom:20px">
      <el-col :span="6">
        <el-card shadow="always" class="in">
          <div style="float:left">
            <p>本月进件</p>
            <p style="font-weight:bold">6588</p>
            <p>
              +20.12%
              <span style="font-size:12px">与上月同比</span>
            </p>
          </div>
          <i class="el-icon-tickets ico"></i>
          <div style="clear:both"></div>
        </el-card>
      </el-col>
      <el-col :span="6">
        <el-card shadow="always" class="out">
          <div style="float:left">
            <p>本月放款（元）</p>
            <p style="font-weight:bold">12100000</p>
            <p>
              +1.25%
              <span style="font-size:12px">与上月同比</span>
            </p>
          </div>
          <i class="el-icon-tickets ico"></i>
          <div style="clear:both"></div>
        </el-card>
      </el-col>
      <el-col :span="6">
        <el-card shadow="always" class="allin">
          <div style="float:left">
            <p>累计进件</p>
            <p style="font-weight:bold">1287000</p>
            <p>
              +15.25%
              <span style="font-size:12px">与上月同比</span>
            </p>
          </div>
          <i class="el-icon-date ico"></i>
          <div style="clear:both"></div>
        </el-card>
      </el-col>
      <el-col :span="6">
        <el-card shadow="always" class="allout">
          <div style="float:left">
            <p>累计放款</p>
            <p style="font-weight:bold">254254254</p>
            <p>
              +1.25%
              <span style="font-size:12px">与去年同比</span>
            </p>
          </div>
          <i class="el-icon-coin ico"></i>
          <div style="clear:both"></div>
        </el-card>
      </el-col>
    </el-row>
    <el-row :gutter="12">
      <el-col :span="18">
        <el-card>
          <div slot="header" style="text-align:center;">
            <span>进件统计分析</span>
          </div>
          <div style="height:240px;text-align:center;line-height:60px" ref="analysis"></div>
        </el-card>
      </el-col>
      <el-col :span="6">
        <el-card>
          <div slot="header" style="text-align:center;">
            <span>进件产品占比</span>
          </div>
          <div ref="percent" style="height:240px"></div>
        </el-card>
      </el-col>
    </el-row>
  </div>
</template>

<script>
import * as echarts from "echarts";
export default {
  mounted() {
    this.drawline();
    this.drawpi();
  },
  methods: {
    drawline() {
      //1.第一步：获取容器对象
      console.log(this);
      var myChart = echarts.init(this.$refs["analysis"]);
      //2.第二步：初始化图标配置选项
      var option = {
        xAxis: {
          type: "category",
          boundaryGap: false,
          data: ["Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"]
        },
        yAxis: {
          type: "value"
        },
        series: [
          {
            data: [820, 932, 901, 934, 1290, 1330, 1320],
            type: "line",
            smooth: true,
            areaStyle: {}
          }
        ]
      };
      //3.调用setoption方法
      myChart.setOption(option);
    },
    drawpi() {
      console.log(this);
      var myChart = echarts.init(this.$refs["percent"]);
      //2.第二步：初始化图标配置选项
      var option = {
        tooltip: {
          trigger: "item"
        },
        legend: {
          top: "5%",
          left: "center"
        },
        series: [
          {
            name: "访问来源",
            type: "pie",
            radius: ["40%", "70%"],
            avoidLabelOverlap: false,
            label: {
              show: false,
              position: "center"
            },
            emphasis: {
              label: {
                show: true,
                fontSize: "40",
                fontWeight: "bold"
              }
            },
            labelLine: {
              show: false
            },
            data: [
              { value: 1048, name: "搜索引擎" },
              { value: 735, name: "直接访问" },
              { value: 580, name: "邮件营销" },
              { value: 484, name: "联盟广告" },
              { value: 300, name: "视频广告" }
            ]
          }
        ]
      };
      //3.调用setoption方法
      myChart.setOption(option);
    }
  }
};
</script>

<style scoped>
p {
  line-height: 30px;
  color: #fff;
  font-size: 16px;
}
.in {
  background: #4f88ff;
}
.allin {
  background: #f49b3b;
}
.allout {
  background: #f49b3b;
}
.out {
  background: #f26075;
}
.time .p {
  color: #666666;
}
</style>