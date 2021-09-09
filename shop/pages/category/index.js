// pages/category/index.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    navLeftItems: ["热门推荐", "手机数码", "女装内衣", "男装内衣", "家用电器", "鞋靴箱包", "运动户外", "电脑办公", "美妆护肤", "个护清洁", "生活充值", "家用建材", "家居家纺"],
    navRightItems: [
      [{
        "title": "热门分类",
        "desc": [{
          "text": "U盘",
          "img": "/image/classify/usb.png"
        },
        {
          "text": "牛奶",
          "img": "/image/classify/milk.png"
        },
        {
          "text": "充电宝",
          "img": "/image/classify/power.png"
        },
        {
          "text": "洗衣液",
          "img": "/image/classify/laundry.png"
        },
        {
          "text": "男士内裤",
          "img": "/image/classify/briefs.png"
        },
        {
          "text": "耳机",
          "img": "/image/classify/headset.png"
        },
        {
          "text": "路由器",
          "img": "/image/classify/router.png"
        },
        {
          "text": "吃鸡神器",
          "img": "/image/classify/game.png"
        },
        {
          "text": "剃须刀",
          "img": "/image/classify/shaver.png"
        },
        {
          "text": "大闸蟹",
          "img": "/image/classify/crab.png"
        }
        ]
      },
      {
        "title": "热卖手机",
        "desc": [{
          "text": "小米",
          "img": "/image/classify/miphone.png"
        },
        {
          "text": "华为",
          "img": "/image/classify/huawei.png"
        },
        {
          "text": "vivo",
          "img": "/image/classify/phone.png"
        }
        ]
      },
      {
        "title": "家电热搜",
        "desc": [{
          "text": "微波炉",
          "img": "/image/classify/microwave.png"
        },
        {
          "text": "电饭煲",
          "img": "/image/classify/cooker.png"
        }
        ]
      }
      ],
      [{
        "title": "手机品牌",
        "desc": [{
          "text": "小米",
          "img": "/image/classify/miphone.png"
        },
        {
          "text": "华为",
          "img": "/image/classify/huawei.png"
        },
        {
          "text": "vivo",
          "img": "/image/classify/phone.png"
        }
        ]
      },
      {
        "title": "手机配件",
        "desc": [{
          "text": "充电宝",
          "img": "/image/classify/power.png"
        },
        {
          "text": "耳机",
          "img": "/image/classify/headset.png"
        },
        {
          "text": "吃鸡神器",
          "img": "/image/classify/game.png"
        }
        ]
      }
      ]
    ],
    nowindex: 0
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {

  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

  },
  switchRightTab: function (e) {
    this.setData({
      nowindex: e.currentTarget.dataset.index
    })
    console.log(this.data.nowindex)
  },
  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  },
  jumptolistpage: function (e) {
    console.log(e.currentTarget.dataset.clickeditem)
    const clickedtext=e.currentTarget.dataset.clickeditem.text
    wx.navigateTo({
      url: '/pages/list/index?title='+clickedtext
    })
  }
})