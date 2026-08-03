import { useState } from 'react';
import './styles/App.css';
import { Navigate, Routes, Route } from 'react-router-dom';
import Login from './components/Login';
import Voting from './components/Voting';

function App() {

  const [currentUser, setCurrentUser] = useState(null);

  return (
    <Routes>
      <Route path="/login" element={<Login currentUser={currentUser} setCurrentUser={setCurrentUser} />} />
      <Route path="/voting" element={
        currentUser !== null
        ? <Voting currentUser={currentUser} setCurrentUser={setCurrentUser} />
        : <Navigate to="/login" /> }
      />
    </Routes>
  )

}

export default App;
