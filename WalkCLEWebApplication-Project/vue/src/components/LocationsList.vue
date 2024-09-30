<template>
  <div class="container">
    <h1 class="heading">Locations</h1>
    <div class="filters">
      <select v-model="selectedSort" @change="sortLocations">
        <option value="distance">Sort by Distance</option>
        <option value="quest">Sort by Quest Type</option>
      </select>
    </div>
    <div class="locations-list">
      <div class="location-item" v-for="location in sortedLocations" :key="location.locationId">
        <img :src="location.locationPic" alt="Location Image" class="location-image" />
        <div class="location-details">
          <a :href="location.locationLink" target="_blank" class="location-name">
            {{ location.locationName }}
          </a>
          <div class="location-quest"><span class="label">QUEST:</span> {{ location.questName }}</div>
          <div class="location-address"><span class="label">ADDRESS:</span> {{ location.address }}</div>
          <div class="location-description">{{ location.description }}</div>
          <div class="location-features">
            <span>Wheelchair Accessible: {{ location.wheelchairAccessible ? 'Yes  | ' : 'No' }}</span>
            <span>Kid-Friendly: {{ location.kidFriendly ? 'Yes  |' : 'No' }}</span>
            <span>Public Restroom: {{ location.publicRestroom ? 'Yes  | ' : 'No' }}</span>
          </div>
          <div class="location-cost">Cost: {{ location.cost }}</div>
          <div class="location-distance">Distance: {{ location.distance.toFixed(2) }} miles</div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import locationService from '../services/LocationService';
import { calculateDistance } from '../services/DistanceService';

export default {
  data() {
    return {
      locations: [],
      userLocation: null,
      isLoading: true,
      selectedSort: 'distance',
    };
  },
  async created() {
    try {
      const response = await locationService.getAllLocations();
      this.locations = response.data;
      this.userLocation = await this.getUserLocation();
      this.locations = this.locations.map(location => {
        const distance = calculateDistance(
          this.userLocation.latitude,
          this.userLocation.longitude,
          location.latitude,
          location.longitude
        );
        return { ...location, distance };
      });
      this.sortLocations(); // Initial sort
    } catch (error) {
      console.error('Failed to fetch locations or user location', error);
    } finally {
      this.isLoading = false;
    }
  },
  computed: {
    sortedLocations() {
      // Return sorted locations based on the selected sort option
      if (this.selectedSort === 'distance') {
        return this.locations.slice().sort((a, b) => a.distance - b.distance);
      } else if (this.selectedSort === 'quest') {
        return this.locations.slice().sort((a, b) => a.questName.localeCompare(b.questName));
      }
      return this.locations;
    },
  },
  methods: {
    getUserLocation() {
      return new Promise((resolve, reject) => {
        if ('geolocation' in navigator) {
          navigator.geolocation.getCurrentPosition(
            (position) => {
              const { latitude, longitude } = position.coords;
              resolve({ latitude, longitude });
            },
            (error) => {
              reject(new Error('Error getting location: ' + error.message));
            }
          );
        } else {
          reject(new Error('Geolocation is not supported by this browser.'));
        }
      });
    },
    sortLocations() {
      // Trigger computed property to re-sort locations
      // This method is invoked when the sorting option changes
    }
  }
};
</script>

<style scoped>
/* Existing styles */
.filters {
  margin-bottom: 20px;
}

.filters select {
  margin-right: 10px;
  padding: 5px;
}

/* Styling for other elements remains unchanged */
.container {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  padding: 20px;
  border-radius: 8px;
  min-height: 100vh;
  box-shadow: 0 2px 5px rgba(52, 34, 247, 0.79);
  max-width: 1200px;
  width: 100%;
}

.heading {
  font-size: 3rem;
  -webkit-text-fill-color: darkorange;
  margin: 0;
  border: 0.2rem solid rgba(255, 255, 255, 0.427);
  border-radius: 2rem;
  padding: 0.4em;
  text-align: center;
  width: 100%;
  max-width: 100%;
  box-shadow: 0 0 0.2rem rgba(255, 255, 255, 0),
              0 0 0.2rem rgba(255, 255, 255, 0),
              0 0 2rem #2E33BC,
              0 0 0.8rem #2E33BC,
              0 0 2.8rem #2E33BC,
              inset 0 0 1.3rem #2E33BC;
}

.locations-list {
  list-style: none;
  padding: 0;
  margin: 0;
}

.location-item {
  display: flex;
  align-items: center;
  margin-bottom: 1rem;
  padding: 10px;
  border: 1px solid #dddddd80;
  border-radius: 8px;
  background-color: rgba(255, 255, 255, 0.836);
}

.location-image {
  width: 150px;
  height: 150px;
  object-fit: cover;
  margin-right: 15px;
  border-radius: 50%;
}

.location-details {
  flex: 1;
}

.location-name {
  font-size: 1.25rem;
  color: #1a73e8;
  text-decoration: none;
}

.location-name:hover {
  text-decoration: underline;
}

.location-quest, .location-address, .location-description, .location-features, .location-cost {
  font-size: 1rem;
  color: #555;
  margin: 0.5rem 0;
}

.location-quest .label, .location-address .label {
  font-weight: bold;
}

.location-features {
  font-size: 0.9rem;
  color: #333;
}

@media (max-width: 768px) {
  .location-image {
    width: 40px;
    height: 40px;
  }

  .location-details {
    font-size: 0.9rem;
  }
}
</style>