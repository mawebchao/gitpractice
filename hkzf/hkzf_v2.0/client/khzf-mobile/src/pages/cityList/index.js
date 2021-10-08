import { NavBar, Icon } from 'antd-mobile'
import styles from './index.module.css'
import React from 'react'
import { AutoSizer, List } from 'react-virtualized';
import axios from 'axios'
const list = new Array(100).fill("frdvceegrgbfd")


export default class CityList extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            cityObj: [],
            cityIndexList: [],
            showCity: false,
            nowIndex: 0
        }
        this.cityComponent = React.createRef()
    }
    async componentDidMount() {
        //1.获取城市列表信息
        //1.1基础城市信息
        let cityList = (await axios.get("http://localhost:8080/area/city?level=1")).data.body
        cityList = cityList.sort((obj1, obj2) => {
            var val1 = obj1.pinyin;
            var val2 = obj2.pinyin;
            if (val1 < val2) {
                return -1;
            } else if (val1 > val2) {
                return 1;
            } else {
                return 0;
            }
        })
        let cityIndexList = Array.from(new Set(cityList.map((city) => city.short.substring(0, 1))))
        let nowCityObj = {}
        cityIndexList.map((index) => {
            nowCityObj[index] = cityList.filter(function (item) {
                return item.short.substring(0, 1) === index
            })
        })
        if (nowCityObj != {} && cityIndexList != []){
            this.setState({ cityObj: nowCityObj, showCity: true, cityIndexList: cityIndexList })
            this.cityComponent.current.measureAllRows()
        }
    }
    rowRenderer = ({
        key, // Unique key within array of rows
        index, // Index of row within collection
        isScrolling, // The List is currently being scrolled
        isVisible, // This row is visible within the List (eg it is not an overscanned row)
        style, // Style object to be applied to row (to position it)
    }) => {
        let letter = this.state.cityIndexList[index]
        return (
            <div key={key} style={style} className={styles.divClass}>
                <div className={styles.indexClass}>{letter}</div>
                {
                    this.state.cityObj[letter].map((city) => (
                        <div key={city.value} className={styles.cityClass}>
                            {city.label}
                        </div>
                    ))
                }
            </div>
        );
    }
    clickListHandler=(clickedIndex) =>{
        let { nowIndex, cityIndexList } = this.state
        if (nowIndex !== clickedIndex){
            this.setState({ nowIndex: cityIndexList.indexOf(clickedIndex + "") })
            this.cityComponent.current.scrollToRow(cityIndexList.indexOf(clickedIndex + ""))
        }

    }
    renderRightList = () => {
        let { nowIndex, cityIndexList } = this.state
        return (
            this.state.cityIndexList.map((cityIndex) => {
                return (

                    <li className={cityIndex === cityIndexList[nowIndex] ? styles.li_active_Class : styles.li_inactive_Class} key={cityIndex} onClick={() => this.clickListHandler(cityIndex)}>
                        <span className={cityIndex === cityIndexList[nowIndex] ? styles.span_actice_Class : ""}>{cityIndex}</span>
                    </li>
                )
            })
        )
    }
    onRowsRendered = ({ startIndex }) => {
        let { nowIndex } = this.state
        if (nowIndex !== startIndex)
            this.setState({ nowIndex: startIndex })
    }
    getRowHeight = ({ index }) => {
        return this.state.cityObj[this.state.cityIndexList[index]].length * 46 + 50
    }
    render() {
        return (
            <div className={styles.rootClass}>
                {/* 顶部导航栏 */}
                <div className={styles.topNavBar}>
                    <NavBar
                        mode="light"
                        icon={<Icon type="left" className={styles.iconClass} />}
                        onLeftClick={() => this.props.history.go(-1)}
                    >城市选择</NavBar>
                </div>
                {/* 城市列表 */}
                <AutoSizer>
                    {({ width, height }) =>
                    (
                        this.state.showCity ?
                            <List
                                ref={this.cityComponent}
                                width={width}
                                height={height}
                                rowCount={this.state.cityIndexList.length}
                                rowHeight={this.getRowHeight}
                                rowRenderer={this.rowRenderer}
                                onRowsRendered={this.onRowsRendered}
                                scrollToIndex={this.state.nowIndex}
                                scrollToAlignment="start"
                            /> : ""
                    )}
                </AutoSizer>

                {/* 右侧索引列表 */}
                <ul className={styles.rightListClass}>
                    {this.renderRightList()}
                    {/* <li className={styles.li_inactive_Class}>
                        <span>a</span>
                    </li>
                    <li className={styles.li_active_Class}><span className={styles.span_actice_Class}>b</span></li>
                    <li className={styles.li_inactive_Class}><span>c</span></li>
                    <li className={styles.li_inactive_Class}><span>d</span></li>
                    <li className={styles.li_inactive_Class}><span>e</span></li> */}
                </ul>
            </div>

        )
    }
}