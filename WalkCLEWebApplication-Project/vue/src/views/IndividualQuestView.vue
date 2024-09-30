<template>
  <div class="individual-quest-view">
    <div class="navigation">
      <router-link :to="{ name: 'authorizedHome' }">Home</router-link>
      <router-link :to="{ name: 'quest' }">Quests</router-link>
    </div>
    
    <div v-if="isLoading" class="loading">
      <img src="../assets/walk.gif" alt="Loading..." />
    </div>
    
    <div>
      <h1 v-if="quest.questName">{{ quest.questName }}</h1>
      <p v-if="quest.questDescription">{{ quest.questDescription }}</p>
      <h2>Locations</h2>
      <ul v-if="locations.length > 0">
        <li v-for="location in locations" :key="location.locationId">
          {{ location.locationName }} - {{ location.address }}
        </li>
      </ul>
      <h3 v-else>No locations found for this</h3>
    </div>
    <form @submit.prevent="submitAnswers">
      <div v-for="question in questions" :key="question.id">
        <div>
          <h2>{{ question.question_name }}</h2>
          <p>{{ question.question_text }}</p>
          <input type="hidden" name="questionId" :value="question.id" />
          <input type="hidden" name="questCategory" :value="question.questCategory" />
          <label for="answer">Your Answer:</label>
          <input type="text" id="answer" v-model="question.answer" />
        </div>
      </div>
      <button type="submit">Submit</button>
    </form>
  </div>
</template>
<script>
import questService from '../services/QuestService';
import LocationService from '../services/LocationService';
import questionService from '../services/QuestionService';

//Import components if needed

//import SubmitAnswer from '../components/SubmitAnswer.vue';
//import ReviewPost from '../components/ReviewPost.vue';
export default {
  name: 'IndividualQuestView',
  components: {
    //SubmitAnswer,
    //ReviewPost,
  },
  data() {
    return {
      quest: {},
      locations: [],
      questions: [],
      isLoading: true,
    };
  },
  async created() {
    await this.fetchQuestDetails();
  },
  methods: {
    async fetchQuestDetails() {
      try {
        const id = this.$route.params.id;

        // Fetch quest details
        const questResponse = await questService.getQuestById(id);
        this.quest = questResponse.data;
        // Fetch locations
        const locationsResponse = await LocationService.getLocationsByQuestId(id);
        this.locations = locationsResponse.data;
        // Fetch questions
        const questionsResponse = await questionService.getQuestionByQuestId(id);
        this.questions = questionsResponse.data;
      } catch (error) {
        console.error('Failed to fetch quest or locations:', error);
      } finally {
        this.isLoading = false;
      }
    },
  },
};
</script>
<style scoped>
.individual-quest-view {
  padding: 20px;
}
.navigation {
  padding: 10px;
}
.loading img {
  width: 100px;
  height: auto;
}
</style>


