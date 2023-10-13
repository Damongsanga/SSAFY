package com.ssafy.fit.model.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.ssafy.fit.model.dao.VideoDao;
import com.ssafy.fit.model.dao.VideoDaoImpl;
import com.ssafy.fit.model.dto.Video;

public class VideoServiceImpl implements VideoService{

	private static VideoService service = new VideoServiceImpl();
	
	public VideoDao dao = VideoDaoImpl.getInstance();
	
	
	private VideoServiceImpl() {
	}
	
	public static VideoService getInstance() {
		return service;
	}

	@Override
	public List<Video> getList() {
		
		List<Video> list = dao.selectAll();
		
		Collections.sort(list, new Comparator<Video>() {

			@Override
			public int compare(Video o1, Video o2) {
				return o2.getViewCnt() - o1.getViewCnt();
			}
		});
		
		return list;
	}

	@Override
	public Video getVideo(int id) {
		dao.updateViewCnt(id);
		return dao.selectOne(id);
	}

	@Override
	public List<Video> chooseList(String fitPartName) {
		return dao.selcetList(fitPartName);
	}
	

}
