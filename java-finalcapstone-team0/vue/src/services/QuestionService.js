import axios from 'axios';

const http = axios.create({
  baseURL:import.meta.env.VITE_REMOTE_API
});

export default {
    getAllQuestions() {
      return http.get(`/questions`);
    },
    getQuestionById(id) {
      return http.get(`/questions/${id}`);
    },
    createQuestion(question) {
      return http.post(`/questions`, question);
    },

    updateQuestion(id, question) {
      return http.put(`/questions/${id}`, question);
    },

    deleteQuestion(id) {
      return http.delete(`/questions/${id}`);
    },

    submitAnswer(questionId, userId, answer) {
        return http.post('/questions/submitAnswer', null, {
            params: {
                questionId: questionId,
                userId: userId,
                answer: answer
            }
        });
    },

    getQuestionByQuestId (questId) {
        return http.get(`/questions/${questId}`);
    }

  };