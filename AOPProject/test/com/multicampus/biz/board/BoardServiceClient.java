package com.multicampus.biz.board;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BoardServiceClient {
	public static void main(String[] args) {
		// 1. Spring 컨테이너를 구동한다.
		ClassPathXmlApplicationContext container = 
			new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// 2. Spring 컨테이너로부터 테스트 객체를 Lookup한다.
		BoardService boardService = 
			(BoardService) container.getBean("boardService");
		
		// 3. 메소드 테스트
		BoardVO vo = new BoardVO();
		vo.setSeq(100);
		vo.setTitle("테스트 제목");
		vo.setWriter("테스터");
		vo.setContent("테스트 내용..........");
		//boardService.insertBoard(vo);
		

		List<BoardVO> boardList = boardService.getBoardList(vo);
		for (BoardVO board : boardList) {
			System.out.println("---> " + board.toString());
		}
	}
}






