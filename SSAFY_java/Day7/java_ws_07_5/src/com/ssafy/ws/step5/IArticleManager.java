package com.ssafy.ws.step5;

/**
 * 게시글, 댓글 리스트를 관리하기 위한 클래스를 위한 명세역할의 인터페이스
 */
public interface IArticleManager {
	// 코드를 작성해주세요.
	Article[] getArticleList();

	Article getArticle(int articleId);

	void addArticle(Article article);

	void removeArticle(int articleId);

	void updateArticle(Article article);

	Article[] getTextArticleList();

	ImageArticle[] getImageArticleList();

	double getImageSizeAvg();
	
	Article[] search(int option, String keyword);
	
	void addComment(Comment comment);
	
	void removeComment(int commentId);
	
	Comment[] getCommentList(int articleId);
}
