<template>
    <div>
      <h1>Hidden Gems</h1>
      <div v-if="hiddenGems.length === 0">No hidden gems found.</div>
      <ul v-else>
        <li v-for="gem in hiddenGems" :key="gem.locationId">
          {{ gem.locationName }} - {{ gem.description }}
        </li>
      </ul>
    </div>
  </template>
  
  <script>
  import LocationService from '../services/LocationService';
  
  export default {
    data() {
      return {
        hiddenGems: [],
      };
    },
    created() {
      this.fetchHiddenGems();
    },
    methods: {
      async fetchHiddenGems() {
        try {
          const response = await LocationService.getHiddenGems();
          this.hiddenGems = response.data;
        } catch (error) {
          console.error('Failed to fetch hidden gems:', error);
        }
      }
    }
  }
  </script>
  
  