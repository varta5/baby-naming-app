import { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { getUsers } from './../services/api';
import Modal from './Modal';

function Login({ currentUser, setCurrentUser }) {

  const navigate = useNavigate();
  const [users, setUsers] = useState([]);
  const [isOpenCreateUserModal, setIsOpenCreateUserModal] = useState(false);

  useEffect(() => {
    (async () => {
      const response = await getUsers();
      setUsers(response.data);
    })();
  }, []);

  function openCreateUserModal() {
    setIsOpenCreateUserModal(true);
  }

  return (
    <>
      <h1>Login page</h1>
      <h2>
        <label for="user-selection">Choose user:</label>
      </h2>
      <select name="user-selection" id="user-selection" value={currentUser} onChange={
        (selectedUser) => {
          setCurrentUser(users.find((user) => (user.id === selectedUser.target.value)));
          navigate('/voting');
        }
      }>
        <option value={-1}>-- Please select user --</option>
        {users.map((user) => (
          <option value={user.id}>{user.name}</option>
        ))}
      </select>
      <div>
        <button onClick={openCreateUserModal}>Create new user</button>
      </div>
      <Modal isOpen={isOpenCreateUserModal} onClose={() => setIsOpenCreateUserModal(false)}>
        Contents of the modal. To be injected.
      </Modal>
    </>
  );
}

export default Login;
