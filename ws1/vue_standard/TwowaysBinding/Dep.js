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
    constructor(cb){
        this.cb=cb
    }
    update(){
        this.cb()
    }
}

let watcher1=new Watcher(()=>{console.log("我是第一个订阅者")});
let watcher2=new Watcher(()=>{console.log("我是第二个订阅者")});

let dep=new Dep();
dep.addSubs(watcher1)
dep.addSubs(watcher2)
dep.notify()