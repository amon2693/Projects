import { createStore as _createStore } from 'vuex';
import axios from 'axios';
import GeoService from '../services/GeoService.js';
import searchService from '../services/SearchService';

export function createStore(currentToken, currentUser) {
  let store = _createStore({
    state: {
      token: currentToken || '',
      user: currentUser || {},
      userLocation: null,
      searchResults: []
    },
    mutations: {
      SET_AUTH_TOKEN(state, token) {
        state.token = token;
        localStorage.setItem('token', token);
        axios.defaults.headers.common['Authorization'] = `Bearer ${token}`;
      },
      SET_USER(state, user) {
        state.user = user;
        localStorage.setItem('user', JSON.stringify(user));
      },
      LOGOUT(state) {
        localStorage.removeItem('token');
        localStorage.removeItem('user');
        state.token = '';
        state.user = {};
        axios.defaults.headers.common = {};
      },
      SET_USER_LOCATION(state, location) {
        state.userLocation = location;
      },
      SET_SEARCH_RESULTS(state, results) {
        state.searchResults = results;
      },
    },
    getters: {
      searchResults(state) {
        return state.searchResults;
      },
    },
    actions: {
      async fetchUserLocation({ commit }) {
        try {
          const location = await GeoService.getUserLocation();
          commit('SET_USER_LOCATION', location);
        } catch (error) {
          console.error('Error fetching user location:', error);
        }
      },
      async search({ commit }, { query, table }) {
        try {
          const results = await searchService({ query, table });
          commit('SET_SEARCH_RESULTS', results);
        } catch (error) {
          console.error('Error performing search:', error);
        }
      }
    },
    actions: {
      async fetchUserData({ commit }) {
        try {
          const response = await axios.get('/api/user/me');
          commit('SET_USER', response.data);
        } catch (error) {
          console.error('Failed to fetch user data:', error);
        }
      },
      async login({ commit }, credentials) {
        try {
          const response = await axios.post('/api/auth/login', credentials);
          const { token, user } = response.data;
          commit('SET_AUTH_TOKEN', token);
          commit('SET_USER', user);
        } catch (error) {
          console.error('Login failed:', error);
        }
      },
      async logout({ commit }) {
        try {
          await axios.post('/api/auth/logout');
          commit('LOGOUT');
        } catch (error) {
          console.error('Logout failed:', error);
        }
      }
    },
    getters: {
      isAuthenticated(state) {
        return !!state.token;
      },
      currentUser(state) {
        return state.user;
      }
    }
  });

  return store;
}