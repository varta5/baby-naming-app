import { useEffect, useState } from 'react';
import './styles/App.css';
import VoteButtons from './components/VoteButtons';
import { getBabyNames } from './services/api';

function App() {

  const [babyNames, setBabyNames] = useState([]);
  const [displayedBabyName, setDisplayedBabyName] = useState(null);

  function loadNewRandomBabyName() {
    removeBabyNameFromList();
    loadRandomBabyName();
  }

  function removeBabyNameFromList() {
    const index = babyNames.indexOf(displayedBabyName);
    babyNames.splice(index, 1);
  }

  function loadRandomBabyName() {
    setDisplayedBabyName(babyNames[Math.floor(babyNames.length * Math.random())]);
  }

  async function loadBabyNames() {
    const response = await getBabyNames();
    setBabyNames(response.data);
  }

  useEffect(() => {
    loadBabyNames();
  }, []);

  useEffect(() => {
    loadRandomBabyName();
  }, [babyNames]);

  return (
    <div class="app">
      <h1>Would you like this name for your baby?</h1>
      <h2>Number of names you could choose from: {babyNames.length}</h2>
      <button onClick={loadBabyNames}>Refresh possible names</button>
      <h2>{displayedBabyName?.name}</h2>
      <VoteButtons babyNameId={displayedBabyName?.id} actionAfterVote={loadNewRandomBabyName}/>
    </div>
  )

}

export default App;
