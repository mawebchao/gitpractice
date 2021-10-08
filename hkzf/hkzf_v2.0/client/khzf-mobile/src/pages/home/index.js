import React from 'react'
import { TabBar } from 'antd-mobile';
import { Route } from 'react-router-dom';
import News from '../../components/news/index'
import My from '../../components/my/index'

import Find from '../../components/find/index'

import Index from '../../components/Index/index'

import './index.css'

export default class Home extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            selectedTab: this.props.location.pathname,
            fullScreen: true,
        };
    }
    componentDidUpdate(){
        if(this.state.selectedTab!== this.props.location.pathname){
            this.setState({
                selectedTab:this.props.location.pathname
            })
        }
    }
    tabBarItemList = [
        {
            title: "首页",
            icon: "icon-house",
            path: "/home"
        },
        {
            title: "找房",
            icon: "icon-findHouse",
            path: "/home/find"
        },
        {
            title: "资讯",
            icon: "icon-message",
            path: "/home/news"
        },
        {
            title: "我",
            icon: "icon-myinfo",
            path: "/home/my"
        }
    ]

    renderBarFunc() {
        return (
            this.tabBarItemList.map(item => <TabBar.Item
                title={item.title}
                key={item.title}
                icon={<i className={`iconfont ${item.icon}`}></i>}
                selectedIcon={<i className={`iconfont ${item.icon}`}></i>}
                selected={this.state.selectedTab === item.path}
                onPress={() => {
                    this.setState({
                        selectedTab: item.path,
                    });
                    this.props.history.push(item.path)
                }}
            >
            </TabBar.Item>)

        )
    }
    render() {
        return (
            <div>
                <Route path="/home/news" component={News} />
                <Route path="/home/my" component={My} />
                <Route path="/home/find" component={Find} />
                <Route path="/home" component={Index} exact />
                <div className="tabbarClass" style={this.state.fullScreen ? { position: 'fixed', height: '50px', width: '100%', bottom: 0 } : { height: 400 }}>
                    <TabBar
                        unselectedTintColor="#949494"
                        tintColor="#33A3F4"
                        barTintColor="white"
                    >
                        {
                            this.renderBarFunc()
                        }
                    </TabBar>
                </div>
            </div>
        );
    }
}

