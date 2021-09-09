// pages/detail/index.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    "loopImgUrl": [
      "/image/classify/phone.png",
      "/image/classify/miphone.png",
      "/image/classify/huawei.png"
    ],
    nowproduct: {},
    paytype:"空",
    selectednum:0,
    payhidden:true,
    selecthidden:true
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    if (options.data != undefined) {
      this.setData({
        nowproduct: JSON.parse(options.data)
      })
      console.log(this.data.nowproduct)
    }

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
  showaddcart(){
    this.setData({
      selecthidden:false
    })
  },
  showpaypop(){
    this.setData({
      payhidden:false
    })
  },
  updatebaitiao(e){
    this.setData({
      paytype:e.detail
    })
  },
  updateselectednum(e){
    this.setData({
      selectednum:e.detail
    })
  }

})