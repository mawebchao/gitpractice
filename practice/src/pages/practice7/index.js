import './index.css'
import {MyListCom} from '../../components/practice7/component1'
import {useState} from 'react'
function Practice7() {
    let idList = [1, 2, 3, 4]
    let contentList = ["活动未开始", "活动已开始", "活动快完成", "活动已结束"]
    let [currentIndex, setCurrentIndex] = useState(0);
    let previous=()=>{
        setCurrentIndex(currentIndex>=1?--currentIndex:currentIndex)
    }
    let next=()=>{
        setCurrentIndex(currentIndex<(idList.length-1)?++currentIndex:currentIndex)
    }
    return (
        <div className="practiceClass">
            <div>
                <MyListCom contentList={idList} currentIndex={currentIndex}/>
                <MyListCom contentList={contentList} currentIndex={currentIndex}/>
            </div>
            <div>
                <button onClick={previous}>上一步</button>
                <button onClick={next}>下一步</button>
            </div>
        </div>
    );
}

export default Practice7;