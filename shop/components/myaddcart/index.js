// components/mypop/index.js
Component({
  /**
   * 组件的属性列表
   */
  properties: {
    payproduct:{
      type:Object,
      value:{}
    },
    pophidden:{
      type:Boolean,
      value:true
    },
    count:{
      type:Number,
      value:0
    }
  },

  /**
   * 组件的初始数据
   */
  data: {
  },

  /**
   * 组件的方法列表
   */
  methods: {
    closewindow(){
      this.setData({
        pophidden:true
      })
    },
    updatecartnum(){
      console.log("更新购物车数量")
      console.log(this.data.count)
      this.triggerEvent("addcart",this.data.count)
      this.setData({
        pophidden:true
      })
    },
    add(e){
      this.setData({
        count:e.detail
      })
    },
    minus(e){
      this.setData({
        count:e.detail
      })
    }
  }
})
