import router from './router/index'
import { getToken } from './utils/auth'
router.beforeEach((to, from, next) => {
    const hasToken = getToken();
    console.log(hasToken);
    if (hasToken) {
        if (to.path == "/login")
            next({ path: "/" })
        else
            next();
    } else {
        if (to.path == "/login")
            next();
        else
            next({ path: "/login" });
    }
})