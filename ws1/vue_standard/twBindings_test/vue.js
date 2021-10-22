class Vue {
    constructor(options) {
        this.$data = options.data
        Observe(this.$data)
        Object.keys(this.$data).forEach(key => {
            Object.defineProperty(this, key, {
                get() {
                    return this.$data[key]
                },
                set(newVal) {
                    this.$data[key] = newVal
                }
            })
        })
        Compile(options.el, this)
    }
}
class Dep {
    constructor() {
        this.subs = []
    }
    addSub(watcher) {
        this.subs.push(watcher)
    }
    notify() {
        this.subs.forEach(sub => sub.update())
    }
}
class Watcher {
    constructor(vm, key, cb) {
        this.vm = vm;
        this.key = key;
        this.cb = cb;
        Dep.target = this;
        key.split('.').reduce((obj, key) => obj[key], vm)
        Dep.target = null;
    }
    update() {

        let newVal = this.key.split('.').reduce((obj, key) => obj[key], this.vm)
        console.log(this.key)
        this.cb(newVal)
    }
}
function Compile(el, vm) {
    let eldom = document.querySelector(el)
    let fragment = document.createDocumentFragment()
    while (node = eldom.firstChild) {
        fragment.appendChild(node)
    }
    replace(fragment, vm);
    eldom.appendChild(fragment)
}
function replace(eldom, vm) {
    if (eldom.nodeType === 3) {
        const execMustAche = /\{\{\s*(\S+)\s*\}\}/
        let execResult = execMustAche.exec(eldom.textContent)
        if (execResult) {
            let content = eldom.textContent
            let newVal = execResult[1].split('.').reduce((obj, key) => obj[key], vm)
            // let newVal=
            eldom.textContent = content.replace(execMustAche, newVal)
            new Watcher(vm, execResult[1], (newValue) => {
                eldom.textContent = content.replace(execMustAche, newValue)
            })
        }

    }
    if (eldom.nodeType === 1 && eldom.tagName.toUpperCase() === 'INPUT') {
        let vmodelObj=Array.from(eldom.attributes).find(obj=>obj.name==='v-model')
        if(vmodelObj){
            let key=vmodelObj.value
            eldom.value=key.split('.').reduce((obj, key) => obj[key], vm)
            new Watcher(vm,key,(newVal)=>{
                eldom.value=newVal
            })
            eldom.addEventListener("input",(e)=>{
                let keyarr=key.split('.')
                let updateObj=keyarr.slice(0,keyarr.length-1).reduce((obj, key) => obj[key], vm)
                updateObj[keyarr[keyarr.length-1]]=e.target.value
                console.log(updateObj)
            })
        }
    }
    eldom.childNodes.forEach(childNode => replace(childNode, vm))
}
function Observe(obj) {
    if (!obj || typeof obj !== 'object') return;
    Object.keys(obj).forEach(key => {
        let val = obj[key]
        Observe(val)
        let dep = new Dep()
        Object.defineProperty(obj, key, {
            get() {
                Dep.target && dep.addSub(Dep.target)
                return val;
            },
            set(newVal) {
                val = newVal
                Observe(val)
                dep.notify()
            }
        })
    })
}


