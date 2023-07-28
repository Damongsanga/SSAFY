package com.ssafy.ws.step5;

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;

public class ArticleManagerImpl implements IArticleManager {
	private final int MAX_ARTICLE_SIZE = 1000;
	private Article[] articles = new Article[MAX_ARTICLE_SIZE];
	private int articleSize = 0;
	private final int MAX_COMMENT_SIZE = 1000;
	private Comment[] comments = new Comment[MAX_COMMENT_SIZE];
	private int commentSize = 0;
	private static IArticleManager am = new ArticleManagerImpl();

	private ArticleManagerImpl() {
	}

	public static IArticleManager getinstance() {
		return am;
	}

	public Article[] getArticleList() {
		if (articleSize == 0)
			return null;
		ArrayList<Article> artList = new ArrayList<>();
		for (int i = 0; i < articleSize; i++) {
			artList.add(articles[i]);
		}
		Object[] list = artList.toArray();
		Article[] returnlist = new Article[list.length];
		for (int i = 0; i < list.length; i++) {
			returnlist[i] = (Article) list[i];
		}

		return returnlist;
	}

	public Article getArticle(int articleId) {
		for (int i = 0; i < articleSize; i++) {
			if (articles[i].getArticleId() == articleId)
				return articles[i];
		}
		return null;
	}

	public void addArticle(Article article) {
		articles[articleSize++] = article;
	}

	// 로그인 될 때
	public void removeArticle(int articleId) {
		IUserManager um = UserManagerImpl.getinstance();
		if (um.getLoginUser().getUserSeq() != am.getArticle(articleId).getUserSeq()) {
			System.out.println("권한이 없습니다.");
			return;
		}
		boolean check = false;
		for (int i = 0; i < articleSize; i++) {
			if (articles[i].getArticleId() == articleId) {
				check = true;
				// 댓글 삭제
				for (int j = 0; j < commentSize; j++) {
					if (articleId == comments[j].getArticleId()) {
						removeComment(comments[j].getCommentId());
					}
				}
				System.out.println(am.getArticle(articleId).getTitle() + " 게시물이 삭제되었습니다.");
			} else if (check) {
				articles[i - 1] = articles[i];
			}
		}
		if (articleSize > 0)
			articles[--articleSize] = null;

	}

	public void updateArticle(Article article) {
		for (int i = 0; i < articleSize; i++) {
			if (articles[i].getArticleId() == article.getArticleId()) {
				articles[i].setContent(article.getContent());
				System.out.println(article.getContent() + " 내용으로 수정했어요");
				break;
			}
		}
		System.out.println("해당 게시물이 없어서 수정을 할 수 없어요");
	}

	public Article[] getTextArticleList() {
		if (articleSize == 0)
			return null;

		ArrayList<Article> arrayList = new ArrayList<>();
		for (int i = 0; i < articleSize; i++) {
			if (articles[i] instanceof ImageArticle)
				continue;
			arrayList.add(articles[i]);
		}
		Article[] returnList = new Article[arrayList.size()];
		for (int i = 0; i < returnList.length; i++) {
			returnList[i] = arrayList.get(i);
		}
		return returnList;
	}

	public ImageArticle[] getImageArticleList() {
		if (articleSize == 0)
			return null;

		ArrayList<Article> arrayList = new ArrayList<>();
		for (int i = 0; i < articleSize; i++) {
			if (articles[i] instanceof ImageArticle)
				continue;
			arrayList.add(articles[i]);
		}
		ImageArticle[] returnList = new ImageArticle[arrayList.size()];
		for (int i = 0; i < returnList.length; i++) {
			returnList[i] = (ImageArticle) arrayList.get(i);
		}
		return returnList;
	}

	public double getImageSizeAvg() {
		int sum = 0;
		int count = 0;
		for (int i = 0; i < articleSize; i++) {
			if (articles[i] instanceof ImageArticle) {
				ImageArticle aa = (ImageArticle) articles[i];
				sum += aa.getHeight() * aa.getWidth();
				count++;
			}
		}
		return count == 0 ? 0 : sum / count;
	}

	public void addComment(Comment comment) {
		comments[commentSize++] = comment;
	}

	// 배열 형변환 밀려서 삭제하는걸로 구현 완료
	public void removeComment(int commentId) {
		IUserManager um = UserManagerImpl.getinstance();
		boolean check = false;
		for (int i = 0; i < commentSize; i++) {
			if (um.getLoginUser().getUserSeq() == comments[i].getUserSeq()) {
				if (check || commentId == comments[i].getCommentId()) {
					check = true;
					System.out.println(comments[i].getContent() + " 내용의 댓글이 삭제되었습니다.");
					comments[i] = comments[i + 1];
				}
			}
		}
		if (check)
			comments[--commentSize] = null;
		else
			System.out.println("권한이 없습니다.");
	}

	public Comment[] getCommentList(int articleId) {
		if (commentSize == 0)
			return null;
		ArrayList<Comment> comList = new ArrayList<>();
		for (int i = 0; i < commentSize; i++) {
			if (articleId == comments[i].getArticleId()) {
				comList.add(comments[i]);
			}
		}
		Object[] list = comList.toArray();
		Comment[] returnlist = new Comment[list.length];
		for (int i = 0; i < list.length; i++) {
			returnlist[i] = (Comment) list[i];
		}

		return returnlist;
	}

	@Override
	public Article[] search(int option, String keyword) {
		IUserManager um = UserManagerImpl.getinstance();
		Article[] get_articleList = am.getArticleList();
		Article[] returnarr = new Article[articleSize];
		int idx = 0;

		if (get_articleList == null) return null;
		
		for (Article article : get_articleList) {
			switch (option) {
			case (1):
				if (article.getTitle().contains(keyword))
					returnarr[idx++] = article;
				break;
			case (2):
				if (article.getContent().contains(keyword))
						returnarr[idx++] = article;
				break;
			case (3):
				User userByUserSeq = um.getUser(keyword);
				if (userByUserSeq == null) return null;
				if (article.getUserSeq() == userByUserSeq.getUserSeq())
					returnarr[idx++] = article;
			}
		}

		return idx == 0? null : Arrays.copyOf(returnarr, idx);
	}

}
