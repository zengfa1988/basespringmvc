package com.tsh.eis.client.erp.vo;

import java.io.Serializable;

public class UserVo implements Serializable{

	private Long userId;
	
	private String userName;
	
	private String sex;
	
	private String email;
	
	private Integer age;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "UserVo [userId=" + userId + ", userName=" + userName + ", sex=" + sex + ", email=" + email + ", age="
				+ age + "]";
	}
	
}
