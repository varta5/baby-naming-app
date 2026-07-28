import axios from 'axios';

const api = axios.create({
  baseURL: 'http://localhost:8080/api',
  headers: {
    'Content-Type': 'application/json',
  },
});

export async function getBabyNames() {
  const response = await api.get('/v1/names');
  return response;
}

export async function postVote(babyNameId, choice) {
  const body = {
    name_id: babyNameId,
    choice: choice
  }
  const response = await api.post('/v1/votes', body);
  return response;
}
