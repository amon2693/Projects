<template>
    <div class="top-users">
      <h3>Top Users</h3>
      <ul>
        <li v-for="user in topUsers" :key="user.id">
          {{ user.name }}
          <ul>
            <li v-for="quest in user.quests" :key="quest.id">{{ quest.name }}</li>
          </ul>
        </li>
      </ul>
    </div>
  </template>
  
  <script>
  export default {
    props: ['topUsers'],
  };
  </script>
  
  <style scoped>
  .top-users {
    margin-top: 20px;
  }
  ul {
    list-style-type: none;
    padding: 0;
  }
  </style>
  