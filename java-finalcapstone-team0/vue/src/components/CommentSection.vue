<template>
    <div class="comment-section">
      <h4>Comments</h4>
      <ul>
        <li v-for="comment in comments" :key="comment.id">{{ comment.text }}</li>
      </ul>
      <textarea v-model="newComment" placeholder="Add a comment"></textarea>
      <button @click="postComment">Post Comment</button>
    </div>
  </template>
  
  <script>
  export default {
    props: ['comments'],
    data() {
      return {
        newComment: '',
      };
    },
    methods: {
      postComment() {
        // logic to post comment
        //this.comments.push({ id: Date.now(), text: this.newComment });
        this.newComment = '';
      },
    },
  };
  </script>
  
  <style scoped>
  .comment-section {
    border-top: 1px solid #ddd;
    padding-top: 10px;
  }
  textarea {
    width: 100%;
    margin-top: 10px;
  }
  button {
    margin-top: 10px;
  }
  </style>
  