<template>
    <div>
      <h1>Quests </h1>
      <table>
        <thead>
            <tr>
                <th>Category</th>
                <th>Name</th>
                <th>Description</th>
            </tr>
        </thead>
        <tbody>
            <tr v-for="quest in quests" v-bind:key="quest.questCategory">
            <td>{{ quest.questCategory }}</td>
            <td><router-link v-bind:to="{name: 'individual-quest', params: { category: quest.questCategory }}">
                {{ quest.questName }}
                </router-link>
            </td>
            <td>{{ quest.questDescription }}</td> 
            </tr>
        </tbody>
    </table>
    </div>
  </template>
  
  <script>
  import questService from '../services/QuestService';
  
  
  export default {
    data() {
      return {
        quests: [],
        isLoading: true,
      };
    },
    async created() {
      try {
        const response = await questService.getAllQuests();
        this.quests = response.data;
      } catch (error) {
        console.error('Failed to fetch quests:', error);
      } finally {
        this.isLoading = false;
      }
    }
  };
  </script>