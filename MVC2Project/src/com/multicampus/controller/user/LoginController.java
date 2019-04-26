package com.multicampus.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.multicampus.biz.user.UserDAOJDBC;
import com.multicampus.biz.user.UserService;
import com.multicampus.biz.user.UserVO;

@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;

	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String loginView(@ModelAttribute("user") UserVO vo) throws Exception {
//		String name = null;
//		System.out.println(name.length());
		vo.setId("test");
		vo.setPassword("test");
		return "login";
	}
	
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public String login(UserVO vo) throws Exception {
		if(userService.getUser(vo) != null) return "redirect:getBoardList.do";
		else return "login";
	}

}










