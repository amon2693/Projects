<template>
    <h2> Submit Your Answer</h2>
    <div class="answer-post">
        <form @submit.prevent="handleSubmit">
      <label for="questionId">Question ID:</label>
      <input v-model="questionId" type="number" id="questionId" required />
      
      <label for="userId">User ID:</label>
      <input v-model="userId" type="number" id="userId" required />
      
      <label for="answer">Answer:</label>
      <input v-model="answer" type="text" id="answer" required />
      
      <button type="submit">Submit</button>
    </form>
  </div>
</template>

<script>


export default {
  data() {
    return {
      questionId: '',
      userId: '',
      answer: '',
    };
  },
  methods: {
    async handleSubmit() {
      try {
        await axios.post('/questions/submitAnswer', {
          questionId: this.questionId,
          userId: this.userId,
          answer: this.answer,
        });
        alert('Answer submitted successfully');
      } catch (error) {
        console.error('There was an error submitting the answer:', error);
        alert('Failed to submit answer');
      }
    },
  },
};
</script>

<style scoped>
/* Add your styles here */
</style>