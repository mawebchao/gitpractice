import { useState, useEffect } from 'react'
import './index.css'
export default function Practice6() {
    const baseURL="https://www.eveningwater.com/my-web-projects/js/26/img"
    const maxCount=15;

    const [currentIndex, setCurrentIndex] = useState(0);
    const clickHandler = (newIndex) => {
        setCurrentIndex(newIndex)
    }
    let idList=Array.from(new Array(maxCount).keys());
    return (
        
        < div className="practice6" >
            {
                idList.map(item => (
                    <div className={`divClass ${(item) === currentIndex ? "active" : ""}`}
                        onClick={clickHandler.bind(this, (item))}
                        key={item} style={{ backgroundImage: "url(" + (baseURL+"/"+(item+1)+".jpg") + ")", backgroundRepeat: "no-repeat", backgroundPosition: "center center", backgroundSize: "cover" }}>
                        美女{item}
                    </div>
                ))
            }
        </div >
    )
}