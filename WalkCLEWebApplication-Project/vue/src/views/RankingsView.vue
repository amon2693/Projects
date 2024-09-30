<template>
  <div class="rankings-view">
    <div class="navigation">
      <router-link v-bind:to="{name: 'authorizedHome'}">Home</router-link>
      <router-link v-bind:to="{ name: 'location' }">Location Details</router-link>
      <router-link v-bind:to="{name: 'quest'}">Quests</router-link>
      <router-link v-bind:to="{ name: 'user', params: { userId: currentUser.id } }">My Profile</router-link>
    </div>
    <div>
      <h1>Rankings</h1>
      <div class="reviews">
        <ReviewPost v-for="review in reviews" :key="review.id" :review="review" />
      </div>
      <TopUsers :topUsers="topUsers" />
      <SuggestedLocations :locations="suggestedLocations" />
    </div>
  </div>
</template>

<script>
import ReviewPost from '../components/ReviewPost.vue';
import TopUsers from '../components/TopUsers.vue';
import SuggestedLocations from '../components/SuggestedLocations.vue';
import RankingService from '../services/SocialService.js';

export default {
  data() {
    return {
      reviews: [],
      topUsers: [],
      suggestedLocations: [],
      isLoading: true,
      error: null,
    };
  },
  computed: {
    currentUser() {
      return this.$store.state.user;
    }
  },
  components: {
    ReviewPost,
    TopUsers,
    SuggestedLocations,
  },
  async created() {
    try {
      await Promise.all([this.fetchReviews(), this.fetchTopUsers(), this.fetchSuggestedLocations()]);
    } catch (error) {
      console.error('Failed to fetch data:', error);
      this.error = 'Failed to load rankings view.';
    } finally {
      this.isLoading = false;
    }
  },
  methods: {
    async fetchReviews() {
      const response = await RankingService.getReviews();
      this.reviews = response.data;
    },
    async fetchTopUsers() {
      const response = await RankingService.getTopUsers();
      this.topUsers = response.data;
    },
    async fetchSuggestedLocations() {
      const response = await RankingService.getSuggestedLocations();
      this.suggestedLocations = response.data;
    },
  },
};
</script>

<style scoped>
.rankings-view {
  max-width: 800px;
  margin: 0 auto;
  padding: 20px;
}
.reviews {
  margin-bottom: 20px;
}
</style>

  