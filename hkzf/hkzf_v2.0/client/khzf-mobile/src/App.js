import { BrowserRouter as Router,  Redirect,  Route } from 'react-router-dom'
import Home from './pages/home/index'
import CityList from './pages/cityList/index'
import Map from './pages/map/index'
function App() {
  return (

    <div className="App">
      <Router>
        {/* {title} */}
        <Route path="/" render={()=><Redirect to="/home" component={Home}/>}/>
        <Route path="/home" component={Home}/>
        <Route path="/cityList" component={CityList}/>
        <Route path="/map" component={Map}/>
        {/* <a onClick={handleClick}>按钮</a> */}
      </Router>
    </div>

  );
}

export default App;
