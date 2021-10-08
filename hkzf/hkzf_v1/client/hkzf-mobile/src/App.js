import { BrowserRouter as Router, Route, Link } from 'react-router-dom'

import Home from './pages/Home'
import CityList from './pages/CityList'
function App() {
  return (
    <Router>
    <div className="App">
      首页
      <ul>
        <li><Link to="/">首页</Link></li>
        <li><Link to="/cityList">城市列表</Link></li>
      </ul>
      <Route path="/" component={Home}/>
      <Route path="/cityList" component={CityList}/>
    </div>
    </Router>
  );
}

export default App;
