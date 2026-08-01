import './styles/App.css';
import { Routes, Route } from 'react-router-dom';
import Voting from './components/Voting';

function App() {

  return (
    <Routes>
      <Route path="/voting" element={<Voting />} />
    </Routes>
  )

}

export default App;
