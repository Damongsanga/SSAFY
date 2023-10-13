package com.ssafy.fit.model.service;

import java.util.List;

import com.ssafy.fit.model.dao.ReviewDao;
import com.ssafy.fit.model.dao.ReviewDaoImpl;
import com.ssafy.fit.model.dto.Review;

public class ReviewServiceImpl implements ReviewService {

	private static ReviewService service = new ReviewServiceImpl();
	
	private ReviewServiceImpl() {
	}
	
	public static ReviewService getInstance() {
		return service;
	}
	
	ReviewDao dao = ReviewDaoImpl.getInstance();
	
	@Override
	public List<Review> getList() {
		return dao.selectAll();
	}

	@Override
	public void writeReview(Review review) {
		dao.insertReview(review);
	}

	@Override
	public void modifyReview(Review review) {
		dao.updateReview(review);
	}

	@Override
	public void removeReview(int reviewId, String userId) {
		dao.deleteReview(reviewId, userId);
	}

	@Override
	public Review getReview(int reviewId) {
		return dao.selectOne(reviewId);
	}

	@Override
	public List<Review> getSelectedList(int videoId) {
		return dao.selectSelected(videoId);
	}

}
