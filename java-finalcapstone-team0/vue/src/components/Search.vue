<template>
    <div>
      <input v-model="query" @input="onSearch" placeholder="Search..."/>
    </div>
  </template>
  
  <script>
  import searchService from '../services/SearchService';
  
  export default {
    data() {
      return {
        query: ''
      };
    },
    methods: {
      async onSearch() {
        if (this.query) {
          try {
            const results = await searchService.search(this.query, 'quests'); // 'quests' is the table name
            this.$emit('search', results); // Emit the results
          } catch (error) {
            console.error('Search error:', error);
          }
        }
      }
    }
  };
  </script>