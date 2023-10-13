package com.ssafy.fit.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.fit.model.dto.Review;
import com.ssafy.fit.model.util.DBUtil;

public class ReviewDaoImpl implements ReviewDao {

	private DBUtil util = DBUtil.getInstance();

	private static ReviewDao instance = new ReviewDaoImpl();

	private ReviewDaoImpl() {
	}

	public static ReviewDao getInstance() {
		return instance;
	}

	@Override
	public List<Review> selectAll() {
		List<Review> list = new ArrayList<>();

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		// 2. 데이터베이스 연결
		try {
			conn = util.getConnection();

			// 3. SQL 준비 및 실행
			stmt = conn.createStatement();
			// SQL (전체 게시글 가져와)
			String sql = "SELECT * FROM review";
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Review review = new Review();
				review.setReviewId(rs.getInt("review_id"));
				review.setVideoId(rs.getInt("video_id"));
				review.setWriter(rs.getString("writer"));
				review.setContent(rs.getString("content"));
				list.add(review);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.close(conn, stmt, rs);
		}

		return list;
	}

	@Override
	public void insertReview(Review review) {
		// PreparedStatement
		String sql = "INSERT INTO review (writer, content, video_id) VALUES (?,?,?)";

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = util.getConnection();

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, review.getWriter()); // pstmt의 1번째 구멍!!!
			pstmt.setString(2, review.getContent());
			pstmt.setInt(3, review.getVideoId());
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
//					conn.rollback(); 문제 생기면 롤백하는 식으로도 할 수 있음! 
		} finally {
			util.close(conn, pstmt);
		}
	}

	@Override
	public void updateReview(Review review) {
		String sql = "UPDATE review SET writer = ?, content = ? WHERE review_id = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, review.getWriter());
			pstmt.setString(2, review.getContent());
			pstmt.setInt(3, review.getReviewId());
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.close(conn, pstmt);
		}
	}

	@Override
	public void deleteReview(int reviewId, String userId) {
		String sql = "DELETE FROM review WHERE review_id = ? AND writer = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, reviewId);
			pstmt.setString(2, userId);
			pstmt.executeUpdate(); // 이거해야돼!!

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.close(conn, pstmt);
		}
	}

	@Override
	public Review selectOne(int reviewId) {
		String sql = "SELECT * FROM review WHERE review_id = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		Review review = null;

		try {

			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, reviewId);

			rs = pstmt.executeQuery();

			while (rs.next()) { // 1개 밖에 안가져올꺼임 !
				review = new Review();
				review.setReviewId(rs.getInt("review_id"));
				review.setVideoId(rs.getInt("video_id"));
				review.setWriter(rs.getString("writer"));
				review.setContent(rs.getString("content"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.close(conn, pstmt, rs);
		}

		return review;
	}

	@Override
	public List<Review> selectSelected(int videoId) {
		List<Review> list = new ArrayList<>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM review WHERE video_id = ?";
		// 2. 데이터베이스 연결
		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, videoId);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Review review = new Review();
				review.setReviewId(rs.getInt("review_id"));
				review.setVideoId(rs.getInt("video_id"));
				review.setWriter(rs.getString("writer"));
				review.setContent(rs.getString("content"));
				list.add(review);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.close(conn, pstmt, rs);
		}

		return list;
	}

}
