package com.ssafy.fit.model.dao;

import java.util.List;

import com.ssafy.fit.model.dto.Review;

public interface ReviewDao {
	// 게시글 전체 조회
		List<Review> selectAll();
		
		List<Review> selectSelected(int videoId);

		// 게시글 등록
		void insertReview(Review review);

		// 게시글 수정
		void updateReview(int reviewId, String userId, String content);

		// 게시글 삭제
		void deleteReview(int reviewId, String userId);
		
		Review selectOne(int reviewId);
}
