package com.ssafy.ws.step5;

/**
 * 해당 ID 혹은 PW가 틀려 로그인이 실패한 경우
 */
public class LoginException extends Exception{
	public LoginException() {
		super("ID 혹은 PW가 틀렸습니다.");
	}
}
