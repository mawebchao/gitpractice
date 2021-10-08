import React from 'react';
import ReactDOM from 'react-dom';
import App from './App';

ReactDOM.render(
  <React.StrictMode>
    <App />

  </React.StrictMode>,
  document.getElementById('root')
);

// let obj ={
//   a:12,
//   f:function(){
//     return this;
//   },
//   obj2:{
//     f2:function(){
//       return this
//     }
//   }
// }

// let f3=obj.f
// console.log(f3.call({
//   hhh:"vfd"
// }))