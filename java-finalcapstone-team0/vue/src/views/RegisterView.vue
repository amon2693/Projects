<template>
  <div id="register" class="text-center">
    <div class="form-container">
    <div class="navigation">
      <router-link :to="{ name: 'home' }">Home</router-link>
    </div>
    <form v-on:submit.prevent="register">
      <h1>Create Account</h1>
      <div role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
      </div>
      <div class="form-input-group">
        <label for="username">Username</label>
        <input type="text" id="username" v-model="user.username" required autofocus />
      </div>
      <div class="form-input-group">
        <label for="password">Password</label>
        <input type="password" id="password" v-model="user.password" required />
      </div>
      <div class="form-input-group">
        <label for="confirmPassword">Confirm Password</label>
        <input type="password" id="confirmPassword" v-model="user.confirmPassword" required />
      </div>
      <button type="submit">Create Account</button>
      <p><router-link v-bind:to="{ name: 'login' }">Already have an account? Log in.</router-link></p>
    </form>
  </div>
</div>
</template>

<script>
import authService from '../services/AuthService';

export default {
  data() {
    return {
      user: {
        username: '',
        password: '',
        confirmPassword: '',
        role: 'user',
      },
      registrationErrors: false,
      registrationErrorMsg: 'There were problems registering this user.',
    };
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = 'Password & Confirm Password do not match.';
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: '/login',
                query: { registration: 'success' },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = 'Bad Request: Validation Errors';
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = 'There were problems registering this user.';
    },
  },
};
</script>

<style scoped>
html, body {
  height: 100%;
  margin: 0;
  font-family: Arial, sans-serif;
}

#register {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
  margin: 0;
  padding: 0;
  background: url('@/assets/East4thDay.jpg') no-repeat center center fixed;
  background-size: cover;
}

.form-container {
  max-width: 400px;
  width: 100%;
  padding: 2rem;
  background: rgba(6, 33, 241, 0.9);
  border-radius: 8px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

h1 {
  text-align: center;
  margin-bottom: 1.5rem;
  font-size: 1.5rem;
  color: #f8990a;
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
  color: black;
  background-color: white;
}

label {
  display: block;
  margin-bottom: 0.5rem;
  font-weight: bold;
  color: #f8990a;
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
  border-color: #020407;
  outline: none;
}

button {
  background-color: #f8990a;
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
  color: #fefcfe;
  text-decoration: none;
}

a:hover {
  text-decoration: underline;
}

div[role="alert"] {
  padding: 1rem;
  margin-bottom: 1.5rem;
  border-radius: 4px;
  color: #d9534f;
  background-color: #f2dede;
  border: 1px solid #d9534f;
}

.navigation {
  display: flex;
  flex-direction:column;
  
  text-align: center;
  height: 5vh; 
  width: 8vh;
  padding: 0px;
}

.navigation:hover {
  background-color: black;
  
}
</style>
