import logo from './logo.svg';
import './App.css';
import { useState, useEffect } from 'react'
function App() {
  const imageURLlist = [
    { id: 1, url: "https://www.eveningwater.com/my-web-projects/js/26/img/1.jpg" },
    { id: 2, url: "https://www.eveningwater.com/my-web-projects/js/26/img/2.jpg" },
    { id: 3, url: "https://www.eveningwater.com/my-web-projects/js/26/img/3.jpg" },
    { id: 4, url: "https://www.eveningwater.com/my-web-projects/js/26/img/4.jpg" },
    { id: 5, url: "https://www.eveningwater.com/my-web-projects/js/26/img/5.jpg" },
    { id: 6, url: "https://www.eveningwater.com/my-web-projects/js/26/img/6.jpg" },
  ];

  const [currentIndex, setCurrentIndex] = useState(0);
  const clickHandler=(newIndex) =>{
    setCurrentIndex(newIndex)
  }
  return (
    <div className="App">
      {
        imageURLlist.map(item => (
          <div className={`divClass ${(item.id - 1) === currentIndex ? "active" : ""}`}
            onClick={clickHandler.bind(this,(item.id - 1))}
            key={item.id} style={{ backgroundImage: "url(" + item.url + ")", backgroundRepeat: "no-repeat", backgroundPosition: "center center", backgroundSize: "cover" }}>
            美女{item.id}
          </div>
        ))
      }
    </div>
  );
}

export default App;
