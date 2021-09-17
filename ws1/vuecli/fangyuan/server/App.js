const { handlerBlogRoute } = require('./src/routes/fangyuan.js')
const {handlerUserLogRoute}=require('./src/routes/userLog.js')
const querystring = require('querystring')
const getPostData = (req) => {
    const promise = new Promise((resolve, reject) => {
        if (req.method !== 'POST') {
            resolve({})
            return;
        }
        if (req.headers['content-type'] !== 'application/json') {

            resolve({});
            return;
        }

        let postData = '';
        req.on('data', (chunk) => {
            postData += chunk.toString();
        })
        req.on('end', () => {
            if (!postData) {
                resolve({})
                return;
            }
            resolve(JSON.parse(postData))
        })
    })
    return promise
}

const serverHandler = (req, res) => {
    res.setHeader('Content-Type', 'application/json')
    const url = req.url;
    req.path = url.split('?')[0];

    //解析query
    req.query = querystring.parse(url.split('?')[1])

    getPostData(req).then((postData) => {
        req.body=postData;
        let dataPromise = handlerBlogRoute(req, res)
        if (dataPromise) {
            dataPromise.then((data)=>{
                res.end(JSON.stringify(data)) 
            })
            return;
        }
        dataPromise = handlerUserLogRoute(req, res)
        if (dataPromise) {
            dataPromise.then((data)=>{
                res.end(JSON.stringify(data)) 
            })
            return;
        }
        res.writeHead(404, {
            'Content-Type': 'text/plain'
        })
        res.write('404 not found')
        res.end();
    })


}
module.exports = serverHandler