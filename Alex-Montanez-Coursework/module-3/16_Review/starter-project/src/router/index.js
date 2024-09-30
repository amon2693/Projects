import { createRouter as _createRouter, createWebHistory } from 'vue-router';
import SampleView from '../views/SampleView.vue';
import CheckoutView from '../views/CheckoutView.vue';
import ProductDetailView from '../views/ProductDetailView.vue';
import ProductsView from '../views/ProductsView.vue';
import ShoppingCart from '../views/ShoppingCartView.vue';
const routes = [
{
  path: '/checkout',
    name: 'checkout',
    component: CheckoutView
},
  {
    path: '/products',
    name: 'products',
    component: ProductsView
  },
  {
    path: '/product/:id',
    name: 'product-detail',
    component: ProductDetailView
  },
  {
    path: '/shopping-cart',
    name: 'shopping-cart',
    component: ShoppingCart
  },

];

export function createRouter () {
  return _createRouter({
    history: createWebHistory(),
    routes: routes
  })
}
