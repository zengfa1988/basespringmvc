package com.tsh.eis.client.erp.vo;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class UserInfo implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long userId;
	
	private String userName;
	
	private Date loginTime;// 登录时间
	
	private String loginIp;//登录ip
	
	private String token;

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

	public Date getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	public String getLoginIp() {
		return loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
//		return "UserInfo [userId=" + userId + ", userName=" + userName + ", loginTime=" + loginTime + ", loginIp="
//				+ loginIp + ", token=" + token + "]";
	}
	
}
