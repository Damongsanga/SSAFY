package com.ssafy.ws.step4;

/**
 * 맛집리스트를 관리하기 위한 클래스를 위한 명세역할의 인터페이스
 */
public interface IRestaurantManager {
	void addRestaurant(Restaurant restaurant);
	
	void removeRestaurant(int resid);
	
	Restaurant[] getRestaurantList();
	
	Restaurant searchByresid(int resid);
	
	KoreanRestaurant[] getKoreanRestaurants();
	
	Restaurant[] getNonKoreanRestaurants();
	
	//코드를 작성해주세요. 
}
