import { ref, watch } from 'vue'
import { defineStore } from 'pinia'

export const useProductStore = defineStore('product', () => {
  const productList = ref([
    {
      name: '케로피',
      imagePath: 'src/assets/product1.png',
      price: 10000,
      isFavorite: false,
    },
    {
      name: '포차코',
      imagePath: 'src/assets/product2.png',
      price: 20000,
      isFavorite: false,
    },
    {
      name: '시나모롤',
      imagePath: 'src/assets/product3.png',
      price: 30000,
      isFavorite: false,
    },
    {
      name: '쿠로미',
      imagePath: 'src/assets/product4.png',
      price: 40000,
      isFavorite: false,
    },
  ]);

  const favoriteList = ref([]);

  const likeit = (productIdx) => {
    productList.value[productIdx].isFavorite = !productList.value[productIdx].isFavorite;
    favoriteList.value = productList.value.filter((product) => {
      return product.isFavorite;
    });
  }

  return { productList, likeit, favoriteList};
});
