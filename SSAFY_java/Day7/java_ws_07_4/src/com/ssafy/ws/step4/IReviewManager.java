package com.ssafy.ws.step4;

public interface IReviewManager {
	void addReview(Review review);
	
	void removeReview(int reviewid);
	
	Review[] getReviewList();
	
	Review searchByReviewid (int reviewid);
	
	Review[] getRestaurantReview (int resid);

}
