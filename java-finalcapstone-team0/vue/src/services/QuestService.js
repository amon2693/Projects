import axios from 'axios';


const http = axios.create({
  baseURL: import.meta.env.VITE_REMOTE_API
});

export default {
  
  getAllQuests() {
    return http.get('/quests');
  },

  
  getQuestById(category) {
    return http.get(`/quests/${category}`);
  },

  
  createQuest(quest) {
    return http.post('/quests', quest);
  },

  
  updateQuest(category, quest) {
    return http.put(`/quests/${category}`, quest);
  },

  
  deleteQuest(category) {
    return http.delete(`/quests/${category}`);
  },

 
  submitReview(questId, review) {
    return http.post(`/quests/${questId}/reviews`, review, {
      headers: {
        'Content-Type': 'application/json'
      }
    });
  }
};
