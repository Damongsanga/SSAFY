import { ref, computed, watch } from 'vue'
import { defineStore } from 'pinia'

export const useProductStore = defineStore('product', () => {

  const productList = ref([
    {
      name : "까녜",
      price : "10000",
      img : 'src/assets/kanye.jpg',
      isFavorite : false,
    }, 
    {
      name : "오쎤",
      price : "8000",
      img : 'src/assets/ocean.jpg',
      isFavorite : false,
    }, 
    {
      name : "따일러",
      price : "5000",
      img : 'src/assets/tyler.jpg',
      isFavorite : false,
    }, 
    {
      name : "때니얼",
      price : "3000",
      img : 'src/assets/daniel.jpg',
      isFavorite : false,
    }, 
  ]);

  const favoriteList = ref([]);

  const likeit = (productIdx) => {
    productList.value[productIdx].isFavorite = !productList.value[productIdx].isFavorite; 
    favoriteList.value = productList.value.filter((product) => {
      return product.isFavorite;
    })
  }

  return { productList, likeit, favoriteList }
}, {persist:true})
