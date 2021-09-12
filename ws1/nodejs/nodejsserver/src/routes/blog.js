const {SuccessModel,ErrorModel} =require('../model/responsedata')
const {getList,getDetail,createNewBlog,updateBlog,deleteBlog} =require('../controller/blog')

//处理博客相关的路由
const handlerBlogRoute=(req,res)=>{
    //定义处理路由的逻辑
    const method=req.method;
    const id=req.query.id
    const blogData=req.body
    if(method==='GET'&&req.path==='/api/blog/list'){
        const author=req.query.author||'';
        const keyword=req.query.keyword||'';
        const listData=getList(author,keyword)
        return new SuccessModel(listData);
    }
    if(method==='GET'&&req.path==='/api/blog/detail'){
        const detailData=getDetail(id)
        return new SuccessModel(detailData);
    }
    //新建路由
    if(method==='POST'&&req.path==='/api/blog/new'){
        
        const newBlogData=createNewBlog(blogData);
        return new SuccessModel(newBlogData)
    }
    if(method==='POST'&&req.path==='/api/blog/update'){
        const updateBlogData=updateBlog(id,blogData);
        if(updateBlogData){
            return new SuccessModel("更新博客成功")
        }else{
            return new ErrorModel("更新博客失败")
        }
    }
    if(method==='POST'&&req.path==='/api/blog/delete'){
        const deleteBlogData=deleteBlog(id);
        if(deleteBlogData){
            return new SuccessModel("删除博客成功")
        }else{
            return new ErrorModel("删除博客失败")
        }
    }
}
module.exports={
    handlerBlogRoute
}