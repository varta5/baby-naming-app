import { useState } from 'react';
import './App.css';

function App() {

  const [babyNames, setBabyNames] = useState([
    {
      id: 1,
      name: 'Amelie'
    }, {
      id: 2,
      name: 'Bethany'
    }, {
      id: 3,
      name: 'Carol'
    }, {
      id: 4,
      name: 'Denise'
    }, {
      id: 5,
      name: 'Emily'
    }
  ]);

  return (
    <>
      <h1>{babyNames[0].name}</h1>
    </>
  )

}

export default App;
