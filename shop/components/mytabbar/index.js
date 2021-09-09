// components/mytabbar/index.js
Component({
  /**
   * 组件的属性列表
   */
  properties: {
    content: {
      type: String,
      value: ""
    },
    tabbartitle: {
      type: String,
      value: ""
    },
    typetag: {
      type: String,
      value: ""
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

    showaddcartpop() {

      if (this.data.typetag == "addcart") {
        this.triggerEvent("clickaddcart")
      } else if (this.data.typetag == "pay") {
        this.triggerEvent("clickpay")
      }
    }
  }
})
