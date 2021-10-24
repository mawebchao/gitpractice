import logo from './logo.svg';
import './App.css';
import { BrowserRouter as Router,  Redirect,  Route } from 'react-router-dom'
import Practice6 from './pages/practice6'
import Practice7 from './pages/practice7'

function App() {
  
  return (
    <div className="App">
      <Router>
        {/* <Route path="/6" render={()=><Redirect to="/home" component={Practice6}/>}/> */}
        <Route path="/6" component={Practice6} />
        <Route path="/7" component={Practice7} />
      </Router>
      
    </div>
  );
}

export default App;
