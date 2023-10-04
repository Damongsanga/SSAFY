package com.ssafy.fit.model.service;

import java.util.List;

import com.ssafy.fit.model.dto.Video;

public interface VideoService {
	
	List<Video> getList();
	
	Video getVideo(int id);
	
	List<Video> chooseList(String fitPartName);
	
}
