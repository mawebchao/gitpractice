const http=require('http')
const PORT=5000
const serverHandler=require('../app.js')
const server=http.createServer(serverHandler)
require('../src/utils/date.js')
server.listen(PORT,()=>{
    console.log('server running at port 5000...')
})
//数据库表
//estate表（小区表）id,name,url
//building表（楼表）id,name,estateId
//block表（单元表）id,name,buildingId


//1.用户进入页面（发起请求，请求/all的接口）（可以新创建一个给用户判断是否重新获取数据的判断，之后进入页面）
//  /all接口需要获取所有房源数据（用户需要获取所有数据）
//  /all接口获取最近一个礼拜创建的数据
//          对于获取到的每一条数据，找到他的小区名称、楼号、单元号，再去数据库的blockRecord表中查找有没有这条数据
