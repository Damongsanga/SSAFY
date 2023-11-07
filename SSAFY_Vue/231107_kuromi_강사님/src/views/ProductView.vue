<script setup>
import { useProductStore } from '@/stores/product';
import ProductDetail from '@/components/ProductDetail.vue';
const store = useProductStore();

</script>

<template>
  <h1>ProductView입니다</h1>
  <div class="productList">
  <ProductDetail v-for="(product, index) in store.productList" :key="index" :index="index" :product="product"></ProductDetail>
</div>
</template>

<style scoped> 
.productList {
  display: flex;
  flex-wrap: wrap;
}
</style>
