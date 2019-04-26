package com.multicampus.biz.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

// 2. DAO(Data Access Object) Ŭ����
//@Repository
public class UserDAOIbatis implements UserDAO {
	@Autowired
	private SqlMapClientTemplate ibatis;
	
	// CRUD ����� �޼ҵ�
	// ȸ�� ���
	public void insertUser(UserVO vo) {
		System.out.println("===> iBatis ������� insertUser() ��� ó��");

	}
	
	// ȸ�� ����
	public void updateUser(UserVO vo) {
		System.out.println("===> iBatis ������� updateUser() ��� ó��");
	}	
	
	// ȸ�� ����
	public void deleteUser(UserVO vo) {
		System.out.println("===> iBatis ������� deleteUser() ��� ó��");
	}	
	
	// ȸ�� �� ��ȸ
	public UserVO getUser(UserVO vo) {
		System.out.println("===> iBatis ������� getUser() ��� ó��");
		
		return (UserVO) ibatis.queryForObject("getUser", vo);
	}
	
	// ȸ�� ��� �˻�
	public List<UserVO> getUserList(UserVO vo) {
		System.out.println("===> iBatis ������� getUserList() ��� ó��");
		
		return null;
	}
}
