package com.ssafy.ws.step5;

/**
 * 사용자리스트를 관리하기 위한 클래스를 위한 명세역할의 인터페이스
 */
public interface IUserManager {
	//코드를 작성해주세요. 
	User getLoginUser();
	void signup(User user);
	User login(String id, String password);
	void logout();
	User getUser(int userSeq);
	User getUser(String nickname);
}
