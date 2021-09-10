// pages/list/index.js
const wrhlist = require('../../datadepo/searchresult').whrlist
const gbrlist = require('../../datadepo/searchresult').gbrlist

Page({
  /**
   * 页面的初始数据
   */

  data: {
    title: {
      type: String,
      value: ""
    },
    currentpage: 1,
    pagesize: 4,
    hasothers: false,
    pagecount: 1,
    total: 0,
    itemlist: [],
    morehidden: true,
    tips: '请稍后',
    animated: true
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    console.log("页面加载了")
    this.setData({
      title: options.searchvalue
    })
    if (this.data.title != '') {
      const searchvalue = this.data.title
      switch (searchvalue) {
        case '五花肉':

          this.setData({
            itemlist: wrhlist.slice((this.data.currentpage - 1) * this.data.pagesize, this.data.pagesize),
            total: wrhlist.length,
            pagecount: Math.ceil((wrhlist.length / this.data.pagesize).toFixed(1))
          })
          if (this.data.currentpage < this.data.pagecount)
            this.setData({ hasothers: true })
        case '锅包肉':

          this.setData({
            itemlist: gbrlist.slice((this.data.currentpage - 1) * this.data.pagesize, this.data.pagesize),
            total: gbrlist.length,
            pagecount: Math.ceil((gbrlist.length / this.data.pagesize).toFixed(1))
          })
          if (this.data.currentpage < this.data.pagecount)
            this.setData({ hasothers: true })
      }
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
    // this.timer = setInterval(() => {
    //   this.setData({
    //     show: this.data.morehidden
    //   })
    // }, 2000)
  },
  onUnload() {
    // clearInterval(this.timer)
  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {
    // wx.showNavigationBarLoading() //在标题栏中显示加载

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {
    console.log("到底了")
    if (this.data.currentpage < this.data.pagecount) {
      console.log(this.data.currentpage, this.data.pagecount)
      this.setData({ morehidden: false })
      setTimeout(() => {
        let nowlist = this.data.itemlist
        let loadinglist = wrhlist.slice((this.data.currentpage - 1) * this.data.pagesize, this.data.pagesize)
        loadinglist.forEach(ele => {
          nowlist.push(ele)
        });
        this.setData({ itemlist: nowlist, currentpage: this.data.currentpage + 1 })
        console.log(this.data.currentpage, this.data.pagecount)

        this.setData({ morehidden: true })
      }, 1000);


    }
    console.log(this.data.currentpage)


  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  }
})