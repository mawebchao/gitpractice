module.exports = {
    devServer: {
        host: '0.0.0.0',
        port: 8080,
        https: false,
        open: true, // 配置自动启动浏览器
        proxy: {
            // 匹配所有以 /api 开头的url
            '/api': {
                // 请求的目标主机
                target: 'https://api.binstd.com/recipe/search',
                changeOrigin: true,
                // 这样重写会把路径中 /api 消去
                pathRewrite: {
                    "^/api": ""
                }
            }
        }
    }
}