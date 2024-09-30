<template>
    <h1>Shopping Cart</h1>
    <router-link v-bind:to="{ name: 'products'}">Back to products </router-link>
        &nbsp;
        <router-link v-bind:to="{ name: 'checkout'}">Checkout </router-link>
</template>

<script>

export default {

}

</script>

<style scoped>
</style>