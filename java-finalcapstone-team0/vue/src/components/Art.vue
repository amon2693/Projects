<template>
    <div class="art-container">
      <h2 class="art-heading">Art List</h2>
      <ul class="art-list">
        <li v-for="art in art" :key="art.id" class="art-item">
          <img :src="art.image" :alt="art.name" class="art-image" />
          <h3 class="art-name">{{ art.name }}</h3>
          <p class="art-description">{{ art.description }}</p>
        </li>
      </ul>
    </div>
  </template>
  
  <script>
  export default {
    name: 'Art',
    props: {
      art: {
        type: Array,
        required: true
      }
    }
  };
  </script>
  
  <style scoped>
  /* Full-screen background image */
  html, body {
    height: 100%;
    margin: 0;
  }
  
  .art-container {
    padding: 20px;
    background-image: url('@/assets/cleart.jpg');
    background-size: cover;
    background-position: center;
    background-repeat: no-repeat;
    background-attachment: fixed;
    border-radius: 8px;
    min-height: 100vh;
  }
  
  .art-heading {
    font-size: 2rem;
    margin-bottom: 1rem;
    text-align: center;
  }
  
  .art-list {
    list-style: none;
    padding: 0;
  }
  
  .art-item {
    display: flex;
    align-items: center;
    margin-bottom: 1rem;
    padding: 10px;
    border: 1px solid #ddd;
    border-radius: 8px;
    background-color: #fff;
  }
  
  .art-image {
    width: 50px;
    height: 50px;
    object-fit: cover;
    margin-right: 15px;
    border-radius: 50%;
  }
  
  .art-name {
    font-size: 1.25rem;
    margin: 0;
  }
  
  .art-description {
    font-size: 1rem;
    color: #555;
  }
  </style>