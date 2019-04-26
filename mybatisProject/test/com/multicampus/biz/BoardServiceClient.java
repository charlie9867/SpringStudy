package com.multicampus.biz;

import java.sql.SQLException;
import java.util.List;

import com.multicampus.biz.board.BoardDAO;
import com.multicampus.biz.board.BoardVO;

public class BoardServiceClient {	
	public static void main(String[] args) throws SQLException {
		BoardDAO boardDAO = new BoardDAO();
		
		BoardVO vo = new BoardVO();
		vo.setTitle("myBaits 제목");
		vo.setWriter("홍길동");
		vo.setContent("myBatis 내용.....");		
		boardDAO.insertBoard(vo);

		List<BoardVO> boardList = boardDAO.getBoardList(vo);
		for (BoardVO board : boardList) {
			System.out.println("---> " + board.toString());
		}
	}
}
