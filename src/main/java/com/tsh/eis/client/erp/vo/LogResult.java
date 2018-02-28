package com.tsh.eis.client.erp.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.tsh.eis.client.erp.util.DateUtil;

/**
 * 日志主类
 * @author Administrator
 *
 */
public class LogResult implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public static String TEMPLATE_WEB = "\r\n第1步:来源=@1@,请求地址=@2@,开始时间=@3@,共@4@步,日志类型=@5@,共耗时=@6@";
	
	private String teamName; // 所属项目
	private String url;// 请求地址
	private String method;// 方法名称,如：save.do 不保留.do
	private String ip; // ip地址
	private int status;
	private String msg;
	private String logType = "info"; // 日志类型,info,warn,error
	private int count; // 步骤
	private String content = "";// 日志内容
	private long longtimes = 0;// 用时
	private String params;// 参数
	private Date startDate;
	private Date endDate;
	private List<LogResultApi> apiList = new ArrayList<LogResultApi>();
	
	public LogResult(){
		
	}
//	public LogResult(String teamName, String url, String method, String ip, String params) {
//		this(teamName,url,ip,params,null);
//		this.method = method;
//	}
	
	public LogResult(String teamName, String url,String ip, String params,UserInfo userInfo) {
		super();
		this.teamName = teamName;
		this.url = url;
		this.ip = ip;
		this.params = params;
		this.startDate = new Date();
		this.count = 1;
		this.content = TEMPLATE_WEB.replace("@1@", StringUtils.trimToEmpty(teamName))
				.replace("@2@", "IP:"+ip+","+StringUtils.trimToEmpty(url)).replace("@3@", DateUtil.formatDateToString(startDate));
		if(userInfo!=null){
			this.content += "\r\nUserInfo：" + userInfo.toString();
		}
		this.content += "\r\n请求参数：" + params;
	}
	
	public void beforePutApi(LogResultApi api) {
		this.count += 1;
		api.setCount(count);
		apiList.add(api);
	}
	
	public void afterPutApi(LogResultApi api) {
		for(LogResultApi logResultApi : apiList){
			if (logResultApi.getPath().equals(api.getPath())) {
				logResultApi.setStatus(api.getStatus());
				logResultApi.setMsg(api.getMsg());
				logResultApi.setEndDate(api.getEndDate());
				long logtimes = api.getEndDate().getTime() - logResultApi.getStartDate().getTime();
				logResultApi.setLongtimes(logtimes < 1 ? 1 : logtimes);
				break;
			}
		}
	}
	
	public void colse(int status, String msg) {
		try {
//			long colseTime = System.currentTimeMillis() - this.startTimes;
			this.status = status;
			this.msg = msg;
//			for (LogResultApi logApi : apiList) {
////				if ("warn".equalsIgnoreCase(logApi.getLogType())) {
////					this.logType = logApi.getLogType();
////				} else if ("error".equalsIgnoreCase(logApi.getLogType()) || logApi.getStatus() != Result.STATUS_OK) {
////					this.logType = "error";
////				}
//				this.longtimes += logApi.getLongtimes();
//			}
//			if (this.longtimes < colseTime) {
//				this.longtimes = colseTime;
//			}
//			for (int i = 0; i < apiList.size(); i++) {
//				LogResultApi logApi = apiList.get(i);
//				for (int j = i + 1; j < apiList.size(); j++) {
//					if (StringUtils.trimToEmpty(logApi.getErrorMsg()).length() == StringUtils
//							.trimToEmpty(apiList.get(j).getErrorMsg()).length()) {
//						logApi.setErrorMsg(null);
//					}
//				}
//			}
			this.endDate = new Date();
			this.longtimes = this.endDate.getTime()-this.startDate.getTime();
			if (StringUtils.isNotBlank(this.url)) {
				this.content = this.content.replace("@4@", this.count+"")
						.replace("@5@", this.logType).replace("@6@", longtimes+"");
			}
			for (LogResultApi logResultApi : apiList) {
				this.content += logResultApi.getContent();
			}
		} catch (Exception e) {
			//不处理异常，保证不影响业务的正常
		}
	}
	
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
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
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public long getLongtimes() {
		return longtimes;
	}
	public void setLongtimes(long longtimes) {
		this.longtimes = longtimes;
	}
	public String getParams() {
		return params;
	}
	public void setParams(String params) {
		this.params = params;
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
	public List<LogResultApi> getApiList() {
		return apiList;
	}
	public void setApiList(List<LogResultApi> apiList) {
		this.apiList = apiList;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}

}
