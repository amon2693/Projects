<template>
  <div class="user-profile">
    <div class="navigation">
      <router-link v-bind:to="{ name: 'authorizedHome' }">Home</router-link>
      <router-link v-bind:to="{ name: 'locations' }">Locations</router-link>
      <router-link v-bind:to="{ name: 'quest' }">Quests</router-link>
      <router-link v-bind:to="{ name: 'rankings' }">Rankings</router-link>
    </div>
    <div v-if="isLoading" class="loading">
      <img src="@/assets/walk.gif" alt="Loading animation" />
    </div>
    <div v-else>
      <h1>{{ user.username }}'s Profile</h1>
      <ProfilePicture :initialProfilePictureUrl="user.profilePicture" @update-picture="updateProfilePicture" />
      <div class="profile-details">
        <h2>{{ user.username }}</h2>
        <p>Role: {{ user.authorities.join(', ') }}</p>
        <button @click="updateUserProfile">Update Profile</button>
      </div>
      <div class="badges-section">
        <h3>Locations You've Been</h3>
        <UserLocation v-for="location in user.locations || []" :key="location.id" :location="location" />
      </div>
      <div class="quests-section">
        <h3>Quests in Progress</h3>
        <UserQuest v-for="quest in user.quests.filter(q => !q.completed)" :key="quest.id" :quest="quest" />
      </div>
      <div class="completed-quests-section">
        <h3>Completed Quests</h3>
        <UserQuest v-for="quest in user.quests.filter(q => q.completed)" :key="quest.id" :quest="quest" />
      </div>
      <div class="suggested-locations">
        <h3>Suggested Locations</h3>
        <SuggestedLocations :locations="user.suggestedLocations || []" />
      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios';
import ProfilePicture from '../components/ProfilePicture.vue';
import UserLocation from '../components/UserLocation.vue';
import UserQuest from '../components/UserQuest.vue';
import SuggestedLocations from '../components/SuggestedLocations.vue';

export default {
  components: {
    ProfilePicture,
    UserLocation,
    UserQuest,
    SuggestedLocations,
  },
  data() {
    return {
      user: {
        id: '',
        profilePicture: '',
        username: '',
        authorities: [],
        locations: [],
        quests: [],
        suggestedLocations: [],
      },
      isLoading: true, // to handle loading state
    };
  },
  computed: {
    currentUser() {
      return this.$store.state.user;
    }
  },
  beforeRouteEnter(to, from, next) {
    console.log("User ID:", to.params.userId);
    axios.get(`/users/${to.params.userId}`)
      .then(response => {
        console.log("User Data:", response.data);
        next(vm => {
          vm.user = response.data;
          vm.isLoading = false;
        });
      })
      .catch(error => {
        console.error('Failed to fetch user data:', error);
        next(vm => vm.$router.push({ name: 'home' }));
      });
  },
  methods: {
    async updateProfilePicture(file) {
      try {
        const formData = new FormData();
        formData.append('file', file);
        const response = await axios.post(`/users/${this.user.id}/profile-picture`, formData);
        this.user.profilePicture = response.data.profilePicture;
      } catch (error) {
        console.error('Failed to upload profile picture:', error);
      }
    },
    async updateUserProfile() {
      try {
        const response = await axios.put(`/users/${this.user.id}`, this.user);
        this.user = response.data;
      } catch (error) {
        console.error('Failed to update user profile:', error);
      }
    },
  },
};
</script>

<style scoped>
.myStuff {
  max-width: 800px;
  margin: 0 auto;
  padding: 20px;
  background-color: #1a1a2e;
  color: #e0e0e0;
  border-radius: 10px;
  box-shadow: 0 0 20px 5px rgba(0, 0, 255, 0.5);
}

.navigation {
  display: flex;
  align-items: center;
  margin-bottom: 20px;
}

.navigation a {
  color: #00ffff;
  text-decoration: none;
  padding: 10px;
  border-radius: 5px;
  transition: background-color 0.3s;
}

.navigation a:hover {
  background-color: rgba(0, 255, 255, 0.2);
}

.loading img {
  width: 100px;
  margin: 20px auto;
  display: block;
}

.badges,
.quests {
  display: flex;
  flex-wrap: wrap;
  margin: 20px 0;
}

.badges > *,
.quests > * {
  margin-right: 10px;
  margin-bottom: 10px;
  background-color: #162447;
  padding: 10px;
  border-radius: 5px;
  box-shadow: 0 0 10px 2px rgba(255, 255, 255, 0.3);
}

.badges,
.quests {
  display: flex;
  flex-wrap: wrap;
}

.search-container input:focus {
  outline: none;
  border-color: #00ffff;
  box-shadow: 0 0 5px rgba(0, 255, 255, 0.5);
}

.loading img {
  display: block;
  margin: 0 auto;
}


<style scoped>
html, body {
  height: 100%;
  margin: 0;
  font-family: Arial, sans-serif;
}

/* Styling for the entire quest component */
.user-quest {
  margin-bottom: 20px;
  padding: 15px;
  border-radius: 8px;
  background-color: #162447;
  box-shadow: 0 0 15px rgba(0, 0, 0, 0.5);
  color: white;
}

/* Styling for the quest titles */
.user-quest h3 {
  margin-top: 0;
  font-size: 1.5rem;
  color: #1f4068;
}

/* Styling for the quest descriptions */
.user-quest p {
  font-size: 1rem;
  margin: 10px 0;
  color: #e0e0e0;
}

/* Styling for the locations list */
.user-quest ul {
  list-style-type: none;
  padding: 0;
}

.user-quest li {
  margin-left: 10px;
  padding: 5px 0;
  color: #e0e0e0;
}

/* Styling for individual quests */
.quest {
  background-color: #1f4068;
  padding: 10px;
  border-radius: 5px;
  box-shadow: 0 0 10px 2px rgba(255, 255, 255, 0.3);
  margin-bottom: 20px;
}

/* Navigation styling */
.navigation {
  display: flex;
  flex-direction: column;
  text-align: center;
  height: 100%;
  padding: 10px;
  background-color: #220929;
  border-radius: 8px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.3);
}

.navigation:hover {
  background-color: #0d0811;
}

/* Button styling for quest interactions */
button {
  background-color: #220929;
  color: white;
  border: none;
  padding: 10px;
  border-radius: 5px;
  cursor: pointer;
  font-size: 1rem;
}

button:hover {
  background-color: #1f1f1f;
}

button:focus {
  outline: none;
  box-shadow: 0 0 5px #007BFF;
}

</style>
