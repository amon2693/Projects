<template>
    <div>
      <h2>Search Results</h2>
      <div v-if="results.length > 0">
        <div v-for="result in results" :key="result.id">
          <div>{{ result }}</div>
        </div>
      </div>
      <div v-else>
        <p>No results found</p>
      </div>
    </div>
  </template>
  
  <script>
  export default {
    props: ['results'],
  };
  </script>