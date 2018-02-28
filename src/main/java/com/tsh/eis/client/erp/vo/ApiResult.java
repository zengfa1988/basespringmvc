package com.tsh.eis.client.erp.vo;

import java.io.Serializable;

public class ApiResult implements Serializable{

	/**
	 * 返回状态类型.200：成功 .
	 */
	protected int status = 200;

	/**
	 * 返回描述信息内容..
	 */
	protected String msg = null;

	/**
	 * 日志编码
	 */
	private int code;

	/**
	 * 日志编码消息
	 */
	private String codeMsg;

	/**
	 * 返回的对像，正确时返回的结果.
	 */
	protected Object data;

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

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getCodeMsg() {
		return codeMsg;
	}

	public void setCodeMsg(String codeMsg) {
		this.codeMsg = codeMsg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
}
