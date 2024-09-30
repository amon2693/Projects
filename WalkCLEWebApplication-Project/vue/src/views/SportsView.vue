<template>
  <div class="sports-view">
    <div class="navigation">
      <router-link :to="{ name: 'authorizedHome' }" class="nav-button">Home</router-link>
      <router-link :to="{ name: 'quest' }" class="back-button">Back to Quests</router-link>
      <router-link :to="{ name: 'music' }" class="music">Cleveland Rocks!</router-link>
      <router-link :to="{ name: 'art' }" class="art">ArtsyCLE</router-link>
    </div>
    <div class="heading-container">
      <h1 class="main-heading">Defend The Land</h1>
      <img v-if="allCheckedIn" src="@/assets/sports-badge.png" alt="Badge" class="badge-icon" />
    </div>
    <p class="intro">
      Take on the Cleveland Sports gauntlet! From touchdowns in the snow to home runs and hot dogs, Cleveland has it all. Visit all of our beautiful stadiums and earn your badge to be a CLE fan for life.
    </p>
    <p v-if="allCheckedIn" class="completion-message">
      Congratulations! You've checked in at all locations and earned your badge!
    </p>

    <!-- Conditional rendering for progress message and bar -->
    <p v-if="!allCheckedIn" class="progress-message">
      Track your badge progress as you navigate your journey:
    </p>
    <div v-if="!allCheckedIn" class="progress-container">
      <div class="progress-bar" :style="{ width: progressPercentage + '%' }">
        {{ Math.round(progressPercentage) }}%
      </div>
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
import basketballStadiumImg from '@/assets/cavs.jpg';
import baseballStadiumImg from '@/assets/progressive.jpg';
import firstEnergyStadiumImg from '@/assets/firstenergy.jpg';
import CheckInService from '@/services/CheckInService.js';

export default {
  data() {
    return {
      isLoading: true,
      locations: [
        {
          id: 4,
          name: 'Visit the Dawg Pound of the Cleveland Browns at Cleveland Browns Stadium',
          image: firstEnergyStadiumImg,
          address: '100 Alfred Lerner Way, Cleveland, OH 44114',
          directionsUrl: 'https://www.google.com/maps/dir//100+Alfred+Lerner+Way,+Cleveland,+OH+44114/@41.5075052,-81.6990149,17z/data=!4m9!4m8!1m0!1m5!1m1!1s0x8830f0844e772e77:0x5e4803df837195f5!2m2!1d-81.6990149!2d41.5075052!3e0?entry=ttu',
          websiteUrl: 'https://www.clevelandbrowns.com',
          checkedIn: false,
          checkInTimestamp: null
        },
        {
          id: 5,
          name: 'Enjoy a day with the Cleveland Guardians at Progressive Field',
          image: baseballStadiumImg,
          address: '2401 Ontario St, Cleveland, OH 44115',
          directionsUrl: 'https://www.google.com/maps/dir//2401+Ontario+St,+Cleveland,+OH+44115/@41.4970258,-81.6842371,17z/data=!4m9!4m8!1m0!1m5!1m1!1s0x8830fa86e092ee37:0xbe4596cc96d9dba3!2m2!1d-81.6842371!2d41.4970258!3e0?entry=ttu',
          websiteUrl: 'https://www.mlb.com/guardians',
          checkedIn: false,
          checkInTimestamp: null
        },
        {
          id: 6,
          name: 'Go All In with the Cleveland Cavaliers at Rocket Mortgage FieldHouse',
          image: basketballStadiumImg,
          address: '1 Center Court, Cleveland, OH 44115',
          directionsUrl: 'https://www.google.com/maps/dir//rocket+mortgage+fieldhouse+address/@41.4983001,-81.7037859,13z/data=!3m1!5s0x8830fa8109e8c465:0x7edf0a3aefa69f05!4m8!4m7!1m0!1m5!1m1!1s0x8830fa81ba7c99b5:0x53fafe5c51529920!2m2!1d-81.6880574!2d41.4965474?entry=ttu',
          websiteUrl: 'https://www.nba.com/cavaliers',
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
.sports-view {
  position: relative;
  height: 100vh;
  width: 100vw;
  background: url('@/assets/sports.jpg') no-repeat center center fixed;
  background-size: cover;
  color: white;
  overflow-y: auto;
}

.sports-view::before {
  content: '';
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background: rgba(0, 0, 0, 0.5);
  z-index: 1;
}

.sports-view > * {
  position: relative;
  z-index: 2;
}

.navigation {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 0 20px;
  height: 6vh;
}

.navigation a {
  background-color: rgba(0, 0, 0, 0.3);
  padding: 10px 15px;
  border-radius: 5px;
  color: #ffffff;
  text-decoration: none;
  font-size: 1rem;
  transition: background-color 0.3s, color 0.3s;
}

.navigation a:hover {
  background-color: rgba(255, 255, 255, 0.3);
  color: #ffeb3b;
}

.heading-container {
  display: flex;
  justify-content: center;
  align-items: center;
  margin: 20px 0;
}

.main-heading {
  font-size: 3rem;
  text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.7);
  text-align: center;
}

.badge-icon {
  width: 100px;
  height: 100px;
  margin-left: 15px;
}

.intro {
  font-size: 1.2rem;
  line-height: 1.6;
  margin: 20px auto;
  max-width: 800px;
  text-align: center;
  padding: 0 20px;
}

.completion-message {
  font-size: 1.5rem;
  color: #80deea;
  text-align: center;
  margin: 20px auto;
  max-width: 800px;
}

.progress-message {
  font-size: 1.5rem;
  text-align: center;
  margin: 20px auto;
}

.progress-container {
  margin: 20px;
}

.progress-bar {
  background-color: #de7c13;
  height: 25px;
  border-radius: 12px;
  text-align: center;
  line-height: 25px;
  color: white;
  transition: width 0.5s;
}

.loading {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
}

.loading img {
  width: 100px;
  animation: spin 1s linear infinite;
}

@keyframes spin {
  0% { transform: rotate(0deg); }
  100% { transform: rotate(360deg); }
}

.content {
  padding: 20px;
}

.location {
  width: 100vw;
  margin-bottom: 30px;
  text-align: center;
  position: relative;
}

.location-link {
  display: block;
  width: 100%;
}

.location-image {
  width: 100%;
  height: auto;
  object-fit: cover;
  max-height: 60vh;
  border-radius: 8px;
}

.location-info {
  background: rgba(0, 0, 0, 0.7);
  padding: 20px;
  border-radius: 8px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.6);
  margin-top: 15px;
  color: white;
  position: relative;
  z-index: 2;
}

.location-name {
  font-size: 1.5rem;
  margin: 10px 0;
  color: #de7c13;
}

.location-description {
  font-size: 1rem;
  line-height: 1.5;
}

.location-link {
  color: #80deea;
  text-decoration: none;
  font-weight: bold;
}

.location-link:hover {
  text-decoration: underline;
}

.check-in-button {
  background-color: #de7c13;
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
  background-color: #80deea;
}

.checked-in-message {
  margin-top: 10px;
  font-size: 1rem;
  color: #de7c13;
}

:global(html, body) {
  margin: 0;
  padding: 0;
  height: 100%;
  width: 100%;
}
</style>