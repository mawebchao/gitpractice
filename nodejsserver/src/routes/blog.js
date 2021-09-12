const { SuccessModel, ErrorModel } = require('../model/responsedata')
const { getList, getDetail, createNewBlog, updateBlog, deleteBlog } = require('../controller/blog')
//处理博客相关的路由
const handlerBlogRoute = (req, res) => {
    //定义处理路由的逻辑
    const method = req.method;
    const id = req.query.id
    const blogData = req.body
    if (method === 'GET' && req.path === '/api/blog/list') {


        const author = req.query.author || '';
        const keyword = req.query.keyword || '';
        const listDataPromise = getList(author, keyword)
        return listDataPromise.then((listData) => {
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
        return updateBlogDataPromise.then((updateBlogData) => {
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