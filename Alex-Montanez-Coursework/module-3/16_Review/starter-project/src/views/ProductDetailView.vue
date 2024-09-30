<template>
    <h1>Product Detail</h1>
    <nav class="top-level-nav">
        <router-link v-bind:to="{ name: 'products'}">Back to products </router-link>
        &nbsp;
        <router-link v-bind:to="{ name: 'shopping-cart'}">Go to Cart </router-link>
        <router-link v-bind:to="{ name: 'checkout'}">Checkout </router-link>

    </nav>
</template>

<script>

export default {

}

</script>

<style scoped>
</style>