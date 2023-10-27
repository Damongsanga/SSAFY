package com.ssafy.board.model.dao;


import java.sql.SQLException;
import java.util.List;

import com.ssafy.board.model.dto.Board;

public interface BoardDao {

	public List<Board> selectAll();

	public Board selectOne(int id);

	public void insertBoard(Board board);

	public void deleteBoard(int id);

	public void updateBoard(Board board);

	public void updateViewCnt(int id) throws SQLException;

}
