package com.ssafy.ws.step4;

public class RestaurantNotFoundException extends Exception{
	
	public RestaurantNotFoundException() {
		super("맛집 정보가 없습니다.");
	}
	
	public RestaurantNotFoundException(int resId) {
		super(resId + "에 해당하는 맛집이 없습니다.");
	}

}
