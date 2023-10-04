package com.ssafy.fit.model.dao;

import java.util.ArrayList;
import java.util.List;

import com.ssafy.fit.model.dto.Review;
import com.ssafy.fit.model.dto.Video;

public class ReviewDaoImpl implements ReviewDao {

	private static ReviewDao dao = new ReviewDaoImpl();

	private ReviewDaoImpl() {
	}

	public static ReviewDao getInstance() {
		return dao;
	}

	private List<Review> list = new ArrayList<>();
	private List<Review> selectedList = new ArrayList<>();

	@Override
	public List<Review> selectAll() {
		return list;
	}

	@Override
	public void insertReview(Review review) {
		list.add(review);
	}

	@Override
	public void updateReview(int reviewId, String userId, String content) {
		System.out.println("수정전");
		for (int i = 0; i < list.size(); i++) {
			Review r = list.get(i);
			if (r.getWriter().equals(userId) && r.getReviewId() == reviewId) {
				System.out.println("수정완료");
				r.setContent(content);
				return;
			}
		}
	}

	@Override
	public void deleteReview(int reviewId, String userId) {
		for (int i = 0; i < list.size(); i++) {
			Review r = list.get(i);
			if (r.getWriter().equals(userId) && reviewId == r.getReviewId()) {
				list.remove(i);
				return;
			}
		}
	}

	@Override
	public Review selectOne(int reviewId) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getReviewId() == reviewId) {
				return list.get(i);
			}
		}
		return null;

	}

	@Override
	public List<Review> selectSelected(int videoId) {
		selectedList = new ArrayList<>();

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getVideoId() == videoId) {
				selectedList.add(list.get(i));
			}
		}
		return selectedList;
	}

}
