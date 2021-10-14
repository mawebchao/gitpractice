// export default class User{
//     id:number;
//     name:string;
//     age:number;
//     sex:string;
//     constructor(id:number,name:string,age:number,sex:string){
//         this.id=id;
//         this.name=name;
//         this.age=age;
//         this.sex=sex;
//     }
// }
import Vue from 'vue'
class User {
    id: number;
    name: string;
    constructor(uid: any, uname: string) {
        if (uid instanceof Number)
            this.id = uid.valueOf();
        else
            alert("Gf")
        this.name = uname;
    }
}

function packageFunc(id: number, name: string) {
    return new User(id, name);
}

export default {
    // Vue.js的插件应当有一个公开方法 install。这个方法的第一个参数是 Vue 构造器，第二个参数是一个可选的选项对象。
    install: function (Vue: any) {
        Vue.prototype.global_func = (id:number,name:string) => packageFunc(id, name)
    }
}