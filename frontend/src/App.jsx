import axios from 'axios';
import { useEffect, useState } from 'react';
import './App.css';

function App() {

  const [babyNames, setBabyNames] = useState([]);

  const [displayedBabyName, setDisplayedBabyName] = useState(null);

  function loadRandomBabyName() {
    setDisplayedBabyName(babyNames[Math.floor(babyNames.length * Math.random())]);
  }

  async function loadBabyNames() {
    const response = await axios.get("http://localhost:8080/api/v1/names");
    setBabyNames(response.data);
  }

  useEffect(() => {
    loadBabyNames();
  }, []);

  return (
    <>
      <button onClick={loadRandomBabyName}>Get random baby name!</button>
      <h1>{displayedBabyName?.name}</h1>
    </>
  )

}

export default App;
