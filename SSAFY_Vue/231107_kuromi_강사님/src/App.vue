<script setup>
</script>

<template>
  <div class="wrapper">
    <nav>
      <RouterLink to="/">Home</RouterLink> |
      <RouterLink to="/product">Product</RouterLink> | 
      <RouterLink to="/favorite">Favorite</RouterLink>
    </nav>
  </div>
  <RouterView />
</template>

<style>
@import url("https://fonts.googleapis.com/css2?family=Gowun+Dodum&display=swap");

* {
  font-family: "Gowun Dodum", sans-serif;
}

.wrapper {
  display: flex;
  justify-content: center;
}

h1 {
  text-align: center;
}
</style>
