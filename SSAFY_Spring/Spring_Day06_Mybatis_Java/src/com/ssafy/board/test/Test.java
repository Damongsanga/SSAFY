package com.ssafy.board.test;

import java.sql.SQLException;

import com.ssafy.board.config.MyAppSqlConfig;
import com.ssafy.board.model.dao.BoardDao;
import com.ssafy.board.model.dto.Board;

public class Test {
	public static void main(String[] args) throws SQLException {
		BoardDao dao = MyAppSqlConfig.getSession().getMapper(BoardDao.class);
		
//		Board board = new Board("자기주도형 학습", "ㄴㄴ", "EZ");
//		dao.insertBoard(board);
		
//		dao.deleteBoard(4);
		
//		dao.updateViewCnt(1);
		
		Board board = dao.selectOne(5);
		board.setTitle("자기주고형 하아아악습");
		board.setContent("SOO EZ");
		dao.updateBoard(board);
		
		for(Board b : dao.selectAll()) {
			System.out.println(b);
		}
//		
//		System.out.println(dao.selectOne(1));
		
	}
}
