package com.tsh.eis.client.erp.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.tsh.eis.client.erp.vo.LogResult;
import com.tsh.eis.client.erp.vo.Result;
import com.tsh.eis.client.erp.vo.UserInfo;

public class BaseController {

	protected Logger logger = Logger.getLogger(getClass());
	
	@Autowired protected HttpServletRequest request;
	@Autowired protected HttpServletResponse response;
	
	public Result getResult(){
		return getResult(request);
	}
	
	/**
	 * 定义这个是方便有些地方需要在方法初始化的时候中传入request，如果没有传入的在地方，这个方法可以不要，将内容移至getResult()即可 
	 * @param request
	 * @return
	 */
	public Result getResult(HttpServletRequest request) {
		UserInfo userInfo = new UserInfo();
		userInfo.setUserId(112l);
		userInfo.setUserName("admin");
		userInfo.setLoginTime(new Date());
		userInfo.setLoginIp("127.0.0.1");
		Result result = new Result(request,"eis",userInfo);
		return result;
	}
	
	public void send(Result result){
		LogResult logResult = result.getLogResult();
		logResult.colse(result.getStatus(), result.getMsg());
		logger.info(logResult.getContent());
//		System.out.println(logResult.getContent());
	}

}
