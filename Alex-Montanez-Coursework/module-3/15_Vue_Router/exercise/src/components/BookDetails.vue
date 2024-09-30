<!-- src/components/BookDetails.vue -->
<template>
    <div>
      <h1>{{ book.title }}</h1>
      <p>{{ book.author }}</p>
      <p>{{ book.description }}</p>
      <a :href="book.moreInfoLink" target="_blank">More Information</a>
    </div>
  </template>
  
  <script>
  export default {
    props: ['book']
  }
  </script>