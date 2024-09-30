<template>
    <div>
      <h1>Rating Summary</h1>
      <div v-if="isLoading">Loading...</div>
      <div v-else-if="error">{{ error }}</div>
      <ul v-else>
        <li v-for="location in locations" :key="location.locationId">{{ location.locationName }}</li>
      </ul>
    </div>
  </template>
  
  <script>
  //import locationService from '@/services/locationService';
  
  export default {
    data() {
      return {
        locations: [],
        isLoading: true,
        error: null,
      };
    },
    async created() {
      try {
        const response = await location.getLocations();
        this.locations = response.data;
      } catch (error) {
        this.error = 'Failed to fetch locations';
        console.error('Failed to fetch locations:', error);
      } finally {
        this.isLoading = false;
      }
    }
  };
  </script>
  
  <style scoped>
  ul {
    list-style-type: none;
    padding: 0;
  }
  li {
    padding: 8px 0;
  }
  </style>
  