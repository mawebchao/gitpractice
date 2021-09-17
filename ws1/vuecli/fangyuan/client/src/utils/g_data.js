// 全局变量对象
var g_data = {
    dateTime: "2021-09-01 00:00:00"
}
import Vue from 'vue'
// 定义属性存储
var dateTime_value = new Date()

/*  父子组件事件触发搬运车 */
var eventBus = new Vue()
Vue.prototype.g_bus = eventBus

/* 定义每个属性的监听事件 */
const keys = Object.keys(g_data)
keys.forEach(objItem => {
    Object.defineProperty(g_data, objItem, {
        get: function () {
            return dateTime_value
        },
        set: function (newValue) {
            dateTime_value = newValue
            eventBus.$emit(`watch_${objItem}`, newValue)
        }
    })
})

export default g_data