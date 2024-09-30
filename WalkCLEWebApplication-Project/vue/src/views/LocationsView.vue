<template>
  <div class="background-wrapper">
    <div class="content-wrapper">
      <div class="navigation">
        <router-link :to="{ name: 'authorizedHome' }" class="nav-button">Home</router-link>
        <router-link :to="{ name: 'quest' }" class="nav-button">Quests</router-link>
      </div>
      <div v-if="isLoading" class="loading">
        <img src="@/assets/walk.gif" alt="Loading..." />
      </div>
      <div v-else class="table-container">
        <LocationsList :locations="locations" />
      </div>
    </div>
  </div>
</template>

<script>
import LocationsList from '../components/LocationsList.vue';
import LocationService from '../services/LocationService';

export default {
  name: 'LocationView',
  components: {
    LocationsList,
  },
  data() {
    return {
      isLoading: true,
      locations: [], // Initialize locations array
    };
  },
  async created() {
    await this.fetchLocations();
  },
  methods: {
    async fetchLocations() {
      try {
        const response = await LocationService.getAllLocations();
        this.locations = response.data;
      } catch (error) {
        console.error('Failed to fetch locations:', error);
      } finally {
        this.isLoading = false;
      }
    },
  },
};
</script>

<style scoped>
/* Global styles to apply the background image and center content */
.background-wrapper {
  background-image: url('@/assets/lightsonwater.jpg');
  background-color: rgba(0, 0, 0, 0);
  background-size: cover;
  background-position: center;
  background-repeat: no-repeat;
  background-attachment: fixed;
  min-height: 100vh; /* Ensures the background covers the full viewport height */
  width: 100%; /* Ensures the background covers the full width */
  position: relative; /* Allows content to be positioned over it */
  display: flex; /* Flexbox to center content horizontally and vertically */
  justify-content: center; /* Center content horizontally */
  align-items: center; /* Center content vertically */
}

.content-wrapper {
  display: flex;
  flex-direction: column;
  align-items: center; /* Center content horizontally within content-wrapper */
  width: 100%;
  max-width: 1200px; /* Optional: limit maximum width */
  padding: 20px;
  box-sizing: border-box; /* Ensure padding is included in width */
  background-color: rgba(255, 255, 255, 0.171); /* Background color for content */
  border-radius: 8px; /* Rounded corners for content */
  box-shadow: 0 2px 5px rgba(52, 34, 247, 0.79); /* Shadow for content */
}

.navigation {
  display: flex;
  justify-content: space-between; /* Distribute space evenly between buttons */
  width: 100%; /* Full width to use available space */
  max-width: 300px; /* Optional: limit maximum width of the navigation */
  margin-bottom: 20px; /* Add some space below the navigation */
}

.nav-button {
  padding: 10px 20px;
  text-decoration: none; /* Remove underline from links */
  color: #007bff; /* Button color */
  border: 1px solid #007bff; /* Border color matching button color */
  border-radius: 4px; /* Rounded corners for buttons */
  background-color: #fff; /* Button background color */
  text-align: center; /* Center text within button */
}

.nav-button:hover {
  background-color: black;
}

.table-container {
  width: 100%; /* Ensure the table container takes full width within content-wrapper */
  display: flex;
  justify-content: center; /* Center the table within table-container */
}

table {
  width: 100%;
  max-width: 1200px; /* Optional: limit table width */
}
</style>