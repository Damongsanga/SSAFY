package com.ssafy.fit.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.fit.model.dto.Review;
import com.ssafy.fit.model.dto.Video;
import com.ssafy.fit.model.util.DBUtil;

public class VideoDaoImpl implements VideoDao {

	private DBUtil util = DBUtil.getInstance();
	private static VideoDao instance = new VideoDaoImpl();

	private VideoDaoImpl() {
	}
	
	public static VideoDao getInstance() {
		return instance;
	}

	@Override
	public List<Video> selectAll() {
		List<Video> list = new ArrayList<>();

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		// 2. 데이터베이스 연결
		try {
			conn = util.getConnection();

			// 3. SQL 준비 및 실행
			stmt = conn.createStatement();
			// SQL (전체 게시글 가져와)
			String sql = "SELECT * FROM video";
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Video video = new Video();
				video.setId(rs.getInt("id"));
				video.setTitle(rs.getString("title"));
				video.setFitPartName(rs.getString("fit_part_name"));
				video.setYoutubeId(rs.getString("youtube_id"));
				video.setChannelName(rs.getString("channel_name"));
				video.setViewCnt(rs.getInt("view_cnt"));
				list.add(video);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.close(conn, stmt, rs);
		}

		return list;
	}

	@Override
	public Video selectOne(int id) {
		String sql = "SELECT * FROM video WHERE id = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		Video video = null;

		try {

			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);

			rs = pstmt.executeQuery();
			
			while (rs.next()) { // 1개 밖에 안가져올꺼임 !
				video = new Video();
				video.setId(rs.getInt("id"));
				video.setTitle(rs.getString("title"));
				video.setFitPartName(rs.getString("fit_part_name"));
				video.setYoutubeId(rs.getString("youtube_id"));
				video.setChannelName(rs.getString("channel_name"));
				video.setViewCnt(rs.getInt("view_cnt"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.close(conn, pstmt, rs);
		}

		return video;
	}

	public List<Video> selcetList(String fitPartName) {
		List<Video> list = new ArrayList<>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM video WHERE fit_part_name = ?";
		
		System.out.println(fitPartName);
		
		// 2. 데이터베이스 연결
		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, fitPartName);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Video video = new Video();
				video.setId(rs.getInt("id"));
				video.setTitle(rs.getString("title"));
				video.setFitPartName(rs.getString("fit_part_name"));
				video.setYoutubeId(rs.getString("youtube_id"));
				video.setChannelName(rs.getString("channel_name"));
				video.setViewCnt(rs.getInt("view_cnt"));
				list.add(video);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.close(conn, pstmt, rs);
		}

		return list;
	}

	@Override
	public void updateViewCnt(int id) {
		String sql = "UPDATE video SET view_cnt = view_cnt + 1 WHERE id = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.close(conn, pstmt);
		}
	}
}
