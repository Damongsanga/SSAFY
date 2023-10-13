package com.ssafy.fit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.fit.model.dto.Review;
import com.ssafy.fit.model.service.ReviewService;
import com.ssafy.fit.model.service.ReviewServiceImpl;
import com.ssafy.fit.model.service.VideoService;
import com.ssafy.fit.model.service.VideoServiceImpl;

@WebServlet("/main")
public class MainController extends HttpServlet {
	
	private static String userId = "김시영";

	private static final long serialVersionUID = 1L;

	private VideoService vService = VideoServiceImpl.getInstance();
	private ReviewService rService = ReviewServiceImpl.getInstance();

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getMethod().equals("POST"))
			request.setCharacterEncoding("UTF-8");
		
		System.out.println("service");

		String act = request.getParameter("act");

		switch (act) {
		case "list":
			doList(request, response);
			break;
		case "detail":
			doDetail(request, response);
			break;
		case "registformReview":
			doRegistformReview(request, response);
			break;
		case "registReview":
			doRegistReview(request, response);
			break;	
		case "updateReview":
			doUpdateReview(request, response);
			break;	
		case "updateformReview":
			doUpdateformReview(request, response);
			break;
		case "removeReview":
			doRemoveReview(request, response);
			break;	
//		case "registformVideo":
//			doRegistformVideo(request, response);
//			break;
//		case "registVideo":
//			doRegistVideo(request, response);
//			break;	
//		case "updateVideo":
//			doUpdateVideo(request, response);
//			break;	
//		case "updateformVideo":
//			doUpdateformVideo(request, response);
//			break;
//		case "removeVideo":
//			doRemoveVideo(request, response);
//			break;	
		case "pick":
			doPick(request, response);
			break;	
		}
	}

	private void doPick(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String part = request.getParameter("part");
		request.setAttribute("list", vService.chooseList(part));
		request.getRequestDispatcher("/mainpage/list.jsp").forward(request, response);
	}

	private void doUpdateformReview(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int reviewId = Integer.parseInt(request.getParameter("reviewId"));
		Review review = rService.getReview(reviewId);
		request.setAttribute("review", review);
		request.getRequestDispatcher("/review/updateform.jsp").forward(request, response);
	}


	private void doUpdateReview(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		int videoId = Integer.parseInt(request.getParameter("videoId"));
		int reviewId = Integer.parseInt(request.getParameter("reviewId"));
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		Review review = new Review(videoId, writer, content);
		review.setReviewId(reviewId);
		
		rService.modifyReview(review);
		
		request.setAttribute("video", vService.getVideo(videoId));
		request.setAttribute("reviewList", rService.getSelectedList(videoId));
		request.getRequestDispatcher("/mainpage/detail.jsp").forward(request, response);
		
	}

	private void doRemoveReview(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		int reviewId = Integer.parseInt(request.getParameter("reviewId"));
		int videoId = Integer.parseInt(request.getParameter("videoId"));
		rService.removeReview(reviewId, userId);
		
		request.setAttribute("video", vService.getVideo(videoId));
		request.setAttribute("reviewList", rService.getSelectedList(videoId));
		request.getRequestDispatcher("/mainpage/detail.jsp").forward(request, response);
		
	}
	
	private void doRegistReview(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		int videoId = Integer.parseInt(request.getParameter("videoId"));
		int reviewId = Integer.parseInt(request.getParameter("reviewId"));
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		
		Review review = new Review(videoId, writer, content);
		review.setReviewId(reviewId);
		
		rService.writeReview(review);
		
		request.setAttribute("reviewList", rService.getSelectedList(videoId));
		request.setAttribute("video", vService.getVideo(videoId));
		System.out.println(rService.getList().size());
		request.getRequestDispatcher("/mainpage/detail.jsp").forward(request, response);
	}

	private void doRegistformReview(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("videoId", request.getParameter("videoId"));
		request.setAttribute("userId", userId);
		request.getRequestDispatcher("/review/registform.jsp").forward(request, response);
	}
	

	private void doDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("video", vService.getVideo(id));
		request.setAttribute("reviewList", rService.getSelectedList(id));
		request.getRequestDispatcher("/mainpage/detail.jsp").forward(request, response);
	}


	private void doList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setAttribute("list", vService.getList());
		request.getRequestDispatcher("/mainpage/list.jsp").forward(request, response);
	}
	
	
	
	// 여기부터 구현해보자
	
//	private void doRegistformVideo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setAttribute("reviewId", request.getParameter("reviewId"));
//		request.getRequestDispatcher("/video/registform.jsp").forward(request, response);
//	}
//	
//	private void doRegistVideo(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {	
//		int videoId = Integer.parseInt(request.getParameter("videoId"));
//		String writer = request.getParameter("writer");
//		String content = request.getParameter("content");
//		
//		Review review = new Review(videoId, writer, content);
//		
//		rService.writeReview(review);
//		request.setAttribute("reviewList", rService.getSelectedList(videoId));
//		request.setAttribute("video", vService.getVideo(videoId));
//		request.getRequestDispatcher("/mainpage/detail.jsp").forward(request, response);
//	}
//	
//	private void doUpdateformVideo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		int reviewId = Integer.parseInt(request.getParameter("reviewId"));
//		Review review = rService.getReview(reviewId);
//		request.setAttribute("review", review);
//		request.getRequestDispatcher("/video/updateform.jsp").forward(request, response);
//	}
//	
//	private void doUpdateVideo(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//		int videoId = Integer.parseInt(request.getParameter("videoId"));
//		int reviewId = Integer.parseInt(request.getParameter("reviewId"));
//		String writer = request.getParameter("writer");
//		String content = request.getParameter("content");
//		
//		rService.modifyReview(reviewId, writer, content); // 이거 제대로 구현 못함
//		request.setAttribute("list", vService.getList());
//		request.getRequestDispatcher("/mainpage/list.jsp").forward(request, response);
//		
//	}
//
//	private void doRemoveVideo(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//		// 어떤걸 삭제해야되는지 설정해줘야함
		//		int reviewId = Integer.parseInt(request.getParameter("reviewId"));
//		int videoId = Integer.parseInt(request.getParameter("videoId"));
//		rService.removeReview(reviewId, userId);
//		
//		request.setAttribute("video", vService.getVideo(videoId));
//		request.setAttribute("reviewList", rService.getSelectedList(videoId));
//		request.getRequestDispatcher("/mainpage/detail.jsp").forward(request, response);
//		
//	}
//}
}