package com.kh.springdb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.springdb.mapper.BoardMapper;
import com.kh.springdb.model.Board;

@Service
public class BoardService {
	@Autowired
	private BoardMapper boardMapper;
	
	//전체 보드 가져오기
	public List<Board> getAllBoards() {
		return boardMapper.getAllBoards();
	}
	//하나의 보드 정보 하나 가져오기
	public Board getBoardById(int boardId) {
		return boardMapper.getBoardById(boardId);
	}
	//게시판에서 게시글 작성하기 service
	public void saveBoard(Board board) {
		boardMapper.saveBoard(board);
	}
	//게시판에서 게시글 수정하기 Service
	public void updateBoard(Board board) {
		boardMapper.updateBoard(board);
	}
	//게시판에서 게시글 삭제하기
	public void deleteBoard(int boardId) {
		boardMapper.deleteBoard(boardId);
	}
}