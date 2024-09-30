<template>
  <div class="loading" v-if="isLoading">
    <h1>Loading...</h1>
    <img src="../assets/ping_pong_loader.gif" />
  </div>
  <div v-else>
    <h1> {{ card.title }}</h1>
    <card-detail v-bind:card="card" />
  </div>
</template>

<script>
import CardDetail from '../components/CardDetail.vue';
import BoardService from '../services/BoardService';

export default {
  components: {
    CardDetail
  },

  data() {
    return {
      isLoading: true,
      card: {}
    }
  },
  methods: {
    getCardInformation() {
      BoardService.getCard(this.$route.params.cardId).then(response =>{
        this.card = response.data;
        this.isLoading = false;
      })
    }
  },
  created() {
    this.getCardInformation();
  }
};
</script>
