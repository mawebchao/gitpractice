const { handlerBlogRoute } = require('./src/routes/blog.js')
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
        const blogData = handlerBlogRoute(req, res)
        if (blogData) {
            res.end(
                JSON.stringify(blogData)
            )
            return;
        }
        res.writeHead(404, {
            'Content-Type': 'application/json'
        })
        res.write('404 not found')
        res.end();
    })


}
module.exports = serverHandler