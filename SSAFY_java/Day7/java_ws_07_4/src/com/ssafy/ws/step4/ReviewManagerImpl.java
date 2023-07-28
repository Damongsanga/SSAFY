package com.ssafy.ws.step4;

import java.util.ArrayList;
import java.util.Arrays;

public class ReviewManagerImpl implements IReviewManager{
	private int MAX_REVIEW_SIZE = 1000;
	private Review[] reviews = new Review[MAX_REVIEW_SIZE];
	private int reviewsSize = 0;
	private static IReviewManager rm = new ReviewManagerImpl();
	
	private ReviewManagerImpl() {
		
	}
	
	public static IReviewManager getinstance() {
		return rm;
	}
	
	public void addReview(Review review) {
		reviews[reviewsSize++] = review;
	}
	
	public void removeReview(int reviewId) {
		int idx = 0;
		for (int i = 0; i < reviewsSize; i++) {
			if(reviews[i].getReviewId() != reviewId) {
				reviews[idx++] = reviews[i];
			}
		}
		reviews[reviewsSize--] = null;		
	}
	
	public Review[] getReviewList() {
		Review[] returnlist = new Review[reviewsSize];
		for (int i = 0; i < returnlist.length; i++) {
			returnlist[i] = reviews[i];
		}
		return returnlist;
	}
	

	public Review searchByReviewid(int reviewId) {
		for (int i = 0; i < reviewsSize; i++) {
			if (reviews[i].getReviewId() == reviewId)
				return reviews[i];
		}
		return null;
	}
	
	
	@Override
	public Review[] getRestaurantReview(int resid) {
		Review[] returnlist = new Review[reviewsSize];
		int count = 0;
		for (Review review : getReviewList()) {
			if (review.getResId() == resid) returnlist[count++] = review;
		}
			
		return Arrays.copyOf(returnlist, count);
	}

}
