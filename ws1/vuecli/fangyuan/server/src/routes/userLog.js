const { SuccessModel, ErrorModel } = require('../model/responsedata')
const { create,update,search } = require('../controller/userLog')
const handlerUserLogRoute = (req, res) => {
    //定义处理路由的逻辑
    const method = req.method;
    const id = req.query.id
    const blogData = req.body
    const nickname = req.query.nickname

    if (method === 'GET' && req.path === '/user/get') {
        // console.log(nickname)
        const listDataPromise = search(nickname)
        return listDataPromise.then(async (listData) => {
            // console.log("listData", listData.length)
            return new SuccessModel(listData);
        })
    }
    if (method === 'POST' && req.path === '/user/create') {
        const listDataPromise = create(req.body)
        return listDataPromise.then(async (listData) => {
            return new SuccessModel(listData);
        })
    }
    if (method === 'POST' && req.path === '/user/update') {
        const listDataPromise = update(req.body)
        return listDataPromise.then(async (listData) => {
            return new SuccessModel(listData);
        })
    }
}
module.exports = {
    handlerUserLogRoute
}