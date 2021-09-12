const http=require('http')

const PORT=5000
const serverHandler=require('./server/App')
const server=http.createServer(serverHandler)

server.listen(PORT,()=>{
    console.log("server running ar port 5000")
})