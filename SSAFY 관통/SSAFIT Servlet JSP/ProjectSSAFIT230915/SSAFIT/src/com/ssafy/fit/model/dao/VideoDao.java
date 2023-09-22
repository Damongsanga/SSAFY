package com.ssafy.fit.model.dao;

import java.util.List;

import com.ssafy.fit.model.dto.Video;

public interface VideoDao {
	
	List<Video> selectAll();
	
	Video selectOne(int id);
	
	List<Video> selcetList(String fitPartName);
	
	void updateViewCnt(int id);
	
}
