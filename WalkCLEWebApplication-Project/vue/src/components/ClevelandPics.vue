<template>
  <div class="image-container">
    <div class="image-gallery">
      <img 
        v-for="(image, index) in allImages" 
        :key="index" 
        :src="image" 
        alt="Cleveland Gallery" 
      />
    </div>
  </div>
</template>

<script>
import clevelandSkyline from '@/assets/blob.jpg';
import progressiveField from '@/assets/progressiveField.jpg';
import RockHall from '@/assets/RockHall.jpg';
import ArtMuseum from '@/assets/ArtMuseum.jpg';

export default {
  props: {
    submittedImages: {
      type: Array,
      default: () => []
    }
  },
  data() {
    return {
      imageUrls: [
        clevelandSkyline,
        progressiveField,
        RockHall,
        ArtMuseum
      ]
    };
  },
  computed: {
    allImages() {
      return [...this.imageUrls, ...this.submittedImages];
    }
  }
};
</script>

<style>
.image-container {
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
  width: 100%;
}
.image-gallery {
  display: flex;
  flex-wrap: wrap;
  gap: 10px;
  width: 100%;
  justify-content: center;
}

.image-gallery img {
  flex: 1 1 auto;
  max-width: 100%;
  max-height: 200px;
  object-fit: cover;
}
</style>