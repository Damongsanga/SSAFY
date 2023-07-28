package com.ssafy.ws.step4;

public class ReviewNotFoundException extends Exception{

	public ReviewNotFoundException() {
		super("댓글이 없습니다.");
	}
	
	public ReviewNotFoundException(int reviewId) {
		super(reviewId + "에 해당하는 댓글이 없습니다.");
	}
}
