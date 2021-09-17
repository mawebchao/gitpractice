const { invoke, callCYApi } = require('../webapi/cyapi')
const { executeSql } = require('../db/mysql_fangyuan')
const querystring=require('querystring')
var request = require('request');
const getBuildingListByEstateId = async (estateId) => {
    //给出请求参数：xiaoqu、louhao、danyuan，封装成一个js对象
    let result = await executeSql(`select * from building where estateid=${estateId}`)
    return result;
}
const getBlockList = async (author, keyword) => {
    //给出请求参数：xiaoqu、louhao、danyuan，封装成一个js对象
    let bizArr = []
    let MAX_NULLCOUNT=10;
    let count=0;
    for(let louhao=1;louhao<=10;louhao++){
        for (let danyuan = 1; danyuan <= 10; danyuan++) {
            let nowArr = await invoke({"xiaoqu": 1, "louhao":louhao , "danyuan": danyuan }).catch((err) => { console.log("controller获取数据报错err", err) })
            if (nowArr != null) {
                bizArr = bizArr.concat(nowArr)
            }else{
                if(++count>=MAX_NULLCOUNT){
                    break;
                }
            }
        }
    }
    

    return bizArr;
}
const getBlocksById = async (id,sno) => {
    let sql=`select * from block where 1=1`
    if(id){
        sql+=` and buildingid='${id}'`
    }
    if(sno){
        sql+=` and sno=${sno}`
    }
    let result = await executeSql(sql)
    return result;
}


const getEstateHasChildren = async (id) => {
    //给出请求参数：xiaoqu、louhao、danyuan，封装成一个js对象
    let result = await executeSql(`select * from building where estateid=${id}`)
    return result;
}
const getEstateList = async () => {
    //给出请求参数：xiaoqu、louhao、danyuan，封装成一个js对象
    let result = await executeSql(`select * from estate`)
    return result;
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
const updateStatus = (blockData = {}) => {
    // console.log(blockData)
    // let length=blockData.Name.length-blockData.Name.lastIndexOf('_')-1
    // const fangjianhao=blockData.Name.substring(blockData.Name.length - length)
    // const xsstatus=blockData.F0000010
    // const name=blockData.F0000015
    let sql = `UPDATE building SET sno='${xsstatus}' where name='${name}'`
    return executeSql(sql).then((updateResult) => {
        console.log("updateResult数据 更新成功",updateResult)
        return {
            affectedRows: updateResult.affectedRows
        }
    })
}
const writeNewBlockToLocal = (blockData = {}) => {
    const NAME=blockData.F0000015
    const square = blockData.F0000005
    const price = blockData.F0000006
    const totalPrice = blockData.F0000007
    const username=blockData.F0000017
    const buildingId=blockData.F0000002
    const sno=blockData.F0000003
    const status=blockData.F0000014
    const estateName=blockData.F0000001
    const estateType=blockData.F0000020
    const xsstatus=blockData.F0000010
    let length=blockData.Name.length-blockData.Name.lastIndexOf('_')-1
    const fangjianhao=blockData.Name.substring(blockData.Name.length - length)
    let sql = `insert into block (NAME,url,buildingId,sno,square,price,totalPrice,username,status,xsstatus,fangjianhao) values('${NAME}','/blockDetail',concat((select id from estate where name =concat('${estateName}','${estateType}')),'-${buildingId}'),${sno},${square},${price},${totalPrice},'${username}','${status}','${xsstatus}',${fangjianhao})`
    return executeSql(sql).then((insertResult) => {
        console.log("insertResult数据 插入成功",insertResult)
        return {
            id: insertResult.insertId
        }
    }).catch((err)=>{
        if(err.sqlMessage.indexOf("FOREIGN KEY")!=-1){
            
            //插入失败是因为外键影响
            sql = `insert into building (NAME,url,estateId,sno) values('${buildingId}号楼','',(select id from estate where name =concat('${estateName}','${estateType}')),concat((select id from estate where name =concat('${estateName}','${estateType}')),'-${buildingId}'))`
            console.log("Sql",sql)
            return executeSql(sql)
        }
    }).then((res)=>{
        console.log("插入building成功：",res)
    }).catch((err)=>{
        if(err.sqlMessage.indexOf('cannot be null')!=-1){
            sql = `insert into estate (NAME,url) values(concat('${estateName}','${estateType}'),'')`
            console.log("Sql",sql)
            return executeSql(sql)
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
    updateStatus,getBlockList, getDetail, writeNewBlockToLocal, updateBlog, deleteBlog,getEstateList,getBuildingListByEstateId,getEstateHasChildren,getBlocksById
}