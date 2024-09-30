import axios from 'axios';

const http = axios.create({
  baseURL: import.meta.env.VITE_REMOTE_API,
});

export default {
  getUser(userId) {
    return http.get(`/users/${userId}`);
  },

  updateUser(user) {
    return http.put(`/users/${user.id}`, user);
  },

  uploadProfilePicture(userId, file) {
    const formData = new FormData();
    formData.append('file', file);
    return http.post(`/users/${userId}/profile-picture`, formData);
  },
};