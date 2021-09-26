import Dao from "./LocalDataHelper_dao"

import Record from "../pojo/Record";
class RecordHelper_controller {
    localDataHelper: Dao = new Dao("jlData");
    getAll(): Record[] {
        let oldDataObj: any = this.localDataHelper.readAllData();
        let result: Record[] = []
        for (let key in oldDataObj) {
            result.push(new Record(key, oldDataObj[key]))
        }
        return result
    }
    addRecord(content: any): number {
        try {
            return this.localDataHelper.addData(content)
        } catch (error) {
            return -1;
        }
    }
    updateRecord(key: string, content: any): void {
        this.localDataHelper.updateData(key, content)

    }
    delRecord(key: string): void {
        this.localDataHelper.deleteData(key)
    }
}
export default RecordHelper_controller