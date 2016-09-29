package com.hanbit.hyoungjin.bae.core.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.stereotype.Service;

import com.hanbit.hyoungjin.bae.core.dao.MemberDAO;
import com.hanbit.hyoungjin.bae.core.vo.MemberVO;

@Service
public class SecurityService {

	private static final Logger LOGGER = LoggerFactory.getLogger(SecurityService.class);

	private static PasswordEncoder encoder = new StandardPasswordEncoder();

	@Autowired
	private MemberDAO memberDAO;

	public String encryptPassword(String password){
		return encoder.encode(password);
	}

	public boolean matchPassword(String rawPassword, String encryptedPaaword){
		return encoder.matches(rawPassword, encryptedPaaword);
	}

	public MemberVO getValidMember(String email, String password){
		MemberVO member = null;

		try{
			member = memberDAO.selectMember(email);
		}
		catch(Exception e){
			throw new RuntimeException("가입되지 않은 이메일입니다.");
		}

		String encrytedPassword = member.getPassword();

		if(matchPassword(password, encrytedPassword)){
			throw new RuntimeException("패스워드가 일치하지 않습니다.");
		}

		return member;
	}
}
