import axios from 'axios';

const http = axios.create({
  baseURL: import.meta.env.VITE_REMOTE_API
});

export default {
  getCheckIn(userId, locationId) {
    return http.get(`/checkins/${userId}/${locationId}`);
  },
  
  addCheckIn(data) {
    return http.post('/checkins', data); // Send data as CheckIn object
  }
}