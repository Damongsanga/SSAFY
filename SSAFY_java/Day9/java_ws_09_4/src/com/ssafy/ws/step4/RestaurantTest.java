package com.ssafy.ws.step4;

import java.util.Collections;
import java.util.List;

public class RestaurantTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IRestaurantManager rm = RestaurantManagerImpl.getinstacne();
		rm.addRestaurant(new Restaurant(101,"쉑쉑버거","서울","햄버거",9));
		rm.addRestaurant(new KoreanRestaurant(103, "을밀대", "서울", "물냉면", 8, "02-711-1922", "15:00 ~ 17:00"));
		rm.addRestaurant(new KoreanRestaurant(105, "보승회관", "전국", "순대국", 7, "02-711-1932", "No"));
		rm.addRestaurant(new KoreanRestaurant(107, "투썸플레이스", "전국", "아이스박스", 7, "02-721-1932", "No"));
		rm.getReviewManager(101).addReview(new Review(1, 101, "덕주", "햄버거는 못참지"));
		rm.getReviewManager(101).addReview(new Review(2, 101, "동규", "햄버거는 진짜루 못참지"));
		rm.getReviewManager(103).addReview(new Review(3, 103, "수현", "물냉면 개존맛"));
		rm.getReviewManager(103).addReview(new Review(4, 103, "동재", "물냉면 존맛"));
		rm.getReviewManager(105).addReview(new Review(5, 105, "나영", "해장엔 순대국이 최고"));
		String input;
		List<Review> reviews;
		int resid;
		
		System.out.println("****************전체 맛집 목록******************");
		for (Restaurant r : rm.getRestaurantList()) {
			System.out.println(r);
		}
		System.out.println();
		
		System.out.println("****************한식 맛집 목록******************");
		for (KoreanRestaurant r : rm.getKoreanRestaurants()) {
			System.out.println(r);
		}
		System.out.println();
		
		System.out.println("****************브레이크 타임이 있는 목록******************");
		for (KoreanRestaurant r : rm.getKoreanRestaurants()) {
			if (!r.getBreaktime().equals("No")) System.out.println(r);
		}
		System.out.println();
		
		System.out.println("****************일반 맛집 목록******************");
		for (Restaurant r : rm.getNonKoreanRestaurants()) {
			System.out.println(r);
		}
		System.out.println();
		
//		for (Restaurant restaurant : rm.getRestaurantList()) {
//			try{
//				System.out.printf("****************%s 리뷰 보기******************%n", restaurant.getName());
//				
//				for (Review review : rm.getReviewManager(restaurant.getResid()).searchByReviewid(restaurant.getResid())) {
//					System.out.println(review);
//				}
//			} catch (RestaurantNotFoundException e1){
//				e1.printStackTrace();
//			} catch (ReviewNotFoundException e2) {
//				e2.printStackTrace();
//			} finally {
//				System.out.println();
//			}
//		}
		
		
		System.out.println("****************쉑쉑버거 리뷰 보기******************");
		input = "쉑쉑버거";
		reviews = rm.getReviewManager(101).getReviewList();
		resid = 0;
		for (Restaurant r : rm.getNonKoreanRestaurants()) {
			if (r.getName().equals(input)) {
				resid = r.getResid();
				try {
					System.out.println(rm.searchByresid(resid));
				} catch (RestaurantNotFoundException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
				break;
			}
		}
		for (Review review : reviews) {
			if (review.getResId() == resid) {
				System.out.println(review);
			}
		}
		System.out.println();
		
		System.out.println("****************울밀대 리뷰 보기******************");
		input = "을밀대";
		reviews = rm.getReviewManager(103).getReviewList();
		resid = 0;
		for (Restaurant r : rm.getKoreanRestaurants()) {
			if (r.getName().equals(input)) {
				resid = r.getResid();
				break;
			}
		}
		for (Review review : reviews) {
			if (review.getResId() == resid) {
				System.out.println(review);
			}
		}
		System.out.println();
		
		System.out.println("****************보승회관 리뷰 보기******************");
		input = "보승회관";
		reviews = rm.getReviewManager(105).getReviewList();
		resid = 0;
		for (Restaurant r : rm.getKoreanRestaurants()) {
			if (r.getName().equals(input)) {
				resid = r.getResid();
				break;
			}
		}
		for (Review review : reviews) {
			if (review.getResId() == resid) {
				System.out.println(review);
			}
		}
		System.out.println();
		
		try {
			System.out.println(rm.searchByresid(110));
		} catch (RestaurantNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		
		try {
			System.out.println(rm.getReviewManager(107).searchByReviewid(9));
		} catch (ReviewNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println();
		
	}

}
