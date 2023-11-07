<template>
	<div>
		<div>FavoriteView</div>
		<div class="container">
			<div v-for="product in store.favoriteList" class="product">
				<p class="name">{{ product.name }}</p>
				<p>{{ product.price }}</p>
				<img :src="product.img">
			</div>
		</div>
		
	</div>
</template>

<script setup>
import {ref} from 'vue';
import { useProductStore } from '@/stores/product';

const store = useProductStore();


</script>

<style scoped>
.product {
	background-color: #222;
	width : 200px;
	margin : 20px;
	text-align: center;
	border-radius: 10%;
	color: #eee;
}

.product img {
	border-radius: 10%;
	width : 10em;
	height: 8em;
	margin : 20px;
}

.container{
	display : flex;
	flex-wrap:wrap;
}

.name {
	font-size: 1.5rem;
	font-weight: bold;
	font-family:'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
}
</style>