const getList = () => {
    return [
        {
            id: 1,
            title: "标题1",
            content: "内容1",
            createdAt: 4543543,
            author: "zhangsan"
        },
        {
            id: 2,
            title: "标题2",
            content: "内容2",
            createdAt: 454425543,
            author: "lisi"
        }
    ]
}
const getDetail = (id) => {
    return {
        id: 1,
        title: "标题1",
        content: "内容1",
        createdAt: 4543543,
        author: "zhangsan"
    }
}
const createNewBlog=(blogData)=>{
    console.log(blogData)
    return {id:1}
}
const updateBlog=(id,blogData)=>{
    console.log(id,blogData)
    return true;
}
const deleteBlog=(id)=>{
    console.log("id",id)
    return true;
}
module.exports = {
    getList,getDetail,createNewBlog,updateBlog,deleteBlog
}