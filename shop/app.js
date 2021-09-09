// app.js
App({
  onLaunch() {
    // 展示本地存储能力
    const logs = wx.getStorageSync('logs') || []
    logs.unshift(Date.now())
    wx.setStorageSync('logs', logs)

    // 登录
    wx.login({
      success: (res) => {
        // 发送 res.code 到后台换取 openId, sessionKey, unionId
        // console.log(res)
        wx.getUserInfo({
          success: (res) => {
            // console.log(res)
            // console.log(this)
            // console.log(window)
            // console.log(this.globalData)
            // var a = require('/utils/test_exports.js');
            // console.log(a)
            // a.sayHello()
            // var module_export_mode = require('/utils/test_module_exports.js')
            // console.log("hhh",module_export_mode)
            // module_export_mode.sayhhh()
          }
        })
      }
    })
    wx.getSetting({
      success: res => {
        console.log(res)
      }
    })
  },
  globalData: {
    userInfo: null
  }
})
