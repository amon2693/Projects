<template>
  <div class="home">
    <div class="navigation">
      <router-link :to="{ name: 'login' }" aria-label="Login">Login</router-link>
      <router-link :to="{ name: 'register' }" aria-label="Sign Up">Sign Up</router-link>
    </div>
    <div v-if="isLoading" class="loading">
      <img src="../assets/walk.gif" alt="Loading animation" />
    </div>
    <div v-else class="main-content">
      <img src="../assets/logo.png" alt="Logo" class="logo" />
      <h1 class="main-heading">WalkCLE</h1>
      <p>
        The ultimate guide to exploring Cleveland! Whether you're a visitor or a local, our app helps you discover the best that our region has to offer. Browse nearby attractions, explore curated Quests, and check in at various locations to earn exclusive badges. Register now to enhance your adventure and see Cleveland like never before!
      </p>
      <div class="image-gallery">
        <ClevelandPics />
      </div>
    </div>
  </div>
</template>

<script>
import ClevelandPics from '../components/ClevelandPics.vue';

export default {
  components: {
    ClevelandPics
  },
  data() {
    return {
      isLoading: true
    };
  },
  mounted() {
    setTimeout(() => {
      this.isLoading = false;
    }, 2000);
  }
}
</script>

<style scoped>
.home {
  display: flex;
  flex-direction: column;
  height: 100vh;
  padding: 0 20px;
  background:
    /* Background image */
    url(C:\Users\Student\workspace\java-finalcapstone-team0\vue\src\assets\cle.jpg) no-repeat center center fixed,
    /* Gradient overlay */
    linear-gradient(135deg, #1E3A8A, #3B82F6);
  background-size: cover; /* Ensure the background image covers the entire element */
}

.navigation {
  padding: 10px;
  border-radius: 8px;
  width: 40vh;
}

.navigation a {
  color: #FFFFFF;
  text-decoration: none;
  padding: 10px;
  margin-right: 15px;
  font-weight: bold;
}

.navigation a:hover {
  background-color: #0056B3;
  border-radius: 5px;
}

.main-content {
  flex: 1;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: flex-start;
  margin-top: 20px;
  text-align: center;
  position: relative; /* Allows for absolute positioning of child elements */
}

.main-heading {
  font-size: 8rem;
  -webkit-text-fill-color: darkorange;
  margin: 0;
  border: 0.2rem solid #fff;
  border-radius: 2rem;
  padding: 0.4em;
  box-shadow: 0 0 0.2rem #fff,
              0 0 0.2rem #fff,
              0 0 2rem #2E33BC,
              0 0 0.8rem #2E33BC,
              0 0 2.8rem #2E33BC,
              inset 0 0 1.3rem #2E33BC;
}

.main-content p {
  font-family: 'Merriweather', serif; /* Apply elegant font */
  font-size: 1.25rem; /* Adjust size as needed */
  line-height: 1.6; /* Improve readability */
  color: #FFFFFF; /* Change text color to white */
  max-width: 800px; /* Limit width for better readability */
  margin: 20px 0; /* Add margin for spacing */
  padding: 20px; /* Add padding for better spacing inside the box */
  background-color: rgba(53, 53, 156, 0.6); /* Blue with 60% opacity */
  border-radius: 10px; /* Rounded corners */
}

.intro-picture {
  width: 100%; /* Adjust width as needed */
  max-width: 800px; /* Limit width */
  border-radius: 10px; /* Rounded corners */
  margin-bottom: 20px; /* Add margin for spacing */
}

.image-gallery {
  display: flex;
  flex-wrap: wrap;
  gap: 18px;
  justify-content: center;
}

.image-gallery img {
  border-radius: 10px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
  transition: transform 0.3s ease-in-out;
}

.image-gallery img:hover {
  transform: scale(1.10);
}

.loading img {
  width: 100px;
  height: auto;
}

.logo {
  position: absolute;
  top: 10px;
  left: 10px;
  width: 150px; /* Adjust size as needed */
  height: 150px;
}
</style>