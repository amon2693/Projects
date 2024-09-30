// src/services/RankingService.js
import axios from 'axios';

const http = axios.create({
  baseURL: import.meta.env.VITE_REMOTE_API,
});

export default {
  getReviews() {
    return http.get('/reviews');
  },

  getTopUsers() {
    return http.get('/users/top');
  },

  getSuggestedLocations() {
    return http.get('/locations/suggested');
  },

  getLocationRatings() {
    return http.get('/locations/ratings');
  },

  postComment(reviewId, comment) {
    return http.post(`/reviews/${reviewId}/comments`, { text: comment });
  },
};
