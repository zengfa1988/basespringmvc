package com.tsh.eis.client.erp.vo;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

import com.tsh.eis.client.erp.util.RequestUtil;

/**
 * 接口返回结果对象，该对象禁止返回给页面直接使用，页面分页返回Pagination或者PageReturnDTO,普通结果返回ReturnDTO,
 * 返回数据成功与否使用status和msg字段。
 * @author Administrator
 *
 */
public class Result implements Serializable{

	private static final long serialVersionUID = 1L;

	private int status;
	private String msg;
	private Object data;
	
	private UserInfo userInfo;
	private LogResult logResult;
	
	public Result(){
		this.logResult = new LogResult();
	}
//	public Result(HttpServletRequest request,String teamName){
//		this.logResult = new LogResult(teamName, RequestUtil.getRequstURL(request), RequestUtil.getClientIp(request),RequestUtil.getRequestParams(request),this.userInfo);
//	}
	public Result(HttpServletRequest request,String teamName,UserInfo userInfo){
//		this(request,teamName);
		this.userInfo = userInfo;
//		this.logResult = new LogResult(teamName, RequestUtil.getRequstURL(request), RequestUtil.getClientIp(request),RequestUtil.getRequestParams(request),this.userInfo);
	}
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public LogResult getLogResult() {
		return logResult;
	}

	public void setLogResult(LogResult logResult) {
		this.logResult = logResult;
	}
	public UserInfo getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	
}
