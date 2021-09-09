// pages/category/index.js
// 引入接口配置文件urlconfig
const interfaces = require('../../utils/urlconfig.js');

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
    curIndex: 0,
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    const self = this
    // wx.showLoading({
    //   title: '加载中...',
    // })
    wx.request({
      url: interfaces.productions,
      header: {
        'content-type': 'application/json' // 默认值，返回的数据设置为json数组格式
      },
      success(res) {
        self.setData({
          navLeftItems: res.data.navLeftItems,
          navRightItems: res.data.navRightItems
        })
        wx.hideLoading()
      }
    })
  },
  /*
   * 记录左侧点击的按钮下标 
   */
  switchRightTab(e) {
    let index = parseInt(e.currentTarget.dataset.index);
    this.setData({
      curIndex: index
    })
  },
  /**
   * 点击进入列表页
   * 列表页参数 title
   */
  showListView(e) {
    let txt = e.currentTarget.dataset.txt
    wx.navigateTo({
      url: '/pages/list/index?title=' + txt
    })
  }
})