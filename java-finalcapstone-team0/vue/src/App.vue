<template>
  <div id="capstone-app">
    <div id="nav">
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
      <form class="search-container" @submit.prevent="handleSearch">
        <input type="text" placeholder="Search.." v-model="searchQuery" />
        <button type="submit">Search</button>
      </form>
    </div>
    <router-view />
  </div>
</template>

<script>
export default {
  data() {
    return {
      searchQuery: '',
    };
  },
  methods: {
    async handleSearch() {
      if (this.searchQuery.trim()) {
        try {
          await this.$store.dispatch('search', this.searchQuery);
          this.$router.push({ name: 'searchResults' });
        } catch (error) {
          console.error('Error during search:', error);
        }
      } else {
        console.warn('Search query is empty');
      }
    },
  },
};
</script>
<style scoped>

#capstone-app {
  font-family: Arial, sans-serif;
  color: #333;
  margin: 0;
  padding: 0;
}

#nav {
  background-color: black; /* Bootstrap primary color */
  color: white;
  padding: 10px 20px;
  display: flex;
  justify-content: flex-start;
  align-items: center;
  box-shadow: 0 2px 4px rgba(0,0,0,0.1);
}

#nav a {
  color: white;
  text-decoration: none;
  font-weight: bold;
  font-size: 16px;
}

#nav a:hover {
  text-decoration: underline;
}
.search-container {
  position: absolute;
  top: 10px; /* Adjust top spacing as needed */
  right: 10px; /* Adjust right spacing as needed */
}

router-view {
  padding: 20px;
}

</style>
