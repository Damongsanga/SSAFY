package com.ssafy.ws.step4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestaurantManagerImpl implements IRestaurantManager {
	private int MAX_RESTAURANT_SIZE = 1000;
	private List<Restaurant> restaurants = new ArrayList<>();
	private Map<Integer, IReviewManager> rvm = new HashMap<>();
	private static IRestaurantManager rm = new RestaurantManagerImpl();
	
	private RestaurantManagerImpl() {
		
	}
	
	public static IRestaurantManager getinstacne() {
		return rm;
	}
	
	public List<Restaurant> getRestaurantList() {
		if (restaurants.size() == 0) return null;
		return restaurants;
	}
	
	
	public List<KoreanRestaurant> getKoreanRestaurants() {
		List<KoreanRestaurant> arrayList = new ArrayList<>();
		for (int i = 0; i < restaurants.size(); i++) {
			if(restaurants.get(i) instanceof KoreanRestaurant)
			arrayList.add((KoreanRestaurant) restaurants.get(i));
		}
		if (arrayList.size() == 0) return null;
		return arrayList;
	}
	
	public List<Restaurant> getNonKoreanRestaurants() {
		List<Restaurant> arrayList = new ArrayList<>();
		for (int i = 0; i < restaurants.size(); i++) {
			if(restaurants.get(i) instanceof KoreanRestaurant) continue;
			arrayList.add(restaurants.get(i));
		}
		
		if (arrayList.size() == 0) return null;
		return arrayList;
	}
	
	public Restaurant searchByresid(int resid) throws RestaurantNotFoundException {
		for (int i = 0; i < restaurants.size(); i++) {
			if (restaurants.get(i).getResid() == resid)
				return restaurants.get(i);
		}
		throw new RestaurantNotFoundException(resid);
	}
	
	
	public void addRestaurant(Restaurant restaurant) {
		if (restaurants.size() < MAX_RESTAURANT_SIZE) {
			restaurants.add(restaurant);
			rvm.put(restaurant.getResid(), new ReviewManagerImpl());
		}
		
		else System.out.println("더이상 추가할 수 없습니다.");
	}
	

	public void removeRestaurant(int resid) {
		if (restaurants.size() == 0) {
			System.out.println("등록된 Restaurant가 없습니다.");
			return;
		}
		
		for (int i = 0; i < restaurants.size(); i++) {
			if(restaurants.get(i).getResid() != resid) {
				rvm.remove(restaurants.get(i).getResid());
				restaurants.remove(i);
				System.out.println("삭제되었습니다.");
				return;
			}
		}	
		System.out.println("해당 resid를 가진 Restaurant가 없습니다.");
	}
	
	public IReviewManager getReviewManager(int resid) {
		return rvm.get(resid);
	}
	
	




}
