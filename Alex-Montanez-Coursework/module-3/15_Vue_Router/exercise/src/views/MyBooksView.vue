<!-- src/views/MyBooksView.vue -->
<template>
  <div>
    <ReadingList />
    <router-link to="/addBook">Add New Book</router-link>
  </div>
</template>

<script>
import ReadingList from '../components/ReadingList.vue';

export default {
  components: {
    ReadingList
  }
}
</script>