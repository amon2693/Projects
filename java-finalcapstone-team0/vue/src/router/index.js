import { createRouter, createWebHistory } from 'vue-router';
import { useStore } from 'vuex';

// Import components
import AuthorizedHomeView from '../views/AuthorizedHomeView.vue';
import HomeView from '../views/HomeView.vue';
import LoginView from '../views/LoginView.vue';
import LogoutView from '../views/LogoutView.vue';
import RegisterView from '../views/RegisterView.vue';
import QuestView from '../views/QuestView.vue';
import LocationsView from '../views/LocationsView.vue';
import IndividualQuestView from '../views/IndividualQuestView.vue';
import UserView from '../views/UserView.vue';
import RankingsView from '../views/RankingsView.vue';
import SportsView from '../views/SportsView.vue';
import ArtsyView from '../views/ArtsyView.vue';
import MusicView from '../views/MusicView.vue';
import SearchResults from '../views/SearchResults.vue';
const routes = [
  {
    path: '/authorizedHome',
    name: 'authorizedHome',
    component: AuthorizedHomeView,
    meta: {
      requiresAuth: true,
    },
  },
  {
    path: '/',
    name: 'home',
    component: HomeView,
    meta: {
      requiresAuth: false,
    },
  },
  {
    path: '/login',
    name: 'login',
    component: LoginView,
    meta: {
      requiresAuth: false,
    },
  },
  {
    path: '/logout',
    name: 'logout',
    component: LogoutView,
    meta: { requiresAuth: false },
  },
  {
    path: '/register',
    name: 'register',
    component: RegisterView,
    meta: { requiresAuth: false },
  },
  {
    path: '/locations',
    name: 'locations',
    component: LocationsView,
    meta: { requiresAuth: true },
  },
  {
    path: '/locations/:locationId',
    name: 'individual-location',
    component: IndividualQuestView,
    meta: {
      requiresAuth: true,
    },
    props: true
  },
  {
    path: '/user/:userId?',
    name: 'user',
    component: UserView,
    meta: {
      requiresAuth: true,
    },
    props: true
  },
  {
    path: '/rankings',
    name: 'rankings',
    component: RankingsView,
    meta: { requiresAuth: true },
  },
  {
    path: '/sports',
    name: 'sports',
    component: SportsView,
    meta: { requiresAuth: true },
  },
  {
    path: '/art',
    name: 'art',
    component: ArtsyView,
    meta: { requiresAuth: true },
  },
  {
    path: '/music',
    name: 'music',
    component: MusicView,
    meta: { requiresAuth: true },
  },
  {
    path: '/search',
    name: 'searchResults',
    component: SearchResults,
    meta: { requiresAuth: false },
  },
  {
    path: "/quest",
    name: "quest",
    component: QuestView,
    meta: {
      requiresAuth: true,
    },
  },
  {
    path: '/quests/:id',
    name: 'individual-quest',
    component: IndividualQuestView,
    meta: {
      requiresAuth: true,
    },
    props: true
  },
  {
    path: '/:catchAll(.*)', // Catch-all route using dynamic segment with regex
    redirect: '/'
  }
];
// Create the router
const router = createRouter({
  history: createWebHistory(),
  routes: routes
});
router.beforeEach((to, from, next) => {
  const store = useStore();
  const requiresAuth = to.matched.some(record => record.meta.requiresAuth);
  if (requiresAuth && !store.state.token) {
    return next({ name: 'login' });
  }
  next();
});
export default router;