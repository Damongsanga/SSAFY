package com.ssafy.fit.model.service;

import java.util.List;

import com.ssafy.fit.model.dto.Review;

public interface ReviewService {

	// 게시글 전체 조회
	List<Review> getList();

	List<Review> getSelectedList(int videoId);

	// 게시글 등록
	void writeReview(Review review);

	// 게시글 수정
	void modifyReview(Review review);

	// 게시글 삭제
	void removeReview(int reviewId, String userId);

	Review getReview(int reviewId);

}
