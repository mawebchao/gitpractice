export default{
    state:{
        txt:"我是模块A的数据",
        rmb:100
    },
    getters:{
        rmb1(state){
            return "$"+state.rmb;
        }
    },
    actions:{

    },
    mutations:{

    }
}