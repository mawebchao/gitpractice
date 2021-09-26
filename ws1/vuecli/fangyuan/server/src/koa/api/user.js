const Router = require('@koa/router')
const { checkUser, newUser, newWhite } = require('../../controller/user')
const { generateToken } = require('../core/util')
const Auth=require('../middlewares/auth')
const userRouter = new Router({
    prefix: "/koa/user"
})

userRouter.get('/', async ctx => {
    let checkResult = await checkUser(ctx.request.query)
    if (checkResult.length > 0){
        let user=checkResult[0]
        //这里的第二个参数代表的是权限数字
        const token=generateToken(user.id,2)
        console.log(token)
        ctx.body = token
    }
        
    else
        ctx.body = "failed"
})

userRouter.post('/create', async ctx => {
    let newResult = await newUser(ctx.request.body)
    if (newResult.affectedRows > 0)
        ctx.body = "success"
    else if (newResult.msg === "DUP")
        ctx.body = "failed"
    else
        ctx.body = "not found"

})

const adminRouter = new Router({
    prefix: "/koa/admin"
})

adminRouter.get('/check', async ctx => {
    let checkResult = await checkUser(ctx.request.query)
    if (checkResult.length > 0)
        ctx.body = "success"
    else
        ctx.body = "failed"
})

const whiteListRouter = new Router({
    prefix: "/koa/whitelist"
})

whiteListRouter.post('/add', async ctx => {
    try {
        let newResult = await newWhite(ctx.request.body)
        if (newResult.affectedRows > 0)
            ctx.body = "success"
    } catch (error) {
        if (error.code === "ER_DUP_ENTRY")
            ctx.body = "failed"
    }

})
const tokenRouter = new Router({
    prefix: "/koa/token"
})
tokenRouter.post('/verify',ctx=>{
    const token=ctx.request.headers.token
    const isValid=Auth.verifyToken(token)

    ctx.body={
        isValid
    }
})
module.exports = { userRouter, adminRouter, whiteListRouter,tokenRouter }