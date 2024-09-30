<template>
    <div class="user-badges">
      <h3>Your Badges</h3>
      <div v-if="badges.length">
        <div v-for="badge in badges" :key="badge.id" class="badge">
          <img :src="badge.badgeIconUrl" alt="badge icon" />
        <p>{{ badge.badgeName }}</p>
        </div>
      </div>
      <div v-else>
        <p>No badges earned yet.</p>
      </div>
    </div>
  </template>
  
  <script>
  export default {
    props: ['badges'],
    badge: {
      type: Object,
      required: true
    }
  };
  </script>
  
  <style scoped>
  .user-badges {
    display: flex;
    flex-wrap: wrap;
  }
  .badge {
    margin: 10px;
    text-align: center;
    display: flex;
    flex-direction: column;
    align-items: center;
    background-color: #162447;
    padding: 10px;
    border-radius: 5px;
    box-shadow: 0 0 10px 2px rgba(255, 255, 255, 0.3);
  }
  .badge img {
    max-width: 100px;
  }
  </style>




  