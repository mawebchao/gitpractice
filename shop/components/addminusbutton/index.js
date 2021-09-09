// components/addminusbutton/index.js
Component({
  /**
   * 组件的属性列表
   */
  properties: {
    count: {
      type: Number,
      value: 0
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
    minuscount(e) {
      if (this.data.count > 0) {
        this.setData({
          count: this.data.count - 1
        })
        this.triggerEvent("clickminus",this.data.count)
      }
    },
    addcount(e) {
      this.setData({
        count: this.data.count + 1
      })
      console.log(this,e)
      this.triggerEvent("clickadd",this.data.count)
    }
  }
})
