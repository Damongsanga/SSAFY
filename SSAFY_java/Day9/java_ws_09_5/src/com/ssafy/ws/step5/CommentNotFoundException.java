package com.ssafy.ws.step5;

/**
 * 해당 게시글의 댓글이 존재하지 않는 경우
 */
public class CommentNotFoundException extends Exception {
	public CommentNotFoundException() {
		super("삭제하려고 하는 댓글이 존재하지 않습니다.");
	}

}
