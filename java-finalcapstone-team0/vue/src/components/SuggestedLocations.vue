<template>
  <div class="suggest-location-form">
    <h2>Suggest a New Location</h2>
    <form @submit.prevent="submitSuggestion">
      <div>
        <label for="locationName">Location Name:</label>
        <input v-model="suggestedLocation.locationName" required />
      </div>
      <div>
        <label for="address">Address:</label>
        <input v-model="suggestedLocation.address" />
      </div>
      <div>
        <label for="locationLink">Website Link:</label>
        <input v-model="suggestedLocation.locationLink" placeholder="https://example.com" />
      </div>
      <div>
        <label for="description">Description:</label>
        <textarea v-model="suggestedLocation.description"></textarea>
      </div>
      <div>
        <label for="wheelchairAccessible">Wheelchair Accessible:</label>
        <input type="checkbox" v-model="suggestedLocation.wheelchairAccessible" />
      </div>
      <div>
        <label for="kidFriendly">Kid-Friendly:</label>
        <input type="checkbox" v-model="suggestedLocation.kidFriendly" />
      </div>
      <div>
        <label for="publicRestroom">Public Restroom Available:</label>
        <input type="checkbox" v-model="suggestedLocation.publicRestroom" />
      </div>
      <div>
        <label for="cost">Cost:</label>
        <input v-model="suggestedLocation.cost" />
      </div>
      <div>
        <label for="questCategory">Quest Category:</label>
        <select v-model="suggestedLocation.questCategory">
          <option disabled value="">Select a category</option>
          <option v-for="category in questCategories" :key="category.id" :value="category.id">
            {{ category.name }}
          </option>
        </select>
      </div>
      <button type="submit">Submit</button>
    </form>
  </div>
</template>

<script>
export default {
  data() {
    return {
      suggestedLocation: {
        locationName: '',
        address: '',
        locationLink: '',  // Added for website link
        description: '',
        wheelchairAccessible: false,
        kidFriendly: false,
        publicRestroom: false,
        cost: '',
        questCategory: null,
      },
      questCategories: [
        // Example categories; replace with actual data from your API or database
        { id: 1, name: 'Historical' },
        { id: 2, name: 'Adventure' },
        { id: 3, name: 'Food & Drink' },
        // Add more categories as needed
      ]
    };
  },
  methods: {
    async submitSuggestion() {
      try {
        await axios.post('/api/suggested-locations', this.suggestedLocation);
        alert('Location suggested successfully!');
      } catch (error) {
        console.error('Error suggesting location:', error);
        alert('There was an error suggesting the location.');
      }
    }
  }
};
</script>

  
  <style scoped>
  .suggested-locations {
    display: flex;
    flex-wrap: wrap;
    margin-top: 20px;
  }
  .scrolling-list {
    display: flex;
    overflow-x: auto;
  }
  .location {
    margin-right: 10px;
    text-align: center;
    background-color: #162447;
    padding: 10px;
    border-radius: 5px;
    margin-right: 10px;
    margin-bottom: 10px;
    box-shadow: 0 0 10px 2px rgba(255, 255, 255, 0.3);
  }
  .location img {
    width: 100px;
    height: 100px;
  }
  </style>


  
  