package com.kh.springdb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.springdb.model.Board;
import com.kh.springdb.service.BoardService;

@Controller
@RequestMapping("/boards")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	//모든 정보 가져오기
	@GetMapping//("/boards")
	public String getAllBoards(Model model) {
		//게시물 전체보는 Controller
		List<Board> boards = boardService.getAllBoards();
		model.addAttribute("boards",boards);
		return "board-list";
	}
	//하나의 보드 가져오기 
	// /boards/{boardId} 이 주소로 앞에 boards가 내장되어있음
	@GetMapping("/{boardId}")
	public String getBoardById(@PathVariable int boardId, Model model) {
		Board board = boardService.getBoardById(boardId);
		model.addAttribute("board",board);
		return "board-detail";
	}
	//@GetMapping을 사용해서 게시글 작성하는 html로 이동한 후
	@GetMapping("/create") 
	//HTTP GET 요청이 /create라는 경로로 들어올 때 호출
	public String displayCreateForm(Model model) { 
		//Model 객체를 매개변수로 받아서 templates(view)으로 데이터를 전달할 수 있음
		model.addAttribute("board",new Board());
		//new Board로 새로운 Board객체를 생성해서 모델에 추가
		return "board-form";//board-form.html 템플릿에서 해당 뷰를 보여줌 
	}
	//PostMapping을 사용해서 작성해놓은 INSERT HTML form을 가져온다.
	@PostMapping("create")
	public String createBoard(@ModelAttribute Board board) {
		boardService.saveBoard(board);
		return "redirect:/boards"; //글이 작성된 후 돌아갈 템플릿 작성
		
	}
	
		
}