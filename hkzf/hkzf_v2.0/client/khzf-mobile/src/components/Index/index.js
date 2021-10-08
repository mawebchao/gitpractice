import React from 'react'
import { Carousel, Flex, Grid, Icon } from 'antd-mobile';
import axios from 'axios'
import Icon1 from '../../assets/images/nav-1.png'
import Icon2 from '../../assets/images/nav-2.png'
import Icon3 from '../../assets/images/nav-3.png'
import Icon4 from '../../assets/images/nav-4.png'

import './index.scss'
import {getLocation} from '../../utils/service'
const middleBarItemList = [
    {
        index: 1,
        imgCom: Icon1,
        spanContent: "整租",
        url: "/home/find"
    },
    {
        index: 2,
        imgCom: Icon2,
        spanContent: "合租",
        url: "/home/find"
    },
    {
        index: 3,
        imgCom: Icon3,
        spanContent: "地图找房",
        url: "/map"
    },
    {
        index: 4,
        imgCom: Icon4,
        spanContent: "要出租",
        url: ""
    }
]
// const data = Array.from(new Array(4)).map((_val, i) => (<div className="word"><Icon type="check-circle-o" size="lg"/>vrefd</div>));

const data = Array.from(new Array(4)).map(() => ({
    icon: 'https://gw.alipayobjects.com/zos/rmsportal/WXoqXTHrSnRcUwEaQgXJ.png',
}));


export default class Index extends React.Component {
    constructor(props) {
        super(props)
        this.state = {
            swiperdata: [],
            imgHeight: 176,
            showSwiper: false,
            groupsdata: [],
            newsData: []
        }
    }


    componentDidMount = async () => {
        await this.setState({
            swiperdata: (await axios.get("http://localhost:8080/home/swiper")).data.body
        })
        if (this.state.swiperdata.length > 0) {
            this.setState({
                showSwiper: true
            })
        }
        let { value: locationId } = await getLocation()
        // let {city}=(await getLocation()).content.address_detail
        // console.log(await axios.get("http://localhost:8080/home/groups?area="+locationId))
        await this.setState({
            groupsdata: (await axios.get("http://localhost:8080/home/groups?area=" + locationId)).data.body
        })
        await this.setState({
            newsData: (await axios.get("http://localhost:8080/home/news?area=" + locationId)).data.body
        })
    }
    renderMiddleBars() {
        return (
            middleBarItemList.map((item) => (
                <Flex.Item key={item.index} onClick={() => {
                    this.props.history.push(item.url)
                }}>
                    <div className="middleBar">
                        {/* 图片 */}
                        <img src={item.imgCom} />
                        {/* 描述 */}
                        <span className="spanClass">{item.spanContent}</span>
                    </div>
                </Flex.Item>
            ))
        )
    }
    renderNews() {
        return (
            this.state.newsData.map((item) => (
                <div className="newsContentWrapClass" key={item.id}>
                    <img src={`http://localhost:8080${item.imgSrc}`} />
                    <div className="right">
                        <div className="top">{item.title}</div>
                        <div className="bottom">
                            <span>{item.from}</span>
                            <span>{item.date}</span>
                        </div>
                    </div>
                </div>
            ))
        )
    }
    renderTopBar() {
        return (
            <div className="wrap">
                <div className="left">
                    <div className="left1" onClick={() => {
                        this.props.history.push("/cityList")
                    }}>
                        {/* <i></i> */}
                        <span>上海</span>
                        <i className="iconfont icon-arrow"></i>
                    </div>
                    <div className="left2">
                        {/* <i></i> */}
                        <i className="iconfont icon-seach iconClass"></i>
                        <span className="spanClass">请输入小区或地址</span>
                    </div>
                </div>
                <div className="right" onClick={() => {
                    this.props.history.push("/map")
                }}>
                    <img src={Icon3} style={{ width: "30px", height: "30px" }} />
                </div>
            </div>
        )
    }
    render() {
        return (
            <div className="outer">
                {/* //轮播图 */}
                {
                    this.state.showSwiper ? (
                        <Carousel
                            autoplay={true}
                            autoplayInterval="3000"
                            infinite
                        // beforeChange={(from, to) => console.log(`slide from ${from} to ${to}`)}
                        // afterChange={index => console.log('slide to', index)}
                        >
                            {this.state.swiperdata.map(val => (
                                <a
                                    key={val.id}
                                    href="http://www.alipay.com"
                                    style={{ display: 'inline-block', width: '100%', height: this.state.imgHeight }}
                                >
                                    <img
                                        src={`http://localhost:8080${val.imgSrc}`}
                                        alt=""
                                        style={{ width: '100%', verticalAlign: 'top' }}
                                    />
                                </a>
                            ))}
                        </Carousel>
                    ) : ""
                }
                {/* 导航栏 */}
                <div className="middleNavBarClass">
                    <Flex>
                        {this.renderMiddleBars()}

                    </Flex>
                </div>
                {/* 租房小组 */}
                <div className="groupClass">
                    <div className="wrapClass">
                        <div className="titleClass">
                            <span className="titleClass">租房小组</span>
                            <span className="more">更多</span>
                        </div>
                        <div className="gridClass">
                            {/* <Grid data={data} square={false} columnNum={2}  itemStyle={{ height: '150px' }}/> */}
                            <Grid data={this.state.groupsdata} activeStyle={false} columnNum={2} square={false} renderItem={dataItem => (
                                <div style={{ padding: '14px', display: 'flex', height: '100px' }}>
                                    <div style={{ color: '#888', fontSize: '14px', marginTop: '12px' }}>
                                        <div className="titleClass">{dataItem.title}</div>
                                        <div className="descClass">{dataItem.desc}</div>
                                    </div>
                                    <img src={`http://localhost:8080${dataItem.imgSrc}`} style={{ width: '75px', height: '75px', marginLeft: '8px' }} alt="" />
                                </div>
                            )} />
                        </div>

                    </div>
                </div>

                {/* 最新资讯 */}
                <div className="newsClass">
                    <div className="newsWrapClass">
                        <div className="titleClass">
                            <span className="titleSpanClass">最新资讯</span>
                        </div>
                        {this.renderNews()}

                    </div>
                </div>
                {/* 顶部导航栏 */}
                <div className="topBarClass">
                    {this.renderTopBar()}
                </div>
            </div>
        );
    }
}

