import axios from 'axios';

const defaultHeaders = {
    'Content-Type': 'application/json',
  }
const api = axios.create({
  baseURL: 'http://localhost:8080/api',
  headers: defaultHeaders,
});

export async function createUser(userName) {
  const body = {
    name: userName
  }
  const response = await api.post('/v1/users', body);
  return response;
}

export async function getBabyNames() {
  const response = await api.get('/v1/names');
  return response;
}

export async function createVote(babyNameId, choice, currentUserId) {
  const body = {
    name_id: babyNameId,
    choice: choice
  }
  const headers = {
    ...defaultHeaders,
    'Current-User-Id': currentUserId
  };
  const response = await api.post('/v1/votes', body, {headers: headers});
  return response;
}

export async function getUsers() {
  const response = await api.get('/v1/users');
  return response;
}
