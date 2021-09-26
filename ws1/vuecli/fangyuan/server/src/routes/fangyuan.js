const { SuccessModel, ErrorModel } = require('../model/responsedata')
const { updateStatus,getBlockList, writeNewBlockToLocal, getEstateList, getBuildingListByEstateId, getEstateHasChildren,getBlocksById } = require('../controller/fangyuan')
const { deleteBlog, createNewBlog } = require('../controller/blog')
//处理博客相关的路由
const handlerBlogRoute = (req, res) => {
    //定义处理路由的逻辑
    const method = req.method;
    const id = req.query.id
    const blogData = req.body
    const sno = req.query.sno

    if (method === 'GET' && req.path === '/api/block/all') {

        const listDataPromise = getBlockList()
        return listDataPromise.then(async (listData) => {
            console.log("listData", listData.length)
            for (var i = 0; i < listData.length; i++) {
                await writeNewBlockToLocal(listData[i])
            }
            //更新status字段（根据数据标题）
            // for (var i = 0; i < listData.length; i++) {
            //     await updateStatus(listData[i])
            // }
            return new SuccessModel(listData);
        })
    }
    if (method === 'GET' && req.path === '/api/block/getAll') {

        const listDataPromise = getBlocksById(id,sno)
        return listDataPromise.then(async (listData) => {
            return new SuccessModel(listData);
        })
    }
    if (method === 'GET' && req.path === '/api/estate/hasChildren') {

        const listDataPromise = getEstateHasChildren(id)
        return listDataPromise.then(async (listData) => {
            if (listData.length > 0)
                return new SuccessModel(true);
        })
    }
    if (method === 'GET' && req.path === '/api/building/all') {

        const listDataPromise = getBuildingListByEstateId(id)
        return listDataPromise.then(async (listData) => {
            console.log("listData", listData.length)

            return new SuccessModel(listData);
        })
    }
    if (method === 'GET' && req.path === '/api/building/search') {

        const listDataPromise = getBuildingListByEstateId(id)
        return listDataPromise.then(async (listData) => {
            console.log("listData", listData.length)

            return new SuccessModel(listData);
        })
    }
    if (method === 'GET' && req.path === '/api/estate/all') {

        const listDataPromise = getEstateList()
        return listDataPromise.then(async (listData) => {
            console.log("listData", listData.length)

            return new SuccessModel(listData);
        })
    }
    if (method === 'GET' && req.path === '/api/blog/detail') {
        const detailDataPromise = getDetail(id)
        return detailDataPromise.then((detailData) => {
            return new SuccessModel(detailData);
        })
    }
    //新建路由
    if (method === 'POST' && req.path === '/api/blog/new') {

        const newBlogDataPromise = createNewBlog(blogData);
        return newBlogDataPromise.then((newBlogResult) => {
            return new SuccessModel(newBlogResult);
        })
    }
    if (method === 'POST' && req.path === '/api/blog/update') {
        const updateBlogDataPromise = updateBlog(id, blogData);
        return updateBlogDataPromise.then((updateBlogData) => {
            if (updateBlogData) {
                return new SuccessModel("更新博客成功")
            } else {
                return new ErrorModel("更新博客失败")
            }
        })

    }
    if (method === 'POST' && req.path === '/api/blog/delete') {
        const deleteBlogDataPromise = deleteBlog(id);
        return deleteBlogDataPromise.then((updateBlogData) => {
            if (updateBlogData) {
                return new SuccessModel("删除博客成功")
            } else {
                return new ErrorModel("删除博客失败")
            }
        })
    }
}
module.exports = {
    handlerBlogRoute
}