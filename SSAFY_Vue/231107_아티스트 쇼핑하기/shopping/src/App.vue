<script setup>
import { RouterLink, RouterView } from 'vue-router'
</script>

<template>
  <div>
    <nav>
      <RouterLink to="/">Home</RouterLink> | 
      <RouterLink to="/product">Product</RouterLink> | 
      <RouterLink to="/favorite">Favorite</RouterLink>
    </nav>
  </div>
  <RouterView />
</template>

<style scoped>
</style>
