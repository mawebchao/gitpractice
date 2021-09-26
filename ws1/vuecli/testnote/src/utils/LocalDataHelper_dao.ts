//负责localStorage操作
class LocalDataHelper {
    storageKey: string;
    constructor(storageKey: string) {
        this.storageKey = storageKey;
    }
    readAllData(): any {
        const oldDataStr: string | null = localStorage.getItem(this.storageKey);
        let oldDataObj: any = {}
        if (oldDataStr != null) {
            oldDataObj = JSON.parse(oldDataStr)
        }
        return oldDataObj;
    }
    getCapacity(): number {
        const oldDataObj: any = this.readAllData();
        let capacity = 0;
        for (var i in oldDataObj) {
            capacity++
        }
        return capacity;
    }
    //这里的content可以是一个json对象stringtify的结果
    addData(content: any): number {
        let oldDataObj: any = this.readAllData();
        let newId = this.getCapacity() + 1;
        oldDataObj[newId] = content;
        this.saveData(oldDataObj)
        return newId;
    }
    saveData(newDataObj: any): void {
        localStorage.setItem(this.storageKey, JSON.stringify(newDataObj))
    }
    deleteData(key: string): void {
        let oldDataObj: any = this.readAllData();
        delete oldDataObj[key]
        this.saveData(oldDataObj)
    }
    updateData(key: string, content: any): void {
        let oldDataObj: any = this.readAllData();
        oldDataObj[key] = content
        this.saveData(oldDataObj)
    }
}

export default LocalDataHelper