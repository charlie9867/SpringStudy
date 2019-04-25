package com.multicampus.biz.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

// 2. DAO(Data Access Object) Ŭ����
//@Repository
public class BoardDAOSpring implements BoardDAO {
	@Autowired
	private JdbcTemplate spring;

	// SQL ��ɾ��
	private final String BOARD_INSERT = "insert into board(seq, title, writer, content) values((select nvl(max(seq), 0)+1 from board),?,?,?)";
	private final String BOARD_UPDATE = "update board set title=?, content=? where seq=?";
	private final String BOARD_DELETE = "delete board where seq=?";
	private final String BOARD_GET    = "select * from board where seq=?";
	private final String BOARD_LIST_T = "select * from board where title like '%'||?||'%' order by seq desc";
	private final String BOARD_LIST_C = "select * from board where content like '%'||?||'%' order by seq desc";
	
	// CRUD ����� �޼ҵ� ����
	// �� ���
	public void insertBoard(BoardVO vo) {
		System.out.println("===> SPRING ������� insertBoard() ��� ó��");
		spring.update(BOARD_INSERT, vo.getTitle(), vo.getWriter(), vo.getContent());
	}

	// �� ����
	public void updateBoard(BoardVO vo) {
		System.out.println("===> SPRING ������� updateBoard() ��� ó��");
		Object[] args = {vo.getTitle(), vo.getContent(), vo.getSeq()};
		spring.update(BOARD_UPDATE, args);
	}

	// �� ����
	public void deleteBoard(BoardVO vo) {
		System.out.println("===> SPRING ������� deleteBoard() ��� ó��");
		spring.update(BOARD_DELETE, vo.getSeq());
	}
	
	// �� �� ��ȸ
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> SPRING ������� getBoard() ��� ó��");
		Object[] args = {vo.getSeq()};
		return spring.queryForObject(BOARD_GET, args, new BoardRowMapper());
	}

	// �� ��� �˻�
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("===> SPRING ������� getBoardList() ��� ó��");
		Object[] args = {vo.getSearchKeyword()};
		if(vo.getSearchCondition().equals("TITLE")) {
			return spring.query(BOARD_LIST_T, args, new BoardRowMapper());
		} else if(vo.getSearchCondition().equals("CONTENT")) {
			return spring.query(BOARD_LIST_C, args, new BoardRowMapper());
		}
		return null;
	}
}












