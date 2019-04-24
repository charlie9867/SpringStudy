package com.multicampus.biz.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

// 2. DAO(Data Access Object) 클래스
//@Repository
public class UserDAOSpring implements UserDAO {
	@Autowired
	private JdbcTemplate spring;
	
	// SQL 명령어들
	private final String USER_GET = "select * from users where id=? and password=?";
	private final String USER_INSERT = "insert into users values(?, ?, ?, ?)";
	
	// CRUD 기능의 메소드
	// 회원 등록
	public void insertUser(UserVO vo) {
		System.out.println("===> SPRING 기반으로 insertUser() 기능 처리");
		spring.update(USER_INSERT, vo.getId(), vo.getPassword(), vo.getName(), vo.getRole());
	}
	
	// 회원 수정
	public void updateUser(UserVO vo) {
		System.out.println("===> SPRING 기반으로 updateUser() 기능 처리");
	}	
	
	// 회원 삭제
	public void deleteUser(UserVO vo) {
		System.out.println("===> SPRING 기반으로 deleteUser() 기능 처리");
	}	
	
	// 회원 상세 조회
	public UserVO getUser(UserVO vo) {
		System.out.println("===> SPRING 기반으로 getUser() 기능 처리");
		Object[] args = {vo.getId(), vo.getPassword()};
		return spring.queryForObject(USER_GET, args, new UserRowMapper());
	}
	
	// 회원 목록 검색
	public List<UserVO> getUserList(UserVO vo) {
		System.out.println("===> SPRING 기반으로 getUserList() 기능 처리");
		return null;
	}
}
