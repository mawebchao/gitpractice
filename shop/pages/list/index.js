// pages/list/index.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    prolist: [{ "id": "4a4c8b8e4d8c22a97a94b46f58c1f3b9", "cover": "/image/classify/miphone.png", "title": "黑莓（BlackBerry）KEY2标准版 6GB+64GB双卡双待 4G全网通手机 黑色 移动联通电信手机", "price": "3388.00", "comment": "6239", "rate": "99%" }, { "id": "5a4c8b8e4d8c22a97a94b46f58c1f3b9", "cover": "/image/classify/huawei.png", "title": "HUAWEI P20 Pro 全面屏徕卡三摄游戏手机 6GB+128GB 亮黑色 全网通移动联通电信4G手机 双卡双待", "price": "4499.00", "comment": "27万", "rate": "99%" }, { "cover": "/image/classify/phone.png", "title": "荣耀8X Max 7.12英寸90%屏占比珍珠屏 4GB+64GB 魅海蓝 移动联通电信4G全面屏手机 双卡双待", "price": "1499.00", "comment": "3万", "rate": "99%", "id": "3a4c8b8e4d8c22a97a94b46f58c1f3b9" }, { "id": "4a4c8b8e4d8c22a97a94b46f58c1f3b9", "cover": "/image/classify/miphone.png", "title": "黑莓（BlackBerry）KEY2标准版 6GB+64GB双卡双待 4G全网通手机 黑色 移动联通电信手机", "price": "3388.00", "comment": "6239", "rate": "99%" }, { "id": "5a4c8b8e4d8c22a97a94b46f58c1f3b9", "cover": "/image/classify/huawei.png", "title": "HUAWEI P20 Pro 全面屏徕卡三摄游戏手机 6GB+128GB 亮黑色 全网通移动联通电信4G手机 双卡双待", "price": "4499.00", "comment": "27万", "rate": "99%" }]

  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    wx.setNavigationBarTitle({
      title:options.title==undefined?"":options.title
    })
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
  jumptodetail:function(e){
    const clickedproduct=e.currentTarget.dataset.clickedproduct;
    wx.navigateTo({
      url: '/pages/detail/index?data='+JSON.stringify(clickedproduct),
    })
  }
})