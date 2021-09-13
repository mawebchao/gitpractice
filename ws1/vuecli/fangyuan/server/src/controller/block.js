const { invoke } = require('../webapi/cyapi')
const { executeSql } = require('../db/mysql')

var request = require('request');

const getList = async (author, keyword) => {
    //给出请求参数：xiaoqu、louhao、danyuan，封装成一个js对象
<<<<<<< HEAD
    // for()
    let bizArr=[]
    for(let danyuan=1;danyuan<=10;danyuan++) {
        bizArr.concat(await invoke({"danyuan":danyuan}).catch((err)=>{console.log(err)}))
        // console.log(await delaylog({"danyuan":danyuan}).catch((err)=>{console.log(err)}))
    }
=======
    let bizArr = []
    for (let danyuan = 1; danyuan <= 10; danyuan++) {
        let nowArr = await invoke({ "url": "https://www.h3yun.com/OpenApi/Invoke","xiaoqu": xiaoqu,"louhao": louhao, "danyuan": danyuan }).catch((err) => { console.log("err", err) })
        if (nowArr != null) {
            bizArr = bizArr.concat(nowArr)
        }
    }

>>>>>>> caccf730 (update)
    return bizArr;
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
    const createdAt = new Date().format("yyyy-MM-dd hh:mm:ss");
    console.log(createdAt)
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
        console.log(insertResult)
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