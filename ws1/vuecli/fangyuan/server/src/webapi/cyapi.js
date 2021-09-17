
var request = require('request');
var http = require('http');

function invoke(req) {

    const promise = new Promise((resolve, reject) => {
        // request('http://42.192.250.190:8080/fangyuan/getDanyuan?xiaoqu=${req.xiaoqu}&louhao=${req.louhao}&danyuan=${req.danyuan}'  , function (error, response, body) {
        request(`http://42.192.250.190:8080/fangyuan/getDanyuan?xiaoqu=${req.xiaoqu}&louhao=${req.louhao}&danyuan=${req.danyuan}`, function (error, response, body) {
            if (!error && response.statusCode == 200 && (JSON.parse(body)).ReturnData != null) {
                resolve((JSON.parse(body)).ReturnData.BizObjectArray)
            } else {
                reject(error)
            }
        })
    })
    return promise

}
function callCYApi(options,postData) {

    var req = http.request(options, (res) => {
        console.log(`STATUS: ${res.statusCode}`);
        console.log(`HEADERS: ${JSON.stringify(res.headers)}`);
        res.setEncoding('utf8');
        res.on('data', (chunk) => {
            console.log(`BODY: ${chunk}`);
        });
        res.on('end', () => {
            console.log('No more data in response.')
        })
    });

    req.on('error', (e) => {
        console.log(`problem with request: ${e.message}`);
    });

    // write data to request body
    req.write(postData);
    req.end();

}
module.exports = {
    invoke, callCYApi
}