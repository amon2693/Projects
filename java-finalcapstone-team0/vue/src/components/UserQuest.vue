<template>
  <div>
    <h1>User Quests</h1>
    <ul>
      <li v-for="quest in quests" :key="quest.id">
        <div class="user-quest">
          <h3>{{ quest.name }}</h3>
          <p>{{ quest.description }}</p>
          <p>Completed: {{ quest.completed ? 'Yes' : 'No' }}</p>
          <h4>Locations:</h4>
          <ul>
            <li v-for="location in quest.locations" :key="location.id">
              {{ location.name }}
            </li>
          </ul>
        </div>
      </li>
    </ul>
  </div>
</template>

<script>
import UserQuestService from '../services/UserQuestService';

export default {
  data() {
    return {
      quests: []
    };
  },
  created() {
    const userId = this.$route.params.id;
    this.fetchUserQuests(userId);
  },
  methods: {
    async fetchUserQuests(userId) {
      try {
        const response = await UserQuestService.getUserQuestsByUserId(userId);
        this.quests = response.data;
      } catch (error) {
        console.error('Failed to fetch user quests:', error);
      }
    }
  }
}
</script>

  
  <style scoped>
  .user-quest {
    margin-bottom: 20px;
  }
  .user-quest ul {
    list-style: none;
    padding: 0;
  }
  .quest {
  background-color: #162447;
  padding: 10px;
  border-radius: 5px;
  box-shadow: 0 0 10px 2px rgba(255, 255, 255, 0.3);
  }
  </style>
