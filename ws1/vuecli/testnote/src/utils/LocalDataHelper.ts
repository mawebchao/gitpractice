//负责localStorage操作
class LocalDataHelper{
    storageKey:string;
    constructor(storageKey:string){
        this.storageKey=storageKey;
    }
    readAllData():any{
        const oldDataStr: string|null=localStorage.getItem(this.storageKey);
        let oldDataObj:any={}
        if(oldDataStr!=null){
            oldDataObj=JSON.parse(oldDataStr)
        }
        return oldDataObj;
    }
    getCapacity():number{
        const oldDataObj:any=this.readAllData();
        let capacity:number=0;
        for(let key in oldDataObj){
            capacity++;
        }
        return capacity;
    }
    addData(content:string):number{
        let oldDataObj:any=this.readAllData();
        let newData:any={
            "content":content
        };
        let newId=this.getCapacity()+1;
        oldDataObj[newId]=newData;
        this.saveData(oldDataObj)
        return newId;
    }
    saveData(newDataObj:any):void{
        localStorage.setItem(this.storageKey,JSON.stringify(newDataObj))
    }
}

export default LocalDataHelper