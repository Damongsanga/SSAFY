package com.ssafy.ws.step4;

import java.util.ArrayList;

public class RestaurantManagerImpl implements IRestaurantManager {
	private int MAX_RESTAURANT_SIZE = 1000;
	private Restaurant[] restaurants = new Restaurant[MAX_RESTAURANT_SIZE];
	private int restaurantSize = 0;

	private static IRestaurantManager rm = new RestaurantManagerImpl();
	
	private RestaurantManagerImpl() {
		// TODO Auto-generated constructor stub
	}
	
	public static IRestaurantManager getinstacne() {
		return rm;
	}
	
	public Restaurant[] getRestaurantList() {
		Restaurant[] returnlist = new Restaurant[restaurantSize];
		for (int i = 0; i < returnlist.length; i++) {
			returnlist[i] = restaurants[i];
		}
		return returnlist;
	}
	
	
	public KoreanRestaurant[] getKoreanRestaurants() {
		ArrayList<Restaurant> arrayList = new ArrayList<>();
		for (int i = 0; i < restaurantSize; i++) {
			if(restaurants[i] instanceof KoreanRestaurant)
			arrayList.add(restaurants[i]);
		}
		KoreanRestaurant[] returnlist = new KoreanRestaurant[arrayList.size()];
		for (int i = 0; i < returnlist.length; i++) {
			returnlist[i] = (KoreanRestaurant) arrayList.get(i);
		}
		return returnlist;
	}
	
	public Restaurant[] getNonKoreanRestaurants() {
		ArrayList<Restaurant> arrayList = new ArrayList<>();
		for (int i = 0; i < restaurantSize; i++) {
			if(restaurants[i] instanceof KoreanRestaurant) continue;
			arrayList.add(restaurants[i]);
		}
		Restaurant[] returnlist = new Restaurant[arrayList.size()];
		for (int i = 0; i < returnlist.length; i++) {
			returnlist[i] = arrayList.get(i);
		}
		return returnlist;
	}
	
	public Restaurant searchByresid(int resid) {
		for (int i = 0; i < restaurantSize; i++) {
			if (restaurants[i].getResid() == resid)
				return restaurants[i];
		}
		return null;
	}
	
	
	public void addRestaurant(Restaurant restaurant) {
		restaurants[restaurantSize++] = restaurant;
	}
	

	public void removeRestaurant(int resid) {
		int idx = 0;
		for (int i = 0; i < restaurantSize; i++) {
			if(restaurants[i].getResid() != resid) {
				restaurants[idx++] = restaurants[i];
			}
		}
		restaurants[restaurantSize--] = null;		
	}


}
