package com.ssafy.fit.model.dto;

public class User {
	private static int no = 0;
	private int userNum;
	private String userId;
	private String pwd;
	
	public User() {
	}

	public User(String id, String pwd) {
		super();
		this.userNum = no++;
		this.userId = id;
		this.pwd = pwd;
	}

	public int getUserNum() {
		return userNum;
	}

	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String id) {
		this.userId = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Override
	public String toString() {
		return "User [userNum=" + userNum + ", userId=" + userId + ", pwd=" + pwd + "]";
	}
	
}
