<template>
  <div class="art-view">
    <div class="navigation">
      <router-link :to="{ name: 'authorizedHome' }" class="nav-button">Home</router-link>
      <router-link v-bind:to="{ name: 'quest' }" class="back-button">Back to Quests</router-link>
      <router-link v-bind:to="{ name: 'sports' }" class="sports">Defend the Land</router-link>
      <router-link v-bind:to="{ name: 'music' }" class="music">Cleveland Rocks!</router-link>
    </div>
    <div class="header">
      <h1 class="main-heading">
        ArtsyCLE
        <img v-if="allCheckedIn" src="@/assets/art-badge.png" alt="Badge Icon" class="badge-icon" />
      </h1>
      <p class="quote">
        “Creativity takes courage.” – Henri Matisse
      </p>
      <p class="intro">
        Enjoy all things beautiful here in Cleveland! Phantom of the Opera, world-renowned art, beautiful scenery, and more. Earn your creativity badge by seeing it all!
      </p>
      <p v-if="!allCheckedIn">Track your badge progress as you navigate your journey:</p>
      <div v-if="!allCheckedIn" class="progress-container">
        <div class="progress-bar" :style="{ width: progressPercentage + '%' }">
          {{ Math.round(progressPercentage) }}%
        </div>
      </div>
      <p v-if="allCheckedIn" class="completion-message">
        Congratulations! You've checked in at all locations and earned your badge!
      </p>
    </div>
    <div v-if="isLoading" class="loading">
      <img src="@/assets/walk.gif" alt="Loading animation" />
    </div>
    <div v-else class="content">
      <section v-for="location in locations" :key="location.id" class="location">
        <a :href="location.websiteUrl" target="_blank" class="location-link">
          <img :src="location.image" :alt="location.name" class="location-image" />
        </a>
        <div class="location-info">
          <h2 class="location-name">{{ location.name }}</h2>
          <p class="location-description">
            <a :href="location.directionsUrl" target="_blank" class="location-link">
              {{ location.address }}
            </a>
          </p>
          <button v-if="!location.checkedIn" @click="checkIn(location.id)" class="check-in-button">Check In</button>
          <p v-if="location.checkedIn" class="checked-in-message">
            Awesome job! You checked in at {{ new Date(location.checkInTimestamp).toLocaleString() }}
          </p>
        </div>
      </section>
    </div>
  </div>
</template>

<script>
import PlayHouseSquareImg from '@/assets/playhouse.jpg';
import ArtMuseumImg from '@/assets/museum.jpg';
import BotanicalGardenImg from '@/assets/garden.jpg';
import CheckInService from '@/services/CheckInService.js';

export default {
  data() {
    return {
      isLoading: true,
      locations: [
        {
          id: 1,
          name: 'Enjoy world class performances by world class talent at PlayHouse Square',
          image: PlayHouseSquareImg,
          address: '1501 Euclid Ave #200, Cleveland, OH 44115',
          directionsUrl: 'https://www.google.com/maps/dir//playhouse+square+address/@41.5061527,-81.6363762,13z/data=!4m8!4m7!1m0!1m5!1m1!1s0x8830fa7d31bc7e1d:0xd4fedf1ad239019!2m2!1d-81.6807674!2d41.5010319?entry=ttu',
          websiteUrl: 'https://www.playhousesquare.org',
          checkedIn: false,
          checkInTimestamp: null
        },
        {
          id: 2,
          name: 'Experience art like you never have before at The Cleveland Museum of Art',
          image: ArtMuseumImg,
          address: '11150 East Blvd, Cleveland, OH 44106',
          directionsUrl: 'https://www.google.com/maps/dir//11150+East+Blvd,+Cleveland,+OH+44106/@41.5078967,-81.6943731,12z/data=!4m8!4m7!1m0!1m5!1m1!1s0x8830fb8dd37a09d9:0x24667546af3346a!2m2!1d-81.6119723!2d41.5079261?entry=ttu',
          websiteUrl: 'https://www.clevelandart.org',
          checkedIn: false,
          checkInTimestamp: null
        },
        {
          id: 3,
          name: 'Come see blue skies and green scenery at Cleveland Botanical Garden',
          image: BotanicalGardenImg,
          address: '11030 East Blvd, Cleveland, OH 44106',
          directionsUrl: 'https://www.google.com/maps/dir//botanical+garden+cleveland+address/@41.5074396,-81.6441541,14z/data=!4m8!4m7!1m0!1m5!1m1!1s0x8830fb8c6b2a2705:0xb3e99d3e8bb7d36!2m2!1d-81.6095981!2d41.5111392?entry=ttu',
          websiteUrl: 'https://holdenfg.org/cleveland-botanical-garden/gardens-and-attractions/?gad_source=1',
          checkedIn: false,
          checkInTimestamp: null
        }
      ],
      userId: this.$store.state.user.id
    };
  },
  computed: {
    progressPercentage() {
      const totalLocations = this.locations.length;
      const checkedInLocations = this.locations.filter(location => location.checkedIn).length;
      return (checkedInLocations / totalLocations) * 100;
    },
    allCheckedIn() {
      return this.locations.every(location => location.checkedIn);
    }
  },
  async mounted() {
    try {
      const checkIns = await Promise.all(this.locations.map(location =>
        CheckInService.getCheckIn(this.userId, location.id)
      ));
      
      checkIns.forEach((checkInResponse, index) => {
        const location = this.locations[index];
        if (checkInResponse.data) {
          location.checkedIn = true;
          location.checkInTimestamp = checkInResponse.data.timestamp;
        }
      });
    } catch (error) {
      console.error('Error loading check-ins:', error);
    } finally {
      this.isLoading = false;
    }
  },
  methods: {
    async checkIn(locationId) {
      const location = this.locations.find(location => location.id === locationId);
      if (location) {
        try {
          const timestamp = new Date().toISOString();
          await CheckInService.addCheckIn({
            userId: this.userId,
            locationId,
            timestamp
          });

          location.checkedIn = true;
          location.checkInTimestamp = timestamp;

          alert('Check-in successful!');
        } catch (error) {
          console.error('Error checking in:', error.response ? error.response.data : error.message);
          alert('Check-in failed. Please try again.');
        }
      }
    }
  }
};
</script>

<style scoped>
.art-view {
  height: 100vh;
  width: 100vw;
  background: url('@/assets/cleart.jpg') no-repeat center center fixed;
  background-size: cover;
  color: rgba(17, 15, 11, 0.941);
  overflow-y: auto;
  padding: 20px;
  border-radius: 8px;
  box-sizing: border-box;
}

.header {
  font-size: 1.2rem;
  text-align: center;
  color: white;
  background: rgba(198, 24, 178, 0.8);
  padding: 20px;
  border-radius: 8px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
}

.navigation {
  background: rgba(0, 0, 0, 0.5);
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 10px 20px;
  height: 6vh;
  border-radius: 8px; /* Rounded corners */
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2); /* Optional: add a subtle shadow */
}

.navigation a {
  color: #fff;
  text-decoration: none;
  font-size: 1rem;
  padding: 10px;
  border-radius: 4px;
  transition: background-color 0.3s, color 0.3s;
}

.navigation a:hover {
  color: #ffde59;
  background: rgba(255, 255, 255, 0.1);
}

.back-button, .sports, .music {
  color: #fff;
  text-decoration: none;
  font-size: 1rem;
  padding: 10px;
  border-radius: 4px;
}

.back-button:hover, .sports:hover, .music:hover {
  color: #ffde59;
  background: rgba(255, 255, 255, 0.1);
}

.completion-message {
  font-size: 1.5rem;
  color: black;
  text-align: center;
  margin-top: 20px;
}


.progress-container {
  margin: 20px;
}

.progress-bar {
  background-color: black;
  height: 25px;
  border-radius: 12px;
  text-align: center;
  line-height: 25px;
  color: white;
  transition: width 0.5s;
}

.loading {
  background: rgba(0, 0, 0, 0.5);
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
}

.loading img {
  width: 80px;
  animation: spin 1s linear infinite;
}

@keyframes spin {
  0% { transform: rotate(0deg); }
  100% { transform: rotate(360deg); }
}

.content {
  background: rgba(255, 255, 255, 0.7);
  padding: 20px;
  border-radius: 8px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
}

.location {
  margin-bottom: 20px;
  text-align: center;
}

.location-link {
  color: black;
  text-decoration: none;
  font-weight: bold;
}

.location-link:hover {
  text-decoration: underline;
}

.location-image {
  width: 100%;
  max-height: 250px;
  object-fit: cover;
  border-radius: 8px;
}

.location-info {
  margin-top: 10px;
}

.location-name {
  font-size: 1.7rem;
  font-weight: bold;
  color: #333;
}

.location-description {
  font-size: 1.1rem;
  color: #666;
}

.check-in-button {
  background-color: rgba(198, 24, 178, 0.8);
  color: white;
  border: none;
  padding: 10px 20px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 1rem;
  margin-top: 10px;
  border-radius: 5px;
  cursor: pointer;
}

.check-in-button:hover {
  background-color: black;
}

.checked-in-message {
  margin-top: 10px;
  font-size: 1rem;
  color: rgba(198, 24, 178, 0.8);
}

.badge-icon {
  width: 100px;
  height: 100px;
  margin-left: 15px;
}

.main-heading {
  display: flex;
  justify-content: center;
  align-items: center;
  margin: 20px 0;
}
</style>