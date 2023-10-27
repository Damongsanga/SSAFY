package com.ssafy.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.board.model.dto.Board;
import com.ssafy.board.model.dto.SearchCondition;
import com.ssafy.board.model.service.BoardService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/api") // 모두 api라는 요청을 포함할 것임으로
@Api(tags = "게시판 컨트롤러") // 설명 ~ 필수 아님 ~
@CrossOrigin("*")
public class BoardRestController {

	@Autowired
	private BoardService boardService;
	
	// 1. 목록 (검색 조건 있을수도 없을수도)
	@GetMapping("/board")
	public ResponseEntity<?> list(SearchCondition condition){
		List<Board> list = boardService.search(condition);
		if (list == null || list.size() == 0) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<Board>>(list, HttpStatus.OK);
		} 
	}
	
	// 2. 상세보기
	@GetMapping("/board/{id}")
	public ResponseEntity<Board> detail(@PathVariable int id){
		Board board = boardService.getBoard(id);
		if (board == null) return new ResponseEntity<Board>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<Board>(board, HttpStatus.OK);
	}
	
	// 3. 삽입
	@PostMapping("/board")
	// JSON 형태로 들어왔을  때 처리하고 싶은데? : @RequestBody
	public ResponseEntity<Board> write(@RequestBody Board board){
		boardService.writeBoard(board);
		// ID는 어자피 중복이 안돼서 무조건 게시글이 등록이 되지만
		// 문제 발생해서 게시글이 등록이 안될 수도 있음
		// I, U, D 테이블의 행의 변환 개수를 반환해 주니까 이를 이용할 수도
		return new ResponseEntity<Board>(board, HttpStatus.CREATED);
	}
	
	// 4. 삭제
	@DeleteMapping("/board/{id}")
	public ResponseEntity<Void> delete(@PathVariable int id){
		boardService.removeBoard(id);
		// 반환 값을 통해서 지워졌던지 안지워졌던지 체크
		// 이상한 id 접근을 막을 것
		// 다른 사람도 요청 주소를 통해 내 글을 지워버릴 수 있으니 권한 체크 (인터셉터)
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
//	// 5. 수정
//	@PutMapping("/board")
//	// JSON 형태로 들어왔을  때 처리하고 싶은데? : @RequestBody
//	public ResponseEntity<Void> update(@RequestBody Board board){
//		boardService.modifyBoard(board);
//		return new ResponseEntity<Void>(HttpStatus.OK);
//	}
	
	@PutMapping("/board/{id}")
	// JSON 형태로 들어왔을  때 처리하고 싶은데?
	public ResponseEntity<Void> update(@RequestBody Board board, @PathVariable int id){
		board.setId(id);
		boardService.modifyBoard(board);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	
//	@PostMapping("/board")
//	public void write(Board board){
//		boardService.writeBoard(board);
//		detail(board.getId());
////		return new ResponseEntity<Board>(board, HttpStatus.CREATED);
//	}
	
	

}
