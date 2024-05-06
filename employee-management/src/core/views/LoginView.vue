<template>
  <div>
    <form @submit.prevent="login">
      <input type="text" v-model="user.username" placeholder="Username"/>
      <input type="password" v-model="user.password" placeholder="Password"/>
      <button type="submit">Login</button>
    </form>
  </div>
</template>

<script setup lang="ts">
import authService from "@/core/services/AuthService";
import {useRouter} from "vue-router";

const router = useRouter();
const user = {username: "", password: ""}
const login = () => {
  authService.login(user).then((resp) => {
    if (resp && resp.httpStatusCode === 200) {
      const token = resp.data;
      window.localStorage.clear();
      window.localStorage.setItem("jwtToken", token);
      router.push({name: "home"})
    }
  })
}

</script>

<style scoped>
div {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  height: 100vh;
}

input {
  padding: 10px;
  margin-bottom: 10px;
  border-radius: 5px;
  border: none;
  box-shadow: 0px 0px 5px 0px rgba(0, 0, 0, 0.2);
}

button {
  padding: 10px;
  background-color: #2196f3;
  color: white;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  transition: all 0.3s ease;
}

button:hover {
  background-color: #0d8bf2;
}
</style>