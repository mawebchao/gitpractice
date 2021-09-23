const { executeSql } = require('../db/mysql_fangyuan')

const checkUser = async (user) => {
    //给出请求参数：xiaoqu、louhao、danyuan，封装成一个js对象
    console.log(user)
    let result = await executeSql(`select * from user where username='${user.username}' and password='${user.password}'`)
    return result;
}
const newUser = async (user) => {
    //给出请求参数：xiaoqu、louhao、danyuan，封装成一个js对象
    let idnumber = user.idnumber
    let searchResultList = await executeSql(`select * from whitelist where idnumber='${idnumber}'`)
    let result
    if (searchResultList.length > 0) {
        try {
            result = await executeSql(`insert into user values (null,'${user.username}','${user.password}','${user.idnumber}')`)
        } catch (error) {
            result={msg:"DUP"}
        }
    }else{
        result={}
    }
    return result;
}

const newWhite = async (white) => {
    //给出请求参数：xiaoqu、louhao、danyuan，封装成一个js对象
    let result = await executeSql(`insert into whitelist values (null,'${white.idnumber}')`)
    return result;
}

module.exports = {
    checkUser, newUser, newWhite
}