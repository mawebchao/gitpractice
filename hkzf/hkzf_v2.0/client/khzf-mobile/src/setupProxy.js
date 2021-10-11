const { createProxyMiddleware } = require('http-proxy-middleware');  //注意写法，这是1.0以后的版本，最好按抄

module.exports = function (app) {
    app.use(createProxyMiddleware('/bdapi',
        {
            target: 'https://api.map.baidu.com',
            pathRewrite: {
                '^/bdapi': '',
            },
            changeOrigin: true,
            secure: false, // 是否验证证书
            ws: true, // 启用websocket
        }
    ));
    app.use(createProxyMiddleware('/api',
        {
            target: 'http://localhost:8080',
            pathRewrite: {
                '^/api': '',
            },
            changeOrigin: true,
            secure: false, // 是否验证证书
            ws: true, // 启用websocket
        }
    ));
};