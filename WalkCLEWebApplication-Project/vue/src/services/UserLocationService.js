// src/services/UserLocationService.js
import axios from 'axios';

const http = axios.create({
  baseURL: import.meta.env.VITE_REMOTE_API
});

export default {
  getUserLocationsByUserId(userId) {
    return http.get(`/user-locations/user/${userId}`);
  },

  createUserLocation(userLocation) {
    return http.post('/user-locations', userLocation);
  },

  updateUserLocation(userLocation) {
    return http.put(`/user-locations/${userLocation.userId}/${userLocation.locationId}`, userLocation); 
  },

  getUserLocation(userId, locationId) {
    return http.get(`/user-locations/${userId}/${locationId}`);
  },

  getCheckIn(userId, locationId) {
    return http.get(`/user-locations/checkin/${userId}/${locationId}`);
  }
};