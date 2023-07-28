package com.ssafy.ws.step5;

/**
 * 해당 게시글이 존재하지 않는 경우
 */
public class ArticleIdDuplicateException extends Exception{
	public ArticleIdDuplicateException() {
		super("게시글을 등록할 수 없습니다.");
	}

}
