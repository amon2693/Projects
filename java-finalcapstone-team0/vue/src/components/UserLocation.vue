<template>
    <div>
      <h1>Check-In Details</h1>
      <p>User ID: {{ checkIn.userId }}</p>
      <p>Location ID: {{ checkIn.locationId }}</p>
      <p>Timestamp: {{ checkIn.timestamp }}</p>
      <p>Achieved: {{ checkIn.achieved }}</p>
    </div>
  </template>
  
  <script>
  import UserLocationService from '../services/UserLocationService.js';
  
  export default {
    data() {
      return {
        checkIn: {},
        userLocation: []
      };
    },
    created() {
      this.fetchCheckInDetails();
    },
    methods: {
      async fetchCheckInDetails() {
        try {
          const response = await UserLocationService.getCheckIn(this.$route.params.userId, this.$route.params.locationId);
          this.checkIn = response.data;
        } catch (error) {
          console.error('Failed to fetch check-in details:', error);
        }
      }
    }
  };
  </script>
  