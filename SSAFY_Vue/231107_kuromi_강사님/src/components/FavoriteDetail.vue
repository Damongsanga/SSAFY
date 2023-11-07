<script setup>
import { useProductStore } from '@/stores/product';

const props = defineProps({
    index: Number,
    product: Object,
});

const store = useProductStore();
</script>

<template>
    <div class="detail">
        <h1>{{ product.name }}</h1>
        <div class="productImage">
        <img :src="product.imagePath">
        </div>
        <div>
            <span></span>
        </div>
    </div>
</template>

<style scoped>
.detail {
    width: 300px;
    height: 300px;
    margin: 50px;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: space-between;
    border: 1px solid #eee;
    border-radius: 15px;
    box-shadow: 0 1px 3px rgba(0,0,0,0.12), 0 1px 2px rgba(0,0,0,0.24);
  transition: all 0.3s cubic-bezier(.25,.8,.25,1);
}
.detail:hover {
  box-shadow: 0 14px 28px rgba(0,0,0,0.25), 0 10px 10px rgba(0,0,0,0.22);
}

.detail *{
    margin: 10px;
}

.detail span {
    font-size: 30px;
}
.productImage img{
    /* width: 100px; */
    height: 100px;
}
</style>