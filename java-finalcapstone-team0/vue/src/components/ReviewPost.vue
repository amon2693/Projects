<template>
    <div class="review-post">
      <h3>{{ review.title }}</h3>
      <p>{{ review.content }}</p>
      <CommentSection :comments="review.comments" />
    </div>
  </template>
  
  <script>
  import CommentSection from './CommentSection.vue';
  
  export default {
    props: ['review'],
    components: {
      CommentSection,
    },
  };
  </script>
  
  <style scoped>
  .review-post {
    border: 1px solid #ddd;
    padding: 10px;
    margin-bottom: 20px;
  }
  </style>
  