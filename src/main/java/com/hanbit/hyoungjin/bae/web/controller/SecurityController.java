package com.hanbit.hyoungjin.bae.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hanbit.hyoungjin.bae.core.service.SecurityService;
import com.hanbit.hyoungjin.bae.core.vo.MemberVO;

@Controller
public class SecurityController {

	@Autowired
	private SecurityService securityService;

	@RequestMapping(value="/api/security/login", method=RequestMethod.POST)
	@ResponseBody
	public Map login(@RequestParam("email") String email, @RequestParam("password") String password,
					 HttpServletRequest request){

		MemberVO member = securityService.getValidMember(email, password);

		HttpSession session = request.getSession(); //이거는 session 오브젝트지 실제session이라는 것은 눈에보이지 않는 어딘가에 존쟈
		session.setAttribute("email", email);
		session.setAttribute("loggedIn", true);

		Map result = new HashMap();
		result.put("name", member.getName());

		return result;
	}

	// response를 직접 처리하기 위해서 @ResponseBody 를 안한거다
	@RequestMapping("/api/security/logout")
	public void logout(HttpServletRequest request, HttpServletResponse response) throws Exception{

		HttpSession session = request.getSession();
		session.invalidate();		//섹션객체 안에 모든것을 지워준다. => 결국 로그아웃이 된다.

		response.sendRedirect("/");

	}

}
