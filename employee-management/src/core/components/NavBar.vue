<template>
<!--  <nav class="navbar">-->
<!--    <div class="navbar-left">-->
<!--      <img src="#" alt="Logo" class="navbar-logo" />-->
<!--    </div>-->
<!--    <div class="navbar-right">-->
<!--      <router-link to="/">Home</router-link>-->
<!--      <router-link to="/about" class="navbar-link">About</router-link>-->
<!--      <router-link to="/add/employee" class="navbar-link">Add Employee</router-link>-->
<!--      <router-link to="/login" class="navbar-link">Login</router-link>-->
<!--    </div>-->
<!--  </nav>-->

  <a-layout-header class="header">
    <div class="logo" />
    <a-menu
        theme="dark"
        mode="horizontal"
        :style="{ lineHeight: '64px' }"
    >
      <a-menu-item key="Home">
        <router-link to="/home">Home</router-link>
      </a-menu-item>
      <a-menu-item key="About">
        <router-link to="/about">About</router-link>
      </a-menu-item>
      <a-menu-item key="Add">
        <router-link to="/add/employee" class="navbar-link">Add Employee</router-link>
      </a-menu-item>
      <a-menu-item key="Login">
        <router-link to="/login" class="navbar-link">Login</router-link>
      </a-menu-item>
    </a-menu>
  </a-layout-header>


</template>

<script setup lang="ts">


</script>



<style scoped>

.navbar {
  background: linear-gradient(to right, #ff8c00, #ff5f6d);
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 10px 20px;
  box-shadow: 0px 2px 4px rgba(0, 0, 0, 0.25);
}

.navbar-logo {
  height: 50px;
}

.navbar-link {
  color: #fff;
  text-decoration: none;
  margin-left: 20px;
  font-size: 18px;
}

.navbar-link:hover {
  text-decoration: underline;
}

</style>