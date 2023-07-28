package com.ssafy.ws.step5;

import java.util.List;

/**
 * 게시글, 댓글 리스트를 관리하기 위한 클래스를 위한 명세역할의 인터페이스
 */
public interface IArticleManager {
	// 코드를 작성해주세요.
	List<Article> getArticleList();

	Article getArticle(int articleId) throws ArticleNotFoundException;

	void addArticle(Article article) throws ArticleIdDuplicateException;

	void removeArticle(int articleId) throws ArticleNotFoundException;

	void updateArticle(Article article);

	List<Article> getTextArticleList();

	List<ImageArticle> getImageArticleList();

	double getImageSizeAvg();
	
	List<Article> search(int option, String keyword);
	
	void addComment(Comment comment);
	
	void removeComment(int articleId, int commentId) throws CommentNotFoundException;
	
	List<Comment> getCommentList(int articleId);
}
