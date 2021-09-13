const mysql = require('mysql')
const {MYSQL_CONFIG}=require('../config/db')
const connection = mysql.createConnection(MYSQL_CONFIG)

<<<<<<< HEAD
connection.connect();
=======
// connection.connect();
>>>>>>> caccf730 (update)

const sql = `update blogtest set title=''`;


<<<<<<< HEAD
// function executeSql(sql, callback) {
//     // connection.query(sql, (err, result) => {
//     //     if (err) {
//     //         conosole.log('err', err)
//     //         return;
//     //     }
//     //     console.log('result', result)
//     // })
//     connection.query(sql,callback)
// }
=======
>>>>>>> caccf730 (update)
function executeSql(sql) {
    const promise=new Promise((resolve,reject)=>{
        connection.query(sql,(err,result)=>{
            if(err){
                reject(err)
                return;
            }
            resolve(result)
        })
    })
    return promise
    
}
module.exports = {
    executeSql
}