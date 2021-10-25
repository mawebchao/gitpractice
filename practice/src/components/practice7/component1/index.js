import './index.css'


// @flow
import * as React from 'react';
export class MyListCom extends React.Component{
    constructor(props){
        super(props)
    }
    render() {
        let {contentList,currentIndex}=this.props
        let progressPercent = () => {
            console.log((currentIndex + 1) / (contentList.length-1) * 100 + "%")
            return (currentIndex ) / (contentList.length-1) * 510+"px"
        }
        let getBorderColor=(index)=>{
            return index<=currentIndex?"blue":"grey"
        }
        return (
            <div className="comClass">
                <div className="progress" style={{ width: progressPercent()}}></div>
                {
                    contentList.map((element, index) =>
                        <div className="itemClass" key={index} style={{ borderColor: getBorderColor(index) }}>{element}</div>
                    )
                }
            </div>
        );
    };
};