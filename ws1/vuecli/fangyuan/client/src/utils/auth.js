const axios =require('axios')
async function verifyToken() {
    let headers = {}
    headers.token = localStorage.getItem("token")
    const validResult = await axios({
        headers,
        method: "post",
        url: "/koa/token/verify"
    });
    return validResult;
}
module.exports=verifyToken