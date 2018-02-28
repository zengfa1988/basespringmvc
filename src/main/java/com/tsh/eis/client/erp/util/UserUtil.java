package com.tsh.eis.client.erp.util;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import com.tsh.eis.client.erp.vo.UserInfo;

public class UserUtil {

	public static UserInfo getUserInfo(HttpServletRequest request){
		UserInfo userInfo = new UserInfo();
		userInfo.setUserId(112l);
		userInfo.setUserName("admin");
		userInfo.setLoginTime(new Date());
		userInfo.setLoginIp("127.0.0.1");
		return userInfo;
	}
}
