<template>
  <div class="profile-picture">
    <h3>Profile Picture</h3>
    <div class="profile-picture-container">
      <img :src="profilePictureUrl" alt="Profile Picture" v-if="profilePictureUrl" />
      <p v-else>No profile picture uploaded.</p>
    </div>
    <input type="file" @change="onFileChange" />
    <button @click="uploadPicture" :disabled="!selectedFile">Upload</button>
  </div>
</template>

<script>
import UserService from '../services/UserService.js';
export default {
  props: {
    initialProfilePictureUrl: {
      type: String,
      default: '',
    },
  },
  data() {
    return {
      profilePictureUrl: this.initialProfilePictureUrl,
      selectedFile: null,
    };
  },
  methods: {
    onFileChange(event) {
      this.selectedFile = event.target.files[0];
    },
    async uploadPicture() {
      if (!this.selectedFile) return;

      const formData = new FormData();
      formData.append('file', this.selectedFile);

      try {
        // Emit the file back to the parent for handling the upload
        this.$emit('update-picture', this.selectedFile);

        // Optionally, handle the upload directly in this component
        // const response = await axios.post('/api/users/profile-picture', formData);
        // this.profilePictureUrl = response.data.profilePictureUrl;
      } catch (error) {
        console.error('Error uploading profile picture:', error);
      }
    },
  },
};
</script>

<style scoped>
.profile-picture {
  display: flex;
  flex-direction: column;
  align-items: center;
  margin-top: 20px;
}

.profile-picture-container {
  width: 150px;
  height: 150px;
  border-radius: 50%;
  overflow: hidden;
  margin-bottom: 15px;
}

.profile-picture-container img {
  width: 100%;
  height: 100%;
  object-fit: cover;
}

input[type="file"] {
  margin-bottom: 10px;
}

button {
  padding: 5px 10px;
  cursor: pointer;
}
</style>

  