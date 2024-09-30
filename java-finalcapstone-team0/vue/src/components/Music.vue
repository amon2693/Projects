<template>
    <div class="music-container">
      <h2 class="music-heading">Music List</h2>
      <ul class="music-list">
        <li v-for="music in music" :key="music.id" class="music-item">
          <img :src="music.image" :alt="music.name" class="music-image" />
          <h3 class="music-name">{{ music.name }}</h3>
          <p class="music-description">{{ music.description }}</p>
        </li>
      </ul>
    </div>
  </template>
  
  <script>
  export default {
    name: 'Music',
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
  
  .music-container {
    padding: 20px;
    background-image: url('@/assets/cleart.jpg');
    background-size: cover;
    background-position: center;
    background-repeat: no-repeat;
    background-attachment: fixed;
    border-radius: 8px;
    min-height: 100vh;
  }
  
  .music-heading {
    font-size: 2rem;
    margin-bottom: 1rem;
    text-align: center;
  }
  
  .music-list {
    list-style: none;
    padding: 0;
  }
  
  .music-item {
    display: flex;
    align-items: center;
    margin-bottom: 1rem;
    padding: 10px;
    border: 1px solid #ddd;
    border-radius: 8px;
    background-color: #fff;
  }
  
  .music-image {
    width: 50px;
    height: 50px;
    object-fit: cover;
    margin-right: 15px;
    border-radius: 50%;
  }
  
  .music-name {
    font-size: 1.25rem;
    margin: 0;
  }
  
  .music-description {
    font-size: 1rem;
    color: #555;
  }
  </style>