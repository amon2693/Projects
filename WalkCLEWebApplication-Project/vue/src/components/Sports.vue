<template>
    <div class="sports-container">
      <h2 class="sports-heading">Sports List</h2>
      <ul class="sports-list">
        <li v-for="sport in sports" :key="sport.id" class="sports-item">
          <img :src="sport.image" :alt="sport.name" class="sports-image" />
          <h3 class="sports-name">{{ sport.name }}</h3>
          <p class="sports-description">{{ sport.description }}</p>
        </li>
      </ul>
    </div>
  </template>
  
  <script>
  export default {
    name: 'Sports',
    props: {
      sports: {
        type: Array,
        required: true
      }
    }
  };
  </script>
  
  <style scoped>
  
  html, body {
    height: 100%;
    margin: 0;
  }
  
  .sports-container {
    padding: 20px;
    background-image: url('@/assets/clesports.jpg');
    background-size: cover;
    background-position: center;
    background-repeat: no-repeat;
    background-attachment: fixed;
    border-radius: 8px;
    min-height: 100vh;
  }
  
  .sports-heading {
    font-size: 2rem;
    margin-bottom: 1rem;
    text-align: center;
  }
  
  .sports-list {
    list-style: none;
    padding: 0;
  }
  
  .sports-item {
    display: flex;
    align-items: center;
    margin-bottom: 1rem;
    padding: 10px;
    border: 1px solid #ddd;
    border-radius: 8px;
    background-color: #fff;
  }
  
  .sports-image {
    width: 50px;
    height: 50px;
    object-fit: cover;
    margin-right: 15px;
    border-radius: 50%;
  }
  
  .sports-name {
    font-size: 1.25rem;
    margin: 0;
  }
  
  .sports-description {
    font-size: 1rem;
    color: #555;
  }
  </style>