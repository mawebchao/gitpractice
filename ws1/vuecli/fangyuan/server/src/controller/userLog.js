const { executeSql } = require('../db/mysql_userlog')

const create = async (user) => {
    let result = await executeSql(`insert into userlog values (null,'${user.nickname}','${user.iconurl}','${user.his}')`)
    return result;
}
const update = async (user) => {
    let result = await executeSql(`UPDATE userlog SET his = '${user.his}' WHERE id = ${user.id}`)
    return result;
}
const search = async (nickname) => {
    console.log("nickname",nickname)
    let result = await executeSql(`select * from userlog where nickname='${nickname}'`)
    return result;
}
module.exports = {
    create,update,search
}