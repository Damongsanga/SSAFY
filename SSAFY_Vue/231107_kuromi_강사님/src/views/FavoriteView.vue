<script setup>
import { useProductStore } from '@/stores/product';
import FavoriteDetail from '@/components/FavoriteDetail.vue';
const store = useProductStore();

</script>

<template>
  <h1>FavoriteView입니다</h1>
  <div class="productList">
  <FavoriteDetail v-for="(product, index) in store.favoriteList" :key="index" :index="index" :product="product"></FavoriteDetail>
</div>
</template>

<style scoped> 
.productList {
  display: flex;
  flex-wrap: wrap;
}
</style>
