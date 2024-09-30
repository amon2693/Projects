import axios from 'axios';

const http = axios.create({
  baseURL: import.meta.env.VITE_REMOTE_API
});

export default {

  getUserQuestsByUserId(userId) {
    return http.get(`/user-quests/user/${userId}`);
  },

  getUserQuestsByCategory(questCategory) {
    return http.get(`/user-quests/category/${questCategory}`);
  },

  createUserQuest(userQuest) {
    return http.post(`/user-quests`, userQuest);
  },

  updateUserQuest(id, userQuest) {
    return http.put(`/user-quests/${id}`, userQuest);
  },

  awardBadge(userQuest) {
    return http.post(`/user-quests/award-badge`, userQuest);
  }
}