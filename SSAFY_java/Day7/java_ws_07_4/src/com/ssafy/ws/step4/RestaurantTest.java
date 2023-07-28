package com.ssafy.ws.step4;

public class RestaurantTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IRestaurantManager rm = RestaurantManagerImpl.getinstacne();
		IReviewManager rvm = ReviewManagerImpl.getinstance();
		rm.addRestaurant(new Restaurant(101,"쉑쉑버거","서울","햄버거",9));
		rm.addRestaurant(new KoreanRestaurant(103, "을밀대", "서울", "물냉면", 8, "02-711-1922", "15:00 ~ 17:00"));
		rm.addRestaurant(new KoreanRestaurant(105, "보승회관", "전국", "순대국", 7, "02-711-1932", "No"));
		rvm.addReview(new Review(1, 101, "덕주", "햄버거는 못참지"));
		rvm.addReview(new Review(2, 101, "동규", "햄버거는 진짜루 못참지"));
		rvm.addReview(new Review(3, 103, "수현", "물냉면 개존맛"));
		rvm.addReview(new Review(4, 103, "동재", "물냉면 존맛"));
		rvm.addReview(new Review(5, 105, "나영", "해장엔 순대국이 최고"));
		String input;
		Review[] reviews;
		int resid;
		
		
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
		
		System.out.println("****************쉑쉑버거 리뷰 보기******************");
		input = "쉑쉑버거";
		reviews = rvm.getReviewList();
		resid = 0;
		for (Restaurant r : rm.getNonKoreanRestaurants()) {
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
		
		System.out.println("****************울밀대 리뷰 보기******************");
		input = "을밀대";
		reviews = rvm.getReviewList();
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
		
		System.out.println("****************보승회관 리뷰 보기******************");
		input = "보승회관";
		reviews = rvm.getReviewList();
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
		
	}

}
