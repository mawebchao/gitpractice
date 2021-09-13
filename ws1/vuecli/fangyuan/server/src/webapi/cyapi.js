
var request = require('request');
<<<<<<< HEAD

function invoke(req) {
    
    const promise = new Promise((resolve, reject) => {
        request('http://42.192.250.190:8080/fangyuan/getDanyuan?xiaoqu=1&louhao=1&danyuan=' + req.danyuan, function (error, response, body) {
            if (!error && response.statusCode == 200&&(JSON.parse(body)).ReturnData!=null) {
                resolve((JSON.parse(body)).ReturnData.BizObjectArray)
            }else{
=======
var http=require('http');

function invoke(req) {

    const promise = new Promise((resolve, reject) => {
        // request('http://42.192.250.190:8080/fangyuan/getDanyuan?xiaoqu=${req.xiaoqu}&louhao=${req.louhao}&danyuan=${req.danyuan}'  , function (error, response, body) {
        request('http://42.192.250.190:8080/fangyuan/getDanyuan?xiaoqu=${req.xiaoqu}&louhao=${req.louhao}&danyuan=${req.danyuan}'  , function (error, response, body) {


            if (!error && response.statusCode == 200 && (JSON.parse(body)).ReturnData != null) {
                resolve((JSON.parse(body)).ReturnData.BizObjectArray)
            } else {
>>>>>>> caccf730 (update)
                reject(error)
            }
        })
    })
    return promise

}
module.exports = {
    invoke
}