<template>
    <table>
        <thead>
            <th>#</th>
            <th>Product</th>
            <th>Price</th>
            <th>Actions</th>
        </thead>
        <tbody>
            <tr v-for="(product, i) in $store.state.products" v-bind:key="product.id"></tr>
            <td>{{ i }}</td>
            <td>{{ product.name }}</td>
            <td>${{ product.price }}</td>
            <td><button>Add to cart</button></td>
        </tbody>
    </table>
</template>

<script>

export default {

}

</script>

<style scoped>
</style>