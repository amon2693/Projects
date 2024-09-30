<template>
    <div class="badge-container">
      <div class="badge-header">
        <img :src="badge.imageUrl" alt="Badge Image" class="badge-image" />
        <div class="badge-info">
          <h2>{{ badge.name }}</h2>
          <p>{{ badge.description }}</p>
        </div>
      </div>
      <div class="badge-requirements">
        <h3>Requirements</h3>
        <p>{{ badge.requirements }}</p>
      </div>
      <div class="badge-locations">
        <h3>Locations</h3>
        <ul>
          <li v-for="location in badge.locations" :key="location.id">
            {{ location.name }} - <img :src="location.imageUrl" alt="Location Image" class="location-image" />
          </li>
        </ul>
      </div>
    </div>
  </template>
  
  <script>
  export default {
    props: {
      badge: {
        type: Object,
        required: true,
      },
    },
  };
  </script>
  
  <style scoped>
  .badge-container {
    background-color: #fff;
    border: 2px solid #e0e0e0;
    border-radius: 8px;
    padding: 20px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    max-width: 400px;
    margin: 0 auto;
  }
  
  .badge-header {
    display: flex;
    align-items: center;
    margin-bottom: 20px;
  }
  
  .badge-image {
    width: 80px;
    height: 80px;
    border-radius: 50%;
    margin-right: 15px;
  }
  
  .badge-info h2 {
    color: #1e90ff; /* Blue color for badge name */
    margin: 0;
  }
  
  .badge-info p {
    color: #333;
    margin: 5px 0 0;
  }
  
  .badge-requirements, .badge-locations {
    margin-bottom: 20px;
  }
  
  .badge-requirements h3, .badge-locations h3 {
    color: #ff8c00; /* Orange color for section headings */
  }
  
  .badge-locations ul {
    list-style: none;
    padding: 0;
  }
  
  .badge-locations li {
    margin: 10px 0;
    display: flex;
    align-items: center;
  }
  
  .location-image {
    width: 50px;
    height: 50px;
    border-radius: 8px;
    margin-left: 10px;
  }
  </style>
  