<template>
  <div>
    <h1>Search Results</h1>
    <div class="navigation">
      <router-link v-bind:to="{ name: 'authorizedHome' }">Home</router-link>
      <router-link v-bind:to="{ name: 'location' }">Location Details</router-link>
      <router-link v-bind:to="{ name: 'quest' }">Quests</router-link>
      <!-- <router-link v-bind:to="{ name: 'rankings' }">Rankings</router-link> -->
    </div>

    <div v-if="isLoading">Loading...</div>
    <div v-else-if="results.length === 0">No results found for "{{ searchQuery }}"</div>
    <ul v-else>
      <li v-for="result in results" :key="result.id">
        {{ result.title }}
      </li>
    </ul>
  </div>
</template>

<script>
import searchService from '../services/SearchService';

export default {
  data() {
    return {
      isLoading: true,
      searchQuery: this.$route.query.q || '', 
      results: [], 
    };
  },
  async created() {
    if (this.searchQuery) {
      try {
        
        this.results = await searchService.search(this.searchQuery, 'quests');
      } catch (error) {
        console.error('Error during search:', error);
      } finally {
        this.isLoading = false;
      }
    } else {
      this.isLoading = false;
    }
  }
};
</script>

<style scoped>
.searchResults {
  display: flex;
  flex-direction: column;
  height: 100vh;
  padding: 0 20px;
  background:
    
    url('@/assets/cle.jpg') no-repeat center center fixed,
    
    linear-gradient(135deg, #1E3A8A, #3B82F6);
  background-size: cover; 
}
.navigation {
  padding: 10px;
  border-radius: 8px;
  width: 60vh;
}
.navigation a {
  color: #FFFFFF;
  text-decoration: none;
  padding: 10px;
  margin-right: 15px;
  font-weight: bold;
}
.navigation a:hover {
  background-color: #0056B3;
  border-radius: 5px;
}
.main-content {
  flex: 1;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: flex-start;
  margin-top: 20px;
  text-align: center;
}
.main-heading {
  font-size: 8rem;
  -webkit-text-fill-color: darkorange;
  margin: 0;
  border: 0.2rem solid #fff;
  border-radius: 2rem;
  padding: 0.4em;
  box-shadow: 0 0 0.2rem #fff,
              0 0 0.2rem #fff,
              0 0 2rem #2E33BC,
              0 0 0.8rem #2E33BC,
              0 0 2.8rem #2E33BC,
              inset 0 0 1.3rem #2E33BC;
}
.main-content p {
  font-family: 'Merriweather', serif; 
  font-size: 1.25rem; 
  line-height: 1.6; 
  color: #FFFFFF; 
  max-width: 800px; 
  margin: 20px 0; 
  padding: 20px; 
  background-color: rgba(53, 53, 156, 0.6); 
  border-radius: 10px; 
}
.intro-picture {
  width: 100%; 
  max-width: 800px; 
  border-radius: 10px; 
  margin-bottom: 20px; 
}
.image-gallery {
  display: flex;
  flex-wrap: wrap;
  gap: 18px;
  justify-content: center;
}
.image-gallery img {
  border-radius: 10px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
  transition: transform 0.3s ease-in-out;
}
.image-gallery img:hover {
  transform: scale(1.10);
}
.loading img {
  width: 100px;
  height: auto;
}

@keyframes pulsate {
  100% {
    text-shadow:
      0 0 4px #fff,
      0 0 11px #fff,
      0 0 19px #fff,
      0 0 40px #2E33BC,
      0 0 80px #2E33BC,
      0 0 90px #2E33BC,
      0 0 100px #2E33BC,
      0 0 150px #2E33BC;
  }
  0% {
    text-shadow:
      0 0 2px #fff,
      0 0 4px #fff,
      0 0 6px #fff,
      0 0 10px #2E33BC,
      0 0 45px #2E33BC,
      0 0 55px #2E33BC,
      0 0 70px #2E33BC,
      0 0 80px #2E33BC;
  }
}
</style>