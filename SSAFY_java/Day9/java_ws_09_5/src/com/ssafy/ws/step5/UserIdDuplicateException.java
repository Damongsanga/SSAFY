package com.ssafy.ws.step5;

/**
 * 해당 ID를 가진 유저가 이미 존재한 경우
 */
public class UserIdDuplicateException extends Exception {
	public UserIdDuplicateException(String userId) {
		super(userId + "는 이미 존재하는 ID 입니다.");
	}

}
