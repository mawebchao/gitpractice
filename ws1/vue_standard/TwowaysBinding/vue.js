class Vue{
    constructor(options){
        this.$data=options.data

        //数据劫持
        Observe(this.$data)
    }
}

function Observe(obj){
    Object.keys(obj).forEach(key=>{
        let val=obj[key]
        Object.defineProperty(obj,key,{
            enumerable:true,
            configurable:true,
            get(){
                console.log("有人获取了value值")
                return val
            },
            set(newVal){
                console.log(typeof val)
                val=newVal
                console.log("有人修改了value值")
            }
        })
    })
}