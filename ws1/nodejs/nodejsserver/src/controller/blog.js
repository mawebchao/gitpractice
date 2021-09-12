const { executeSql } = require('../db/mysql')

const getList = (author,keyword) => {
    let sql = `select * from blogtest where 1=1 `;
    if(author){
        sql+=`and author ='${author}'  `
    }
    if(keyword){
        sql+=`and title like '%${keyword}%'  `
    }
    return executeSql(sql);
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
const createNewBlog = (blogData) => {
    console.log(blogData)
    return { id: 1 }
}
const updateBlog = (id, blogData) => {
    console.log(id, blogData)
    return true;
}
const deleteBlog = (id) => {
    console.log("id", id)
    return true;
}
module.exports = {
    getList, getDetail, createNewBlog, updateBlog, deleteBlog
}