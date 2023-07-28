package com.ssafy.ws.step5;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

public class ArticleManagerImpl implements IArticleManager {
	private List<Article> articles = new ArrayList<>();
	private Map<Integer, List<Comment>> comments = new HashMap<>();
	private static IArticleManager am = new ArticleManagerImpl();

	private ArticleManagerImpl() {
	}

	public static IArticleManager getinstance() {
		return am;
	}

	public List<Article> getArticleList() {
		if (articles.size() == 0)
			return null;
		List<Article> arrayList = new ArrayList<>();
		for (int i = 0; i < articles.size(); i++) {
			arrayList.add(articles.get(i));
		}

		return arrayList;
	}

	public Article getArticle(int articleId) throws ArticleNotFoundException {
		if (articles.size() == 0)
			throw new ArticleNotFoundException(articleId);
		for (int i = 0; i < articles.size(); i++) {
			if (articles.get(i).getArticleId() == articleId)
				return articles.get(i);
		}
		throw new ArticleNotFoundException(articleId);
	}

	public void addArticle(Article article) throws ArticleIdDuplicateException{
		if (!articles.contains(article)) {
		articles.add(article);
		comments.put(article.getArticleId(), new ArrayList<Comment>());
		} else {
			throw new ArticleIdDuplicateException();
		}
	}

	
	public void removeArticle(int articleId) throws ArticleNotFoundException{
		IUserManager um = UserManagerImpl.getinstance();
		if (um.getLoginUser().getUserSeq() != am.getArticle(articleId).getUserSeq()) {
			System.out.println("권한이 없습니다.");
			return;
		}
		for (int i = 0; i < articles.size(); i++) {
			if (articles.get(i).getArticleId() == articleId) {
				System.out.println("[" + articles.get(i).getTitle() + "] 게시물을 삭제하였습니다.");
				comments.remove(articles.get(i).getArticleId());
				articles.remove(i);
				break;
			}
		}

	}

	public void updateArticle(Article article) {
		for (int i = 0; i < articles.size(); i++) {
			if (articles.get(i).getArticleId() == article.getArticleId()) {
				articles.get(i).setContent(article.getContent());
				System.out.println(article.getContent() + " 내용으로 수정했어요");
				break;
			}
		}
		System.out.println("해당 게시물이 없어서 수정을 할 수 없어요");
	}

	public List<Article> getTextArticleList() {
		if (articles.size() == 0)
			return null;

		ArrayList<Article> arrayList = new ArrayList<>();
		for (int i = 0; i < articles.size(); i++) {
			if (articles.get(i) instanceof ImageArticle)
				continue;
			arrayList.add(articles.get(i));
		}
		if (arrayList.size() == 0) return null;
		return arrayList;
	}

	public List<ImageArticle> getImageArticleList() {
		if (articles.size() == 0)
			return null;

		ArrayList<ImageArticle> arrayList = new ArrayList<>();
		for (int i = 0; i < articles.size(); i++) {
			if (articles.get(i) instanceof ImageArticle)
			arrayList.add((ImageArticle) articles.get(i));
		}

		if (arrayList.size() == 0) return null;
		return arrayList;
	}

	public double getImageSizeAvg() {
		int sum = 0;
		int count = 0;
		for (int i = 0; i < articles.size(); i++) {
			if (articles.get(i) instanceof ImageArticle) {
				ImageArticle aa = (ImageArticle) articles.get(i);
				sum += aa.getHeight() * aa.getWidth();
				count++;
			}
		}
		return count == 0 ? 0 : sum / count;
	}

	public void addComment(Comment comment) {
		comments.get(comment.getArticleId()).add(comment);
	}

	//
	public void removeComment(int articleId, int commentId) throws CommentNotFoundException {
		IUserManager um = UserManagerImpl.getinstance();
		boolean check = false;
		Article article;
		try {
			article = getArticle(articleId);
		} catch (ArticleNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("해당 게시물이 없습니다.");
			return;
		}
		List<Comment> commentList = comments.get(articleId);
		if (commentList == null) {
			throw new CommentNotFoundException();
		}
		
		for (int i = 0; i < commentList.size(); i++) {
			if (commentList.get(i).getCommentId() == commentId) {
				if (um.getLoginUser().getUserSeq() != commentList.get(i).getUserSeq()){
					System.out.println("권한이 없습니다.");
					return;
				}
				commentList.remove(i);
			}
		}
	}

	public List<Comment> getCommentList(int articleId) {
		if (comments.keySet().size() == 0)
			return null;

		return comments.get(articleId);
	}

	@Override
	public List<Article> search(int option, String keyword) {
		IUserManager um = UserManagerImpl.getinstance();
		List<Article> get_articleList = am.getArticleList();
		List<Article> returnarr = new ArrayList<>();
		int idx = 0;

		if (get_articleList == null)
			return null;

		for (Article article : get_articleList) {
			switch (option) {
			case (1):
				if (article.getTitle().contains(keyword))
					returnarr.add(article);
				break;
			case (2):
				if (article.getContent().contains(keyword))
					returnarr.add(article);
				break;
			case (3):
				User userByUserSeq = um.getUser(keyword);
				if (userByUserSeq == null)
					return null;
				if (article.getUserSeq() == userByUserSeq.getUserSeq())
					returnarr.add(article);
				;
			}
		}

		if (returnarr.size() == 0)
			return null;
		return returnarr;
	}

}
