<template>
  <div id="login">
    <div class="form-container">
      <div class="navigation">
      <router-link :to="{ name: 'home' }">Home</router-link>
    </div>
      <form v-on:submit.prevent="login">
        <h1>Please Sign In</h1>
        <div role="alert" v-if="invalidCredentials">
          Invalid username and password!
        </div>
        <div role="alert" v-if="showRegistrationMessage">
          Thank you for registering, please sign in.
        </div>
        <div class="form-input-group">
          <label for="username">Username</label>
          <input type="text" id="username" v-model="user.username" required autofocus />
        </div>
        <div class="form-input-group">
          <label for="password">Password</label>
          <input type="password" id="password" v-model="user.password" required />
        </div>
        <button type="submit">Sign in</button>
        <p>
          <router-link v-bind:to="{ name: 'register' }">Need an account? Sign up.</router-link>
        </p>
      </form>
    </div>
  </div>
</template>
<script>
import authService from "../services/AuthService";
export default {
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: ""
      },
      invalidCredentials: false
    };
  },
  computed: {
    showRegistrationMessage() {
      return !!this.$route.query.registration;
    }
  },
  methods: {
    async login() {
      try {
        const response = await authService.login(this.user);
        if (response.status === 200) {
          this.$store.commit("SET_AUTH_TOKEN", response.data.token);
          this.$store.commit("SET_USER", response.data.user);
          this.$router.push("/authorizedHome");
        }
      } catch (error) {
        const response = error.response;
        if (response.status === 401) {
          this.invalidCredentials = true;
        } else {
          console.error('An unexpected error occurred:', error);
          this.invalidCredentials = false;
        }
      }
    }
  }
};
</script>
<style scoped>
html, body {
  height: 100%;
  margin: 0;
  font-family: Arial, sans-serif;
}
#login {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
  margin: 0;
  padding: 0;
  background: url('C:\Users\Student\workspace\java-finalcapstone-team0\vue\src\assets\East4th.jpg') no-repeat center center fixed;
  background-size: cover;
}
.form-container {
  max-width: 400px;
  width: 100%;
  padding: 2rem;
  background: rgba(5, 0, 5, 0.9); /* Semi-transparent background for the form */
  border-radius: 8px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}
h1 {
  text-align: center;
  margin-bottom: 1.5rem;
  font-size: 1.5rem;
  color: white;
}
form {
  display: flex;
  flex-direction: column;
}
.form-input-group {
  margin-bottom: 1.5rem;
}
input[type="text"],
input[type="password"] {
  width: 100%;
  padding: 0.75rem;
  border: 1px solid #ccc;
  border-radius: 4px;
  font-size: 1rem;
  color: white; /* Change text color to white */
  background-color: #333; /* Optional: Change background color to dark for contrast */
}

label {
  display: block;
  margin-bottom: 0.5rem;
  font-weight: bold;
  color: white;
}
input[type="text"],
input[type="password"] {
  width: 100%;
  padding: 0.75rem;
  border: 1px solid #ccc;
  border-radius: 4px;
  font-size: 1rem;
}
input[type="text"]:focus,
input[type="password"]:focus {
  border-color: #007BFF;
  outline: none;
}
button {
  background-color: #220929;
  color: white;
  border: none;
  padding: 0.75rem;
  border-radius: 4px;
  cursor: pointer;
  font-size: 1rem;
}
button:hover {
  background-color: black;
}
button:focus {
  outline: none;
}
p {
  text-align: center;
  margin-top: 1rem;
}
a {
  color: #FEFCFE;
  text-decoration: none;
}
a:hover {
  text-decoration: underline;
}
div[role="alert"] {
  padding: 1rem;
  margin-bottom: 1.5rem;
  border-radius: 4px;
  color: #D9534F;
  background-color: #F2DEDE;
  border: 1px solid #D9534F;
}
.navigation {
  display: flex;
  flex-direction:column;
  text-align: center;
  height: 6vh;
  width: 10vh;
  padding: 0px;
  background-color: #220929; /* Light background for a modern look */
}
.navigation:hover {
  background-color: black;
}
</style>







