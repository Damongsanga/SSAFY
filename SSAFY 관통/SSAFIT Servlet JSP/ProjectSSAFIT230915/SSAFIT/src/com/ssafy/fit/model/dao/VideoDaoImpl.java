package com.ssafy.fit.model.dao;

import java.util.ArrayList;
import java.util.List;

import com.ssafy.fit.model.dto.Video;

public class VideoDaoImpl implements VideoDao {

	private static VideoDao dao = new VideoDaoImpl();

	// 데이터베이스 대신
	private List<Video> list = new ArrayList<>();
	private List<Video> selectedList = new ArrayList<>();

	private VideoDaoImpl() {
		list.add(new Video("1234", "싸피", "어깨 조지기", "어깨"));
		list.add(new Video("33", "싸피2", "어깨 조지기2", "어깨"));
		list.add(new Video("44", "싸피3", "하체 조지기", "하체"));
		list.add(new Video("55", "싸피4", "하체 조지기2", "하체"));
		list.add(new Video("66", "싸피5", "가슴 조지기", "가슴"));
	}
	
	public static VideoDao getInstance() {
		return dao;
	}

	@Override
	public List<Video> selectAll() {
		return list;
	}

	@Override
	public Video selectOne(int id) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId() == id) {
				return list.get(i);
			}
		}
		return null;
	}

	public List<Video> selcetList(String fitPartName) {
		
		selectedList = new ArrayList<>();
		
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getFitPartName().equals(fitPartName)) {
				selectedList.add(list.get(i));
			}
		}
		return selectedList;
	}

	@Override
	public void updateViewCnt(int id) {
		for (int i = 0; i < list.size(); i++) {
			Video v = list.get(i);
			if (v.getId() == id) {
				int viewCnt = v.getViewCnt();
				v.setViewCnt(viewCnt + 1);
			}
		}
	}
}
