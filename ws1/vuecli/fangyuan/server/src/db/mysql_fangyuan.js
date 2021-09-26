const mysql = require('mysql')
const {MYSQL_CONFIG}=require('./config/fangyuan')

var conn = function () {
    let connection = mysql.createConnection(MYSQL_CONFIG)
    connection.connect()
    connection.on('error', err => {
        console.log('Re-connecting lost connection: ');
        connection = mysql.createConnection(MYSQL_CONFIG)

    })
    return {
        connection, executeSql: function (sql) {
            const promise = new Promise((resolve, reject) => {
                connection.query(sql, (err, result) => {
                    if (err) {
                        reject(err)
                        return;
                    }
                    resolve(result)
                })
            })
            return promise

        }
    }

}
module.exports = conn