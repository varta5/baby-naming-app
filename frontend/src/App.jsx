import axios from 'axios';
import { useEffect, useState } from 'react';
import './App.css';

function App() {

  const [babyNames, setBabyNames] = useState([]);

  const [displayedBabyName, setDisplayedBabyName] = useState(null);
  const [loadingBabyNames, setLoadingBabyNames] = useState(false);

  function loadRandomBabyName() {
    setDisplayedBabyName(babyNames[Math.floor(babyNames.length * Math.random())]);
  }

  function LoadRandomBabyNameButton() {
    return (<button onClick={loadRandomBabyName}>Get random baby name!</button>)
  }

  async function loadBabyNames() {
    setLoadingBabyNames(true);
    const response = await axios.get("http://localhost:8080/api/v1/names");
    setBabyNames(response.data);
    setLoadingBabyNames(false);
  }

  useEffect(() => {
    loadBabyNames();
  }, []);

  return (
    <>
      {loadingBabyNames ? "Loading..." : <LoadRandomBabyNameButton />}
      <h1>{displayedBabyName?.name}</h1>
    </>
  )

}

export default App;
