<template>
    <div>
      <h1>Quests </h1>
      <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Riddle</th>
            </tr>
        </thead>
        <tbody>
            <tr v-for="question in questions" v-bind:key="question.questionId">
            <td>{{ question.questionId }}</td>
            <td><router-link v-bind:to="{name: '', params: { id: question.questionId }}">
                {{ question.questionName }}
                </router-link>
            </td>
            <td>{{ question.questionText }}</td> 
            </tr>
        </tbody>
    </table>
    </div>
  </template>
  
  <script>
  import questionService from '../services/QuestionService';
  
  
  export default {
    data() {
      return {
        quests: [],
        isLoading: true,
      };
    },
    async created() {
      try {
        const response = await questionService.getAllQuestions();
        this.questions = response.data;
      } catch (error) {
        console.error('Failed to fetch questions:', error);
      } finally {
        this.isLoading = false;
      }
    }
  };
  </script>