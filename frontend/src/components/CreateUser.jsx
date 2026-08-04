import { useNavigate } from 'react-router-dom';
import { createUser } from './../services/api';

function CreateUser({ setCurrentUser }) {

  const navigate = useNavigate();

  async function handleCreateUser(userName) {
    if (!userName) {
      alert("Please provide a username!");
      return;
    };
    const response = await createUser(userName);
    setCurrentUser(response.data);
    navigate('/voting');
  }

  return (
    <>
      <h3>
        <label for="user-name">Username:</label>
      </h3>
      <input type="text" id="user-name" />
      <button onClick={
        () => handleCreateUser(document.getElementById("user-name").value)
      }>Create user!</button>
    </>
  )
}

export default CreateUser;
