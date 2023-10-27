package com.ssafy.board.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ssafy.board.model.dto.Board;
import com.ssafy.board.model.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	

//	@RequestMapping(value = "/", method = RequestMethod.GET)
	@GetMapping
	public String index() {
		// 서비스 -> DAO -> DB -> ??
		// 현재는 index.jsp 가 없음으로 바로 리스트로 다시 요청하게끔 돌려보냄
		return "redirect:list";
	}
	
	
	@GetMapping("list")
	public String list(Model model) { // return 값 : 1. ModelAndView 2. String (약식, View의 이름)
		List<Board> list = boardService.getList();
		model.addAttribute("list", list);
		return "/board/list";
	}
	
	@GetMapping("detail")
	public String detail(Model model, int id) {
		Board board = boardService.getBoard(id);
		System.out.println(board.getContent());
		model.addAttribute(board);
		
		return "/board/detail";
	}
	
	@GetMapping("writeform")
	public String writeform() {
		return "/board/writeform";
	}
	
	@PostMapping("write")
	public String write(Board board) {
		boardService.writeBoard(board);
		return "redirect:list";
	}
	
	
	@GetMapping("delete")
	public String delete(int id) {
		boardService.removeBoard(id);
		return "/board/detail";
	}
	
	@GetMapping("updateform")
	public String updateform(Model model, int id) {
		// 여기서 게시글 얻어올 때 조회수 증가해버림 (잘못된것..)
		model.addAttribute("board", boardService.getBoard(id));
		return "/board/updateform";
	}
	
	@PostMapping("update")
	public String update(Board board) {
		boardService.modifyBoard(board);
		return "redirect:detail?id="+board.getId();
	}
	
}
