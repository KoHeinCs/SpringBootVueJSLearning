<template>
  <di class="container">
    <nav-bar></nav-bar>
    <router-view/>
    <FooterPage></FooterPage>

  </di>

</template>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}



</style>
<script>
import NavBar from "@/core/components/NavBar";
import FooterPage from "@/core/components/Footer";

export default {
  components: {FooterPage, NavBar}
}
</script>