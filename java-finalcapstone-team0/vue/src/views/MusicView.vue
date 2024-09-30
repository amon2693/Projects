<template>
  <div class="music-view">
    <div class="navigation">
      <router-link :to="{ name: 'authorizedHome' }" class="nav-button">Home</router-link>
      <router-link :to="{ name: 'quest' }" class="back-button">Back to Quests</router-link>
      <router-link :to="{ name: 'sports' }" class="sports">Defend the Land</router-link>
      <router-link :to="{ name: 'art' }" class="art">ArtsyCLE</router-link>
    </div>
    <div class="header">
      <h1 class="main-heading">
        Cleveland Rocks!
        <!-- Conditional rendering for the badge next to the header -->
        <img v-if="allCheckedIn" src="@/assets/music-badge.png" alt="Music Badge" class="badge-icon" />
      </h1>
      <p class="quote">
        “"Cleveland is the Reason" - Kid Cudi
      </p>
      <p class="intro">
        Cleveland has long been a historical figure in music. Rock out with the city and earn your music badge today!
      </p>
      <!-- Conditional rendering for progress message, bar, and badge -->
      <p v-if="!allCheckedIn" class="progress-message">
        Track your badge progress as you navigate your journey:
      </p>
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
import PlayHouseSquareImg from '@/assets/rhof.jpg';
import ArtMuseumImg from '@/assets/hob1.jpg';
import BotanicalGardenImg from '@/assets/agora.jpg';
import CheckInService from '@/services/CheckInService.js';

export default {
  data() {
    return {
      isLoading: true,
      locations: [
        {
          id: 7,
          name: 'Come see an endless list of famous artists perform their biggest hits at The House of Blues',
          image: ArtMuseumImg,
          address: '308 Euclid Ave, Cleveland, OH 44114',
          directionsUrl: 'https://www.google.com/maps/dir//house+of+blues+address/@41.4979684,-81.7053688,13z/data=!4m8!4m7!1m0!1m5!1m1!1s0x8830fa8003ed92d7:0xc93a0abde7990d15!2m2!1d-81.690957!2d41.4995174?entry=ttu',
          websiteUrl: 'https://www.houseofblues.com/cleveland',
          checkedIn: false,
          checkInTimestamp: null
        },
        {
          id: 8,
          name: 'Turn the bass up and enjoy your time at The Agora',
          image: BotanicalGardenImg,
          address: '5000 Euclid Ave #101, Cleveland, OH 44103',
          directionsUrl: 'https://www.google.com/maps/dir//the+agora+address/@41.5029923,-81.6659341,14z/data=!3m1!5s0x8830fa50f3faaad3:0x8ef7c6e047f6b91!4m8!4m7!1m0!1m5!1m1!1s0x8830fa516bb8385d:0x774e33e889fb6ddf!2m2!1d-81.6539579!2d41.503712?entry=ttu',
          websiteUrl: 'https://www.agoracleveland.com',
          checkedIn: false,
          checkInTimestamp: null
        },
        {
          id: 9,
          name: 'Where Rock and Roll was born, see its history at the Rock and Roll Hall of Fame',
          image: PlayHouseSquareImg,
          address: '1100 E 9th St, Cleveland, OH 44114',
          directionsUrl: 'https://www.google.com/maps/dir//rock+and+roll+hall+of+fame+cleveland+address/@41.5093172,-81.7056469,13z/data=!3m1!5s0x8830f08372853671:0x97828889072890f0!4m8!4m7!1m0!1m5!1m1!1s0x8830f0830dc7921d:0x971b9d1e295a165f!2m2!1d-81.6953685!2d41.5085414?entry=ttu',
          websiteUrl: 'https://www.rockhall.com',
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
.music-view {
  height: 100vh;
  width: 100vw;
  background: url('@/assets/rock.jpg') no-repeat center center fixed;
  background-size: cover;
  color: rgba(188, 21, 35, 0.941);
  overflow-y: auto;
  padding: 20px;
  box-sizing: border-box;
}

.header {
  font-size: 1.2rem;
  text-align: center;
  color: white;
  background: rgba(188, 21, 35, 0.8);
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
  border-radius: 8px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
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

.back-button, .sports, .art {
  color: #fff;
  text-decoration: none;
  font-size: 1rem;
  padding: 10px;
  border-radius: 4px;
}

.back-button:hover, .sports:hover, .art:hover {
  color: #ffde59;
  background: rgba(255, 255, 255, 0.1);
}

.progress-message {
  font-size: 1.2rem;
  color: white;
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

.completion-message {
  font-size: 1.5rem;
  color: black;
  text-align: center;
  margin-top: 20px;
}

.badge-container {
  text-align: center;
  margin-top: 20px;
}

.badge-image {
  width: 50px;
  height: auto;
}

.badge-icon {
  width: 100px;
  height: 100px;
  margin-left: 15px;
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
  background-color: rgba(188, 21, 35, 0.941);
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
  color: rgba(188, 21, 35, 0.941);
}

.main-heading {
  display: flex;
  justify-content: center;
  align-items: center;
  margin: 20px 0;
}
</style>