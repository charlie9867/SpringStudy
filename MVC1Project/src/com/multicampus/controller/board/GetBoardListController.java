package com.multicampus.controller.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.multicampus.biz.board.BoardDAOJDBC;
import com.multicampus.biz.board.BoardVO;

public class GetBoardListController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("글 목록 검색 기능 처리"); 
		
		// 1. 사용자 입력정보 추출(검색 기능은 숙제)
		// 2. DB 연동 처리
		BoardVO vo = new BoardVO();
		BoardDAOJDBC boardDAO = new BoardDAOJDBC();
		List<BoardVO> boardList = boardDAO.getBoardList(vo);
		
		// 3. 검색 결과를 세션에 등록하고 적절한 JSP 화면으로 이동한다.
		HttpSession session = request.getSession();
		session.setAttribute("boardList", boardList);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("getBoardList");
		return mav;
		
	}

}








