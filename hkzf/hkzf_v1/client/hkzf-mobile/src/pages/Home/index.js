import React, { useState } from 'react'
import { Link, Route } from 'react-router-dom'
import News from '../../components/news'
import Index from '../../components/index'
import { TabBar, Badge } from 'antd-mobile'
import {
    AppOutline,
    MessageOutline,
    MessageFill,
    UnorderedListOutline,
    UserOutline,
} from 'antd-mobile-icons'
export default function Home(props) {


    let tabs = [
        {
            key: 'index',
            title: '首页',
            icon: <AppOutline />,
            badge: Badge.dot
        },
        {
            key: 'find',
            title: '找房',
            icon: <UnorderedListOutline />,
            badge: '5'
        },
        {
            key: 'news',
            title: '资讯',
            icon: (active) =>
                active ? <MessageFill /> : <MessageOutline />,
            badge: '99+'
        },
        {
            key: 'my',
            title: '我的',
            icon: <UserOutline />
        },
    ];
    const [activeKey, setActiveKey] = useState('home')
    return (
        <div>
            <Route path="/home/index" component={Index}></Route>
            <Route path="/home/news" component={News}></Route>
            <div style={{ position: 'fixed', bottom: 0, width: "100%" }}>
                <TabBar 
                activeKey={activeKey} 
                onChange={(key) => {
                    setActiveKey(key)
                    console.log(key);
                    props.history.push('/home/' + key)
                }}
                >
                    {tabs.map(item => (
                        // <Link to="/">
                        <TabBar.Item
                            key={item.key}
                            icon={item.icon}
                            title={item.title}
                            badge={item.badge}
                            // onPress={() => { console.log("rfdv"); this.props.history.push("/home" + item.key) }}
                            onClick={() => console.log("rfdv")}
                        />
                        // </Link>

                    ))}
                </TabBar>
            </div>
        </div>
    )

}