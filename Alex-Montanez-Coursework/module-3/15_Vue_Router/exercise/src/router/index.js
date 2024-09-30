import Vue from 'vue';
import HomeView from '../views/HomeView.vue';
import VueRouter from 'vue-router';
import MyBooksView from '../views/MyBooksView.vue';
import NewBookView from '../views/NewBookView.vue';
import BookDetailsView from '../views/BookDetailsView.vue';

Vue.use(VueRouter);

const routes = [
  {
    path: '/', 
    name: 'home',
    component: HomeView
  },
  {
    path: '/myBooks',
    name: 'my-books',
    component: MyBooksView
  },
  {
    path: '/addBook',
    name: 'AddBook',
    component: NewBookView
  },
  {
    path: '/book/:isbn',
    name: 'BookDetails',
    component: BookDetailsView
  }

];

const router = new VueRouter({
  mode: 'history',
  routes
});

export default router;