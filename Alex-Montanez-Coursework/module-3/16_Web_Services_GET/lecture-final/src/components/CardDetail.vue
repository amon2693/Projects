<template>
  <div>
    <h1>{{ card.title }}</h1>
    <p>{{ card.description }}</p>
    <p>Status: {{ card.status }}</p>
    <comments-list v-bind:comments="card.comments" />
  </div>
</template>

<script>
import CommentsList from '../components/CommentsList.vue';

export default {
  components: {
    CommentsList
  },
  props: ['card']
};
</script>
