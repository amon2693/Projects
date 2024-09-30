<template>
  <div>
    <BookCard
      v-for="book in books"
      :key="book.isbn"
      :book="book"
      :link="`/book/${book.isbn}`"
    />
  </div>
</template>

<script>
import BookCard from './BookCard.vue';

export default {
  components: {
    BookCard
  },
  data() {
    return {
      books: [] // Populate with actual books data
    };
  }
}
</script>

<style>
.book-container {
  display: flex;
  justify-content: space-evenly;
  flex-wrap: wrap;
}
</style>