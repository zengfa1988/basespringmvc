package com.tsh.eis.client.erp.vo;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

/**
 * 日志子类
 * @author Administrator
 *
 */
public class LogResultApi implements Serializable{

	private static final long serialVersionUID = 1L;

	private String method;// 方法名称,如：save
	private String api;// 接口路径,如：AreaApi
	private String path;// com.tsh.dubbo.share.api.AreaApi
	private String params;// 参数
	private int count; // 第几步
	private int status;
	private String msg;
	private String logType; // 日志类型,info,warn,error
	private long longtimes = 0;// 用时
	private Date startDate;
	private Date endDate;
	
	public LogResultApi(String method, String api, String path) {
		super();
		this.method = method;
		this.api = api;
		this.path = path;
		this.logType = "info";
		this.startDate = new Date();
	}
	
	public LogResultApi(String method, String api, String path, String params) {
		this(method,api,path);
		this.params = params;
	}
	
	public LogResultApi(String method, String api, String path, String params,int count) {
		this(method, api, path, params);
		this.count = count;
	}
	
	public LogResultApi(String method, String api, String path,int status,String msg,Date endDate) {
		this(method,api,path);
		this.status = status;
		this.msg = msg;
		this.endDate = endDate;
	}
	
	public String getContent(){
		String content = "\r\n第" + count + "步:接口方法=" + path + ",status=" + status + ",message=" + msg + ",日志类型="
				+ logType + ",耗时=" + longtimes;
		if (StringUtils.isNotBlank(params)) {
			content += "\r\n参数：" + params;
		}
		return content;
	}
	
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getApi() {
		return api;
	}
	public void setApi(String api) {
		this.api = api;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getParams() {
		return params;
	}
	public void setParams(String params) {
		this.params = params;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getLogType() {
		return logType;
	}
	public void setLogType(String logType) {
		this.logType = logType;
	}
	public long getLongtimes() {
		return longtimes;
	}
	public void setLongtimes(long longtimes) {
		this.longtimes = longtimes;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
