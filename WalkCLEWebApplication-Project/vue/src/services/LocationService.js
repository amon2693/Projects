import axios from 'axios';

const http = axios.create({
  baseURL: import.meta.env.VITE_REMOTE_API, // Ensure this environment variable is correctly set
});

export default {
  getAllLocations() {
    return http.get('/location');
  },

  getLocationsByQuestCategory(questCategory) {
    return http.get(`/location/quest/${questCategory}`);
  },

  getLocationById(locationId) {
    return http.get(`/location/${locationId}`);
  },

  getHiddenGems() {
    return http.get('/location/hidden-gems'); // New method to get hidden gems
  },
};

