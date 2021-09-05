import Mock from 'mockjs'
Mock.mock('localhost:8080/login', 'post', (req) => {
    console.log(req);
    console.log("desfc");
    const { pass, name } = JSON.parse(req.body);
    if (name === 'user' && pass === '123456') {
        return {
            code: 200,
            success: true,
            message: "登录成功",
            token: "rdgvwerr345wd343",
            nickname: "赵铁柱"
        }
    } else {
        return {
            code: 100,
            success: false,
            message: "账号或者密码错误"
        }
    }
})
const menuList = [
    {
        name: "首页",
        icon: "el-icon-s-home",
        url: "/index"
    },
    {
        name: "账户管理",
        icon: "el-icon-coin",
        url: "/account",
        children: [
            {
                name: "所有人员",
                icon: "el-icon-user",
                url: "/account/all"
            },
            {
                name: "业务人员",
                icon: "el-icon-phone-outline",
                url: "/account/business"
            },
            {
                name: "审核人员",
                icon: "el-icon-s-check",
                url: "/account/audit"
            },
            {
                name: "风控经理",
                icon: "el-icon-s-finance",
                url: "/account/risk"
            },
            {
                name: "管理员",
                icon: "el-icon-s-custom",
                url: "/account/admin"
            }

        ]
    },
    {
        name: "产品管理",
        icon: "el-icon-menu",
        url: "/product",
        children: [
            {
                name: "全部产品",
                icon: "el-icon-notebook-2",
                url: "/product/all"
            },
            {
                name: "汽车消费",
                icon: "el-icon-truck",
                url: "/product/carConsumption"
            },
            {
                name: "房产消费",
                icon: "el-icon-office-building",
                url: "/product/estate"
            },
            {
                name: "抵押贷款",
                icon: "el-icon-money",
                url: "/product/mortgage"
            }
        ]
    },
    {
        name: "订单管理",
        icon: "el-icon-s-order",
        url: "/order",
        children: [
            {
                name: "所有订单",
                icon: "el-icon-tickets",
                url: "/order/all"
            },
            {
                name: "新建订单",
                icon: "el-icon-document",
                url: "/order/create"
            }
        ]
    },
    {
        name: "客户管理",
        icon: "el-icon-user",
        url: "/customer",
        children: [
            {
                name: "基本信息",
                icon: "el-icon-chat-square",
                url: "/customer/info"
            },
            {
                name: "资金记录",
                icon: "el-icon-bank-card",
                url: "/record"
            }
        ]
    },
    {
        name: "待办事项",
        icon: "el-icon-char-dot-square",
        url: "/todo"
    },
    {
        name: "个人中心",
        icon: "el-icon-user",
        url: "/my"
    }
]

Mock.mock('localhost:8080/menu', 'get', () => {
    return {
        code: 200,
        success: true,
        message: "成功",
        data: menuList
    }
})


Mock.mock('localhost:8080/in', 'get', () => {
    return {
        code: 200,
        success: true,
        message: "登录成功",
        time: "2020-07-1 00:00:00"
    }
})

Mock.mock(/localhost:8080\/getGoodsList/, 'get', function (option) {
    console.log("get带参数测试");
    console.log(option)
    //通过正则表达式提取到url后面的id
    let id = /localhost:8080\/getGoodsList\/(\d+)/.exec(option.url)
    console.log("id", id);

    return Mock.mock({
        status: 200,
        message: '获取商品成功',
        success: true,
        data: [{
            id: id[1] - 0,
            name: '@constellation',  //自定义扩展mock函数
            price: 5,
            count: 10
        }]
    })
})
Mock.mock('localhost:8080/all', 'get', () => {
    return {
        code: 200,
        success: true,
        message: "成功",
        data: Mock.mock({
            "list|20-40": [{
                'account|1000000-9999999': 1,
                'id|+1': 1,
                'name': "@cname",
                'charater|1': ["业务人员", "审核人员", "风控经理", "管理员"],
                'remark|5-20': '@cword',
                'reason|1': ["需要进系统录入进件补充资料", "对进件进行风险的审核", "对放款继续进行风险审核"],
                'status|1': [1, 2]
            }],
            "total|1": [10, 20, 30, 40, 50]
        })
    }
})
Mock.mock('localhost:8080/productlist', 'get', () => {
    return {
        code: 200,
        success: true,
        message: "成功",
        data: Mock.mock({
            "list|8-20": [{
                'id|+1': 1,
                'type|1': ["汽车消费", "房产消费", "抵押贷款"],
                'name|1': ["巴贝拉贷款", "麦穗金融","日借款","艾柱借贷","樱花分期","小熊金融","接了话","星星钱袋"],
                'limit|1':[100,200,300],
                'rate|1':[4.1,4.2,3.8,3.9,5,3],
                'number':Mock.Random.integer(30,200),
                'total':Mock.Random.integer(1000000,9999999),
                'average':Mock.Random.integer(1000000,2500000000),
                'status|1':[1,2],
                'highest|1':[36,60,24,360],
                'date':Mock.Random.date()
            }],
            "total|1": [10, 20, 30, 40, 50]
        })
    }
})
