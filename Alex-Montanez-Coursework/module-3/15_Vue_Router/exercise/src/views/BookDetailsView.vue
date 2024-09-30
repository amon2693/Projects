<!-- src/views/BookDetailsView.vue -->
<template>
    <div>
      <BookDetails :book="book" />
    </div>
  </template>
  
  <script>
  import BookDetails from '../components/BookDetails.vue';
  
  export default {
    components: {
      BookDetails
    },
    data() {
      return {
        book: null
      };
    },
    async created() {
      const isbn = this.$route.params.isbn;
      // Fetch the book details based on ISBN
      this.book = await this.fetchBookDetails(isbn);
    },
    methods: {
      async fetchBookDetails(isbn) {
        // Replace with actual fetch logic
        return {
          title: 'Sample Book',
          author: 'Author Name',
          description: 'Book description here.',
          moreInfoLink: 'https://example.com'
        };
      }
    }
  }
  </script>