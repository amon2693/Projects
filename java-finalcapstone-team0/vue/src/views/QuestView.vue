<template>
  <div class="container">
    <header class="navigation">
      <router-link :to="{ name: 'authorizedHome' }">Home</router-link>
      <router-link :to="{ name: 'sports'}">Defend the Land</router-link>
      <router-link :to="{ name: 'music'}">Cleveland Rocks!</router-link>
      <router-link :to="{ name: 'art'}">ArtsyCLE</router-link>
    </header>
    <div class="main-content">
      <div v-if="isLoading" class="loading">
        <img src="../assets/walk.gif" alt="Loading..." />
      </div>
      <div class="welcome-message">
        <h1>Ready to Level Up?</h1>
        <p>Complete epic quests and earn awesome badges!</p>
      </div>

      <div class="quest-list">
        <div v-for="quest in quests" :key="quest.id" class="quest-item">
          <h2>{{ quest.questName }}</h2>
          <p>{{ quest.questDescription }}</p>
          
          <div class="reviews">
            <h3>Reviews:</h3>
            <ul>
              <li v-for="review in getReviews(quest.id)" :key="review.id">
                <p><strong>{{ review.username }}:</strong> {{ review.comment }}</p>
              </li>
            </ul>
          </div>
        </div>
      </div>

      <div class="new-review-form">
        <h3>Submit a Review</h3>
        <form @submit.prevent="submitNewReview">
          <label for="questName">Quest Name:</label>
          <select v-model="newReview.questId" id="questName" required>
            <option value="" disabled>Select a quest</option>
            <option v-for="quest in quests" :key="quest.id" :value="quest.id">
              {{ quest.questName }}
            </option>
          </select>
          
          <label for="username">Your Name:</label>
          <input v-model="newReview.username" id="username" type="text" required />
          
          <label for="review">Review:</label>
          <textarea v-model="newReview.comment" id="review" required></textarea>
          
          <button type="submit">Submit Review</button>
        </form>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'QuestView',
  data() {
    return {
      quests: [],
      isLoading: true,
      error: null,
      newReview: {
        questId: '', // Changed from questName to questId
        username: '',
        comment: ''
      }
    };
  },
  methods: {
    async getQuests() {
      try {
        this.quests = [
          { id: 1, questName: 'Defend the Land', questDescription: 'Calling all sports fans, come see why CLE has the most devoted fans in the Land and hit interesting spots along the way.' },
          { id: 2, questName: 'Cleveland Rocks!', questDescription: 'Home of Rock & Roll, the music scene in Cleveland strikes a chord with fans and is the key for an exciting experience around town.' },
          { id: 3, questName: 'ArtsyCLE', questDescription: 'Come explore what makes Cleveland light up, from museums and gardens to the beautiful Playhouse Square, there is something for everyone!' }
        ];
      } catch (error) {
        this.error = 'Failed to get quests';
        console.error('Failed to get quests:', error);
      } finally {
        this.isLoading = false;
      }
    },
    getReviews(questId) {
      const reviews = JSON.parse(localStorage.getItem(`reviews_${questId}`)) || [];
      return reviews;
    },
    submitNewReview() {
      const { questId, username, comment } = this.newReview;
      if (!questId || !username || !comment) {
        alert('All fields are required');
        return;
      }

      const quest = this.quests.find(q => q.id === parseInt(questId));
      if (!quest) {
        alert('Quest not found');
        return;
      }

      const reviews = this.getReviews(quest.id);
      reviews.push({
        id: reviews.length + 1,
        username,
        comment
      });

      localStorage.setItem(`reviews_${quest.id}`, JSON.stringify(reviews));

      this.newReview = { questId: '', username: '', comment: '' };
    }
  },
  mounted() {
    this.getQuests();
  }
};
</script>

<style scoped>
/* Your existing styles plus styles for the new review form */
.new-review-form {
  margin: 20px 0;
  padding: 15px;
  background-color: #f9f9f9;
  border-radius: 5px;
}

.new-review-form h3 {
  margin-bottom: 15px;
}

.new-review-form label {
  display: block;
  margin: 10px 0 5px;
}

.new-review-form select,
.new-review-form input,
.new-review-form textarea {
  width: 100%;
  padding: 8px;
  margin-bottom: 10px;
}

.new-review-form button {
  padding: 10px 20px;
  background-color: #007bff;
  color: white;
  border: none;
  border-radius: 5px;
  cursor: pointer;
}

.new-review-form button:hover {
  background-color: #0056b3;
}

.reviews {
  margin-top: 20px;
}

.reviews h3 {
  margin-bottom: 10px;
}

.reviews ul {
  list-style-type: none;
  padding: 0;
}

.reviews li {
  margin-bottom: 10px;
}

.container {
  display: flex;
  flex-direction: column;
  height: 100vh;
  background-image: url('C:\Users\Student\workspace\java-finalcapstone-team0\vue\src\assets\CLESIGN.jpg'); /* Path to your background image */
  background-size: cover;
  background-position: center;
  background-repeat: no-repeat;
}

header.navigation {
  display: flex;
  justify-content: space-between;
  padding: 10px;
  background-color: rgba(58, 75, 184, 0.5); /* Semi-transparent background for header */
}

header.navigation a {
  text-align: center;
  color: white;
  text-decoration: none;
  padding: 10px;
}

.main-content {
  display: flex;
  flex-direction: column;
  flex: 1;
  padding: 20px;
}

.welcome-message {
  display: inline-block;
  text-align: center;
  margin: 10px auto;
  padding: 10px;
  border-radius: 5px;
  background-color: rgba(0, 0, 0, 0.5); /* Semi-transparent black background */
  color: rgb(231, 96, 29);
  font-size: 1.4rem;
  max-width: 90%;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.3);
}

.welcome-message:hover {
  transform: scale(1.05);
  box-shadow: 0 8px 16px rgba(0, 0, 0, 0.5);
}

.quest-list {
  display: flex;
  flex-wrap: wrap;
  gap: 20px;
}

.quest-item {
  flex: 1 1 calc(33% - 20px);
  box-sizing: border-box;
  background: white;
  border-radius: 5px;
  padding: 10px;
  box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
}

@media (max-width: 768px) {
  .quest-item {
    flex: 1 1 calc(50% - 20px);
  }
}

@media (max-width: 480px) {
  .quest-item {
    flex: 1 1 100%;
  }
}

.loading {
  text-align: center;
  margin: 20px 0;
}

.error {
  color: red;
  text-align: center;
  margin: 20px 0;
}
</style>