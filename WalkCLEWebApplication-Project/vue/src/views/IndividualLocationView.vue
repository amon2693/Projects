<template>
  <div class="individual-location">
    <div class="navigation">
      <router-link :to="{ name: 'locations' }">Back to Locations</router-link>
    </div>
    <div v-if="isLoading">Loading...</div>
    <div v-else>
      <h1>{{ location.name }}</h1>
      <p>{{ location.address }}</p>
      <p>{{ location.city }}, {{ location.state }} {{ location.zip }}</p>
      <!-- Add more details here -->
    </div>
  </div>
</template>

<script>
import LocationService from '../services/LocationService';

export default {
  name: 'IndividualLocationView',
  data() {
    return {
      location: {},
      isLoading: true,
    };
  },
  async created() {
    await this.fetchLocation();
  },
  methods: {
    async fetchLocation() {
      try {
        const id = this.$route.params.id;
        const response = await LocationService.getLocationById(id);
        this.location = response.data;
      } catch (error) {
        console.error('Failed to fetch location details:', error);
      } finally {
        this.isLoading = false;
      }
    },
  },
};
</script>

<style scoped>
.individual-location {
  padding: 20px;
}
</style>
