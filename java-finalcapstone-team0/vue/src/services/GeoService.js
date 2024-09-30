export default {
    getUserLocation() {
      return new Promise((resolve, reject) => {
        if ("geolocation" in navigator) {
          navigator.geolocation.getCurrentPosition(
            (position) => {
              const { latitude, longitude } = position.coords;
              resolve({ latitude, longitude });
            },
            (error) => {
              reject(new Error("Error getting location: " + error.message));
            }
          );
        } else {
          reject(new Error("Geolocation is not supported by this browser."));
        }
      });
    }
  };