class Vue {
    constructor(options) {
        this.$data = options.data;
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
        Compile(this, options.el);
    }
}

function Observe(obj) {
    if (!obj || typeof obj !== 'object') return;
    Object.keys(obj).forEach(key => {
        let val = obj[key]
        Observe(val)
        Object.defineProperty(obj, key, {
            get() {
                return val
            },
            set(newVal) {
                val = newVal
                Observe(val)
            }
        })
    })
}

function Compile(vm, el) {
    let elDOM = document.querySelector(el)
    let fragment = document.createDocumentFragment();
    while(node=elDOM.firstChild){
        fragment.appendChild(node)
    }
    replace(fragment,vm)
    elDOM.appendChild(fragment)
}
function replace(dom,vm){
    if(dom.nodeType===3){
        const execMustAche=/\{\{\s*(\S+)\s*\}\}/
        let execResult=execMustAche.exec(dom.textContent)
        if(execResult!==null){
            let nowVal=execResult[1].split('.').reduce((obj,key)=>obj[key],vm)
            dom.textContent=dom.textContent.replace(execMustAche,nowVal)
            new Watcher
        }
        
        return;
    }
    
    dom.childNodes.forEach(childDOM=>replace(childDOM,vm))
}