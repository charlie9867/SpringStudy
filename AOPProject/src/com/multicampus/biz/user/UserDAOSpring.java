package com.multicampus.biz.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

// 2. DAO(Data Access Object) Ŭ����
//@Repository
public class UserDAOSpring implements UserDAO {
	@Autowired
	private JdbcTemplate spring;
	
	// SQL ��ɾ��
	private final String USER_GET = "select * from users where id=? and password=?";
	private final String USER_INSERT = "insert into users values(?, ?, ?, ?)";
	
	// CRUD ����� �޼ҵ�
	// ȸ�� ���
	public void insertUser(UserVO vo) {
		System.out.println("===> SPRING ������� insertUser() ��� ó��");
		spring.update(USER_INSERT, vo.getId(), vo.getPassword(), vo.getName(), vo.getRole());
	}
	
	// ȸ�� ����
	public void updateUser(UserVO vo) {
		System.out.println("===> SPRING ������� updateUser() ��� ó��");
	}	
	
	// ȸ�� ����
	public void deleteUser(UserVO vo) {
		System.out.println("===> SPRING ������� deleteUser() ��� ó��");
	}	
	
	// ȸ�� �� ��ȸ
	public UserVO getUser(UserVO vo) {
		System.out.println("===> SPRING ������� getUser() ��� ó��");
		Object[] args = {vo.getId(), vo.getPassword()};
		return spring.queryForObject(USER_GET, args, new UserRowMapper());
	}
	
	// ȸ�� ��� �˻�
	public List<UserVO> getUserList(UserVO vo) {
		System.out.println("===> SPRING ������� getUserList() ��� ó��");
		return null;
	}
}
