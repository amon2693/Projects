<!-- src/components/NewBookForm.vue -->
<template>
  <form @submit.prevent="submitForm">
    <!-- form fields -->
    <button type="submit">Add Book</button>
  </form>
</template>

<script>
export default {
  methods: {
    submitForm() {
      // Assuming form submission logic here
      this.$router.push('/myBooks');
    }
  }
}
</script>
