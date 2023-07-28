package com.ssafy.ws.step5;

/**
 * 해당 게시글이 존재하지 않는 경우
 */
public class ArticleNotFoundException extends Exception{
	public ArticleNotFoundException(int articleId) {
		super(articleId + "해당 게시글은 존재하지 않습니다.");
	}

}
