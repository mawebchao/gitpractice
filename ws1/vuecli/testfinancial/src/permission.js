import router from './router/index.js'
import { getToken } from './utils/auth'
router.beforeEach((to, from, next) => {
    if (!getToken()) {
        if (to.path != '/login') {
            next({ path: "/login" })
        } else {
            next();
        }
    } else {
        if (to.path == '/login')
            next({ path: '/' })
        else next()
    }
})
