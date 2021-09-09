// components/myaddcart/index.js
Component({
  /**
   * 组件的属性列表
   */
  properties: {
    pophidden: {
      type: Boolean,
      value: true
    }
  },

  /**
   * 组件的初始数据
   */
  data: {
    selectedbaitiaocontend:"",
    baitiao: [
      {
        "desc": "不分期",
        "tip": "先用后付，0服务费",
        "select": true
      },
      {
        "desc": "3期 x 1522.16元起",
        "tip": "含手续费，每期22.50元起，费率0.5%起",
        "select": false
      },
      {
        "desc": "6期 x 772.35元起",
        "tip": "含手续费，每期22.50元起，费率0.5%起",
        "select": false
      },
      {
        "desc": "12期 x 397.38元起",
        "tip": "含手续费，每期22.50元起，费率0.5%起",
        "select": false
      },
      {
        "desc": "24期 x 209.92元起",
        "tip": "含手续费，每期22.50元起，费率0.5%起",
        "select": false
      }
    ],
    baitiaoSelectItem: {
      desc: "【白条支付】首单享立减优惠"
    }
  },

  /**
   * 组件的方法列表
   */
  methods: {
    updateselected(e) {
      let nowbaitiao = this.data.baitiao;
      let clickedindex = e.currentTarget.dataset.index;
      let nowselectedbaitiaocontend=""
      nowbaitiao.forEach(ele => {
        if (ele.select)
          ele.select = !ele.select;
      });
      nowbaitiao[clickedindex].select = !nowbaitiao[clickedindex].select;
      nowselectedbaitiaocontend=nowbaitiao[clickedindex].tip
      this.setData({
        baitiao:nowbaitiao,
        selectedbaitiaocontend:nowselectedbaitiaocontend
      })
    },
    closewindow(){
      this.setData({
        pophidden:true
      })
    },
    dabaitiao(e){
      this.triggerEvent("dabaitiao",this.data.selectedbaitiaocontend)
      this.setData({
        pophidden:true
      })
    }
  }
})
