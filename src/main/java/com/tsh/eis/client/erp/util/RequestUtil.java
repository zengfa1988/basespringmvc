package com.tsh.eis.client.erp.util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

public class RequestUtil {

	public static String getRequstURL(HttpServletRequest request) {
		if (request == null)
			return "";
		String path = request.getRequestURI();
		String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
		return basePath;
	}
	
	/**
	 * 获取客户端IP地址,考虑到代理、反向代理等
	 * @param request
	 * @return
	 */
	public static String getClientIp(HttpServletRequest request) {
		if (request == null)
			return "";
		String ip = request.getHeader("x-forwarded-for");
		System.setProperty("java.net.preferIPv4Stack", "true");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
			if (ip.equals("127.0.0.1") || ip.equals("0:0:0:0:0:0:0:1")) {
				InetAddress inet = null;
				try {
					inet = InetAddress.getLocalHost();
				} catch (UnknownHostException e) {
					e.printStackTrace();
				}
				ip = inet.getHostAddress();
			}
		}
		if (ip != null && ip.length() > 15) {
			if (ip.indexOf(",") > 0) {
				ip = ip.substring(0, ip.indexOf(","));
			}
		}
		return ip;
	}
	
	public static String getRequestParams(HttpServletRequest request) {
		if (request == null)
			return "";
		if (StringUtils.contains(StringUtils.trimToEmpty(getRequstURL(request)).toLowerCase(), "password")) {
			return "[密码相关请求不记录参数]";
		}
		Map map = new HashMap();
		Enumeration paramNames = request.getParameterNames();
		while (paramNames.hasMoreElements()) {
			String paramName = (String) paramNames.nextElement();
			String[] paramValues = request.getParameterValues(paramName);
			if (paramValues.length == 1) {
				String paramValue = paramValues[0];
				if (StringUtils.isNotBlank(paramValue)) {
					map.put(paramName, paramValue);
				}
			}
		}
		return map.toString();
	}
	
}
