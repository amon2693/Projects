<template>
  <div class="authorizedHome">
    <!-- Navigation Links -->
    <div class="navigation">
      <router-link v-bind:to="{ name: 'locations' }">Location Details</router-link>
      <router-link v-bind:to="{ name: 'quest' }">Quests</router-link>
    </div>

    
    <div v-if="isLoading" class="loading">
      <img src="@/assets/walk.gif" alt="Loading animation" />
    </div>
    

    <div v-else class="main-content">
      <img src="../assets/logo.png" alt="Logo" class="logo" />
      <h1 class="main-heading">WalkCLE</h1>
      <p>
        The ultimate guide to exploring Cleveland! Whether you're a visitor or a local, our app helps you discover the best that our region has to offer. Browse nearby attractions, explore curated Quests, and check in at various locations to earn exclusive badges. Start your adventure today and see Cleveland like never before!
      </p>

      <form @submit.prevent="submitPhoto" class="photo-form">
        <label for="photoUpload">Submit a photo of your adventure:</label>
        <input type="file" id="photoUpload" @change="handleFileChange" accept="image/*" />
        <button type="submit">Submit</button>
      </form>

      <!-- Image Gallery -->
      <div class="image-gallery">
        <ClevelandPics :submittedImages="submittedImages" />
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
      isLoading: true,
      submittedImages: [], // Store the submitted images
      selectedFile: null,  // Store the selected file
    };
  },
  computed: {
    currentUser() {
      return this.$store.state.user;
    }
  },
  methods: {
    loadContent() {
      this.isLoading = true;
      setTimeout(() => {
        this.isLoading = false;
      }, 2000);
    },
    handleFileChange(event) {
      this.selectedFile = event.target.files[0]; // Get the selected file
    },
    submitPhoto() {
      if (this.selectedFile) {
        const reader = new FileReader();
        reader.onload = (e) => {
          this.submittedImages.push(e.target.result); // Add the image to the gallery
        };
        reader.readAsDataURL(this.selectedFile); // Convert the image to a base64 string
      }
    }
  },
  created() {
    this.loadContent();
  }
}
</script>

<style scoped>
.authorizedHome {
  display: flex;
  flex-direction: column;
  height: 100vh;
  padding: 0 20px;
  background: 
    url('@/assets/cle.jpg') no-repeat center center fixed, 
    linear-gradient(135deg, #1e3a8a, #3b82f6);
  background-size: cover;
  overflow-y: auto;
}

.navigation {
  font-size: 0.9rem;
  padding: 10px;
  border-radius: 8px;
  width: 100%;
  display: flex;
  justify-content: center;
  flex-wrap: wrap;
}

.navigation a {
  color: #ffffff;
  text-decoration: none;
  padding: 10px;
  margin: 5px;
  font-weight: bold;
}

.navigation a:hover {
  background-color: #0056b3;
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
  font-size: 6rem;
  -webkit-text-fill-color: darkorange;
  margin: 0;
  border: 0.2rem solid #fff;
  border-radius: 2rem;
  padding: 0.4em;
  box-shadow: 0 0 0.2rem #fff,
              0 0 0.2rem #fff,
              0 0 2rem #2e33bc,
              0 0 0.8rem #2e33bc,
              0 0 2.8rem #2e33bc,
              inset 0 0 1.3rem #2e33bc; 
}

.main-content p {
  font-family: 'Merriweather', serif;
  font-size: 1.25rem;
  line-height: 1.6;
  color: #ffffff;
  max-width: 800px;
  margin: 20px 0;
  padding: 20px;
  background-color: rgba(53, 53, 156, 0.6);
  border-radius: 10px;
}

/* Added Styles for Photo Submission Form */
.photo-form {
  margin: 20px 0;
  padding: 20px;
  background-color: rgba(53, 53, 156, 0.6);
  border-radius: 10px;
  color: #ffffff;
  display: flex;
  flex-direction: column;
  align-items: center;
}

.photo-form label {
  font-size: 1.2rem;
  margin-bottom: 10px;
}

.photo-form input[type="file"] {
  margin-bottom: 10px;
}

.photo-form button {
  background-color: darkorange;
  color: #fff;
  border: none;
  padding: 10px 20px;
  cursor: pointer;
  font-size: 1rem;
  border-radius: 5px;
  transition: background-color 0.3s ease;
}

.photo-form button:hover {
  background-color: #ff7f50;
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

@keyframes pulsate {
  100% {
    text-shadow:
      0 0 4px #fff,
      0 0 11px #fff,
      0 0 19px #fff,
      0 0 40px #2e33bc,
      0 0 80px #2e33bc,
      0 0 90px #2e33bc,
      0 0 100px #2e33bc,
      0 0 150px #2e33bc;
  }
  
  0% {
    text-shadow:
      0 0 2px #fff,
      0 0 4px #fff,
      0 0 6px #fff,
      0 0 10px #2e33bc,
      0 0 45px #2e33bc,
      0 0 55px #2e33bc,
      0 0 70px #2e33bc,
      0 0 80px #2e33bc;
  }
}

@media (max-width: 768px) {
  .navigation {
    width: 100%;
    flex-direction: column;
  }

  .main-heading {
    font-size: 4rem;
  }

  .main-content p {
    font-size: 1rem;
  }
}

.logo {
  position: absolute;
  top: 10px;
  left: 10px;
  width: 150px; /* Adjust size as needed */
  height: 150;
}
</style>