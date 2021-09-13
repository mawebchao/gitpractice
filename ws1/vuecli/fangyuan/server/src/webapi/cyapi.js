
var request = require('request');

function invoke(req) {
    
    const promise = new Promise((resolve, reject) => {
        request('http://42.192.250.190:8080/fangyuan/getDanyuan?xiaoqu=1&louhao=1&danyuan=' + req.danyuan, function (error, response, body) {
            if (!error && response.statusCode == 200&&(JSON.parse(body)).ReturnData!=null) {
                resolve((JSON.parse(body)).ReturnData.BizObjectArray)
            }else{
                reject(error)
            }
        })
    })
    return promise

}
module.exports = {
    invoke
}