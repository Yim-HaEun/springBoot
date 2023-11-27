package com.kh.springdb.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kh.springdb.model.Board;
@Mapper
public interface BoardMapper {
	List<Board> getAllBoards();//모든 보드 조회
	Board getBoardById(int id);//보드 하나 조회
	void saveBoard(Board board);//보드 추가하기
	void updateBoard(Board board);//보드 정보 수정
	void deleteBoard(int boardId);//보드 삭제
}