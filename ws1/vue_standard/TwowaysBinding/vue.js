class Vue {
    constructor(options) {
        this.$data = options.data

        //数据劫持
        Observe(this.$data)

        //属性代理
        Object.keys(this.$data).forEach((key)=>{
            Object.defineProperty(this,key,{
                get(){
                    return this.$data[key];
                },
                set(newVal){
                    this.$data[key]=newVal
                }
            })
        })

        //调用模板编译的函数
        Compile(options.el,this)
    }
}

function Observe(obj) {
    if(!obj||typeof obj!=='object'){
        return;
    }
    const dep=new Dep()
    Object.keys(obj).forEach(key => {
        let val = obj[key]
        Observe(val)
        Object.defineProperty(obj, key, {
            enumerable: true,
            configurable: true,
            get() {
                // console.log("有人获取了value值")
                Dep.target&&dep.addSubs(Dep.target)
                return val
            },
            set(newVal) {
                console.log(typeof val)
                val = newVal
                Observe(val)
                console.log("有人修改了value值")
                //通知每一个订阅者更新自己的文本
                dep.notify()
            }
        })
    })
}

function Compile(el,vm){
    vm.$el=document.querySelector(el)
    //创建文档碎片
    const fragment=document.createDocumentFragment()
    while((childNode=vm.$el.firstChild)){
        fragment.appendChild(childNode)
    }
    //进行模板编译
    replace(fragment)
    vm.$el.appendChild(fragment)
    //负责对dom模板进行编译
    function replace(node){
        //定义匹配差值表达式的定义
        const regMystache=/\{\{\s*(\S+)\s*\}\}/

        if(node.nodeType===3){
            //当前node节点是一个文本子节点
            const text=node.textContent
            const exec_result=regMystache.exec(text)
            if(exec_result){
                node.textContent=text.replace(regMystache,exec_result[1].split('.').reduce((obj,k)=>obj[k],vm))
                //创建watch实例
                new Watcher(vm,exec_result[1],(newVal)=>{
                    node.textContent=text.replace(regMystache,newVal)
                })
            }
            return;
        }
        //是否是input输入框
        if(node.nodeType===1&&node.tagName.toUpperCase()==='INPUT'){
            const attrs=Array.from(node.attributes) 
            const findResult=attrs.find(x=>x.name==='v-model')
            if(findResult){
                const expStr=findResult.value;
                const value=expStr.split('.').reduce((obj,key)=>obj[key],vm)
                node.value=value
                new Watcher(vm,expStr,(newVal)=>{
                    node.value=newVal
                })
                node.addEventListener("input",(e)=>{
                    const key=expStr.split('.')
                    const obj=key.slice(0,key.length-1).reduce((obj,key)=>obj[key],vm)
                    obj[key[key.length-1]]=e.target.value
                })
            }
            // console.log(node)
        }

        node.childNodes.forEach(child=>{
            replace(child)
        })
    }
}

class Dep{
    constructor(){
        this.subs=[]
    }
    addSubs(watcher){
        this.subs.push(watcher)
    }
    notify(){
        this.subs.forEach(watcher=>{watcher.update()})
    }
}

class Watcher{
    //cb中记录着当前watcher如何更新自己的文档内容
    //vm用来获取最新的数据
    //key用来标记哪个数据是自己所需要的数据
    constructor(vm,key,cb){
        this.vm=vm;
        this.key=key;
        this.cb=cb;
        Dep.target=this;
        key.split('.').reduce((newObj,key)=>newObj[key],vm)
        Dep.target=null;
    }
    update(){
        const newVal=this.key.split('.').reduce((obj,key)=>obj[key],vm)
        this.cb(newVal)
    }
}