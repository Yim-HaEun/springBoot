package com.kh.board.controller;
import java.util.Optional;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.board.service.BoardService;
import com.kh.board.vo.Board;

@Controller
@RequestMapping("/boards")
public class BoardController {
	private final BoardService boardService;
	@Autowired
	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}
	
	//모든 게시물을 보기위한
	@GetMapping
	public String getAllBoards(Model model) {
		List<Board> boards = boardService.getAllBoards();
		model.addAttribute("boards",boards);
		return "board_list";
	}
	//제품 상세보기
	@GetMapping("/detail/{boardId}")
	public String getBoardById(@PathVariable Long boardId, Model model) {
		Optional<Board> board = boardService.getBoardById(boardId);
		board.ifPresent(value -> model.addAttribute("board", value));
		return "board_detail";
	}
	//insert
	@GetMapping("/new")
	public String displayBoardForm(Model model) {
		model.addAttribute("board",new Board());
		return "board_form";
	}
	@PostMapping("/save")
	public String saveBoard(@ModelAttribute Board board) {
		boardService.saveBoard(board);
		return "redirect:/boards";
		
	}
	//수정하기
	@GetMapping("/update/{boardId}")
	public String getUpdateBoard(@PathVariable Long boardId, Model model) {
		Optional<Board> board = boardService.getBoardById(boardId);
		board.ifPresent(value -> model.addAttribute("board", value));
		return "board_form";
	}
	@GetMapping("/delete/{boardId}")
	public String deleteBoard(@PathVariable Long boardId) {
		boardService.deleteBoardById(boardId);
		return "redirect:/boards";
	}
	//모두 삭제하기
	@GetMapping("/delete/all")
	public String deleteAllBoards() {
		boardService.deleteAllBoards();
		return "redirect:/boards";
	}
		
	

}
