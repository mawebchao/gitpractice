import vue from 'vue'

import Toast from '../components/toast.vue'
//生成构造函数
const ToastConstructor = vue.extend(Toast)

function showToast(_t, _time = 2000) {
    let _dom = new ToastConstructor({
        el: document.createElement("div"),
        data() {
            return {
                txt: _t,
                isShow: true
            }
        }
    });

    document.body.appendChild(_dom.$el)
    console.log(_dom)
    setTimeout(() => {
        _dom.isShow = false;
    }, _time);
}

//挂载到vue原型
function regFn(){
    vue.prototype.$toast=showToast
}

export default regFn