package com.ssafy.board.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.board.model.dao.BoardDao;
import com.ssafy.board.model.dto.Board;

//Component 보다 더 직접적인 annotation
@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardDao boardDao;

	@Override
	public List<Board> getList() {
		System.out.println("모든 게시글을 가지고 왔습니다.");
		return boardDao.selectAll();
	}

	@Override
	public void writeBoard(Board board) {
		System.out.println("게시글을 등록했습니다.");
		boardDao.insertBoard(board);
	}

	@Override
	public Board getBoard(int id) {
		System.out.println(id+"번 글을 읽었습니다");
		boardDao.updateViewCnt(id);
		return boardDao.selectOne(id);
		
	}

	@Override
	public void modifyBoard(Board board) {
		System.out.println("글을 수정했습니다.");
		boardDao.updateBoard(board);
		
	}

	@Override
	public void removeBoard(int id) {
		System.out.println(id+"번 글을 읽었습니다");
		boardDao.deleteBoard(id);
		
	}

}
