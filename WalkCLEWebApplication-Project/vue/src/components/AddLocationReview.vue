<template>
  <div class="review-component">
    <!-- Display Average Rating -->
    <div class="well">
      <span class="amount" v-on:click="updateFilter()">{{ averageRating }}</span>
      Average Rating
    </div>

    <!-- Display All Reviews -->
    <div class="reviews-list">
      <div v-if="reviews.length > 0">
        <div v-for="(review, index) in reviews" :key="index" class="review-item">
          <p class="review-rating">Rating: {{ review.rating }}</p>
          <p class="review-comment">{{ review.comment }}</p>
        </div>
      </div>
      <div v-else>
        <p>No reviews available.</p>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  props: ['reviews'],
  methods: {
    updateFilter() {
      this.$store.commit('UPDATE_FILTER', 0);
    }
  },
  computed: {
    averageRating() {
      const reviews = this.reviews;

      if (reviews.length === 0) {
        return 0;
      }

      let sum = reviews.reduce((currentSum, review) => {
        return currentSum + review.rating;
      }, 0);
      return (sum / reviews.length).toFixed(2);
    }
  }
};
</script>

<style scoped>
.review-component {
  padding: 1rem;
}

.well {
  display: inline-block;
  width: 15%;
  border: 1px solid rgb(230, 93, 30);
  border-radius: 6px;
  text-align: center;
  margin: 0.25rem;
  padding: 0.25rem;
}

.amount {
  color: rgb(11, 42, 180);
  display: block;
  font-size: 2.5rem;
}

.amount:hover {
  cursor: pointer;
}

.reviews-list {
  margin-top: 1rem;
}

.review-item {
  border-bottom: 1px solid #ddd;
  padding: 0.5rem 0;
}

.review-rating {
  font-weight: bold;
}

.review-comment {
  margin: 0.25rem 0;
  color: #555;
}
</style>
