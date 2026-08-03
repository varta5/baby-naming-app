import { useEffect, useState } from 'react';
import { getUsers } from './../services/api';

function Login({ currentUser, setCurrentUser }) {

  const [users, setUsers] = useState([]);

  useEffect(() => {
    (async () => {
      const response = await getUsers();
      setUsers(response.data);
    })();
  }, []);

  return (
    <>
      <h1>Login page</h1>
      <h2>
        <label for="user-selection">Choose user:</label>
      </h2>
      <select name="user-selection" id="user-selection" value={currentUser} onChange={
        (selectedUser) => setCurrentUser(users.find((user) => (user.id === selectedUser.target.value)))
      }>
        <option value={-1}>-- Please select user --</option>
        {users.map((user) => (
          <option value={user.id}>{user.name}</option>
        ))}
      </select>
    </>
  );
}

export default Login;
