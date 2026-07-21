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

  const [displayedBabyName, setDisplayedBabyName] = useState(babyNames[1]);

  function loadRandomBabyName() {
    setDisplayedBabyName(babyNames[Math.floor(babyNames.length * Math.random())]);
  }

  return (
    <>
      <button onClick={loadRandomBabyName}>Get random baby name!</button>
      <h1>{displayedBabyName.name}</h1>
    </>
  )

}

export default App;
