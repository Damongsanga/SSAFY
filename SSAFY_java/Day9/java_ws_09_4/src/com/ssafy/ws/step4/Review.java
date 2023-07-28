package com.ssafy.ws.step4;

public class Review {
	private int reviewId;
	private int resId;
	private String writer;
	private String content;
	
	public Review() {
		// TODO Auto-generated constructor stub
	}

	public Review(int reviewId, int resId, String writer, String content) {
		super();
		this.reviewId = reviewId;
		this.resId = resId;
		this.writer = writer;
		this.content = content;
	}

	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}

	public int getResId() {
		return resId;
	}

	public void setResId(int resId) {
		this.resId = resId;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Review [reviewId=" + reviewId + ", resId=" + resId + ", writer=" + writer + ", content=" + content
				+ "]";
	}
	
	

}
