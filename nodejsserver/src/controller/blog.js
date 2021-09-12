const { executeSql } = require('../db/mysql')

const getList = (author, keyword) => {
    let sql = `select * from blogtest where 1=1 `;
    if (author) {
        sql += `and author ='${author}'  `
    }
    if (keyword) {
        sql += `and title like '%${keyword}%'  `
    }
    return executeSql(sql);
}
const getDetail = (id) => {
    let sql = `select * from blogtest where 1=1 `;
    if (id) {
        sql += `and id = '${id}'  `
    }
    return executeSql(sql).then((rows) => {
        return rows[0]
    });
}
const createNewBlog = (blogData = {}) => {
    const title = blogData.title
    const content = blogData.content
    const author = blogData.author
    const createdAt = Date.now()
    const sql = `insert into blogtest (title,content,author,createdAt) values('${title}','${content}','${author}','${createdAt}')`
    return executeSql(sql).then((insertResult) => {
        return {
            id: insertResult.insertId
        }
    })
}
const updateBlog = (id, blogData) => {
    const title = blogData.title
    const content = blogData.content
    const sql = `update blogtest set title='${title}', content='${content}' where id=${id}`
    return executeSql(sql).then((insertResult) => {
        if (insertResult.affectedRows > 0) {
            return true
        } else {
            return false
        }

    })
}
const deleteBlog = (id) => {
    const sql = `delete from blogtest where id=${id}`
    return executeSql(sql).then((insertResult) => {
        if (insertResult.affectedRows > 0) {
            return true
        } else {
            return false
        }

    })
}
module.exports = {
    getList, getDetail, createNewBlog, updateBlog, deleteBlog
}