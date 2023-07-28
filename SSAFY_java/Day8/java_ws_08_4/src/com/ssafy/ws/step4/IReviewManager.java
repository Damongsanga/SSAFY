package com.ssafy.ws.step4;

import java.util.List;

public interface IReviewManager {
	void addReview(Review review);
	
	void removeReview(int reviewid);
	
	List<Review> getReviewList();
	
	Review searchByReviewid (int reviewid);
	
	List<Review> getRestaurantReview (int resid);

}
