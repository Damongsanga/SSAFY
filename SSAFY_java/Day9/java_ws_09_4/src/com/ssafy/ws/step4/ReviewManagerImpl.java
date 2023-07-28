package com.ssafy.ws.step4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReviewManagerImpl implements IReviewManager{
	private int MAX_REVIEW_SIZE = 1000;
	private List<Review> reviews = new ArrayList<>();
	
	public ReviewManagerImpl() {
		
	}
	
	public void addReview(Review review) {
		if (reviews.size() < MAX_REVIEW_SIZE)
			reviews.add(review);
		else System.out.println("더이상 추가할 수 없습니다.");
	}
	
	public void removeReview(int reviewId) {
		if (reviews.size() == 0) return;
		for (int i = 0; i < reviews.size(); i++) {
			if(reviews.get(i).getReviewId() != reviewId) {
				reviews.remove(i);
			}
		}	
	}
	
	public List<Review> getReviewList() {
		List<Review> arrayList = new ArrayList<>();
		for (int i = 0; i < reviews.size(); i++) {
			arrayList.add(reviews.get(i));
		}
		if (arrayList.size() == 0) return null;
		return arrayList;
	}
	

	public Review searchByReviewid(int reviewId) throws ReviewNotFoundException{
		for (int i = 0; i < reviews.size(); i++) {
			if (reviews.get(i).getReviewId() == reviewId)
				return reviews.get(i);
		}
		throw new ReviewNotFoundException();
	}
	
	
	@Override
	public List<Review> getRestaurantReview(int resid) {
		List<Review> arrayList = new ArrayList<>();
		for (Review review : getReviewList()) {
			if (review.getResId() == resid) arrayList.add(review);
		}
		if (arrayList.size() == 0) return null;
		return arrayList;
	}

}
