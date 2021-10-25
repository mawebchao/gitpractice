import React from 'react'
import Icon3 from '../../assets/images/nav-3.png'

export class SearchHeader extends React.Component {
    constructor(props) {
        super(props)
        this.state = {
            cityName: ""
        }
    }
    renderTopBar(cityName) {
        return (
            <div className="wrap">
                <div className="left">
                    <div className="left1" onClick={() => {
                        this.props.history.push("/cityList")
                    }}>
                        {/* <i></i> */}
                        <span>{cityName}</span>
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
            <div className="topBarClass">
                {this.renderTopBar(this.state.cityName)}
            </div>
        )
    }
}