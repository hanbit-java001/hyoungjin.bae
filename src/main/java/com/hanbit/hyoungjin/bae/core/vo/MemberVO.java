package com.hanbit.hyoungjin.bae.core.vo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope("prototype")		// DL(Depandency lookup)시 마다 매번 생성 //@Scope("session") 새션
public class MemberVO {

	private int memberId;
	private String name;
	private String email;
	private String password;
	private String currentPassword;
	private String profileFileId;


	public String getProfileFileId() {
		return profileFileId;
	}
	public void setProfileFileId(String profileFileId) {
		this.profileFileId = profileFileId;
	}
	public String getCurrentPassword() {
		return currentPassword;
	}
	public void setCurrentPassword(String currentPassword) {
		this.currentPassword = currentPassword;
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}


}
