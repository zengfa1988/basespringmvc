package com.tsh.eis.client.erp.aop;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSON;
import com.tsh.eis.client.erp.util.RequestUtil;
import com.tsh.eis.client.erp.util.ResultUtil;
import com.tsh.eis.client.erp.util.UserUtil;
import com.tsh.eis.client.erp.vo.LogResult;
import com.tsh.eis.client.erp.vo.LogResultApi;
import com.tsh.eis.client.erp.vo.Result;
import com.tsh.eis.client.erp.vo.UserInfo;

@Aspect
@Component
public class TshLogAspect {

	@Pointcut("execution(* *..controller*..*(..))")
	public void controllerPointcutExpression(){
		
	}
	
	@Pointcut("execution(* *..service*..*(..)) || execution(* *..api*..*(..)) || execution(* *..dao*..*(..))")
	public void pointcutExpression(){
		
	}
	
	@Before("controllerPointcutExpression()")
	public void beforeControllerMethod(JoinPoint joinPoint){
//		String method = joinPoint.getSignature().getName();
//		String cls = joinPoint.getSignature().getDeclaringTypeName();
//		String classMethod = cls + "." + method;
//		String api = cls.substring(cls.lastIndexOf(".") + 1, cls.length());
//		Object[] paramArr = joinPoint.getArgs();
//		if(ArrayUtils.isEmpty(paramArr)){//没有参数的不记录
//			return;
//		}
//		Result result = null;
		/*
		int paramsIndex = 0;
		if(paramArr[0] instanceof Result){
			if(paramArr.length==1){
				return;
			}
			paramsIndex = 1;
			result = (Result)paramArr[0];
		}
		LogResult logResult = result.getLogResult();
		String params = JSON.toJSONString(ArrayUtils.subarray(paramArr, paramsIndex, paramArr.length));
		LogResultApi logResultApi = new LogResultApi(method, api, classMethod, params);
		logResult.beforePutApi(logResultApi);
		*/
		
		String teamName = "eis";
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		UserInfo userInfo = UserUtil.getUserInfo(request);
		LogResult logResult = new LogResult(teamName, RequestUtil.getRequstURL(request), RequestUtil.getClientIp(request),RequestUtil.getRequestParams(request),userInfo);
		Result result = ResultUtil.getResult(request);
		result.setLogResult(logResult);
//		System.out.println(logResultApi.getContent());
	}
	
	@After("controllerPointcutExpression()")
	public void afterControllerMethod(JoinPoint joinPoint) {
		Date endDate = new Date();
		
		String method = joinPoint.getSignature().getName();
		String cls = joinPoint.getSignature().getDeclaringTypeName();
		String classMethod = cls + "." + method;
		String api = cls.substring(cls.lastIndexOf(".") + 1, cls.length());
		Object[] paramArr = joinPoint.getArgs();
		if(ArrayUtils.isEmpty(paramArr)){//没有参数的不记录
			return;
		}
//		Result result = null;
//		if(paramArr[0] instanceof Result){
//			if(paramArr.length==1){
//				return;
//			}
//			result = (Result)paramArr[0];
//		}
		
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		Result result = ResultUtil.getResult(request);
		int status = 0;
		String message = "";
		if(result!=null){
			result.getStatus();
			message = result.getMsg();
		}
		LogResult logResult = result.getLogResult();
		logResult.colse(status, message);
		Logger logger = Logger.getLogger(cls);
		logger.info(logResult.getContent());
//		LogResultApi logResultApi = new LogResultApi(method, api, classMethod,status,message,endDate);
//		logResult.afterPutApi(logResultApi);
		
	}
	
	@Before("pointcutExpression()")
	public void beforeMethod(JoinPoint joinPoint){
		String method = joinPoint.getSignature().getName();
		String cls = joinPoint.getSignature().getDeclaringTypeName();
		String classMethod = cls + "." + method;
		String api = cls.substring(cls.lastIndexOf(".") + 1, cls.length());
		Object[] paramArr = joinPoint.getArgs();
		if(ArrayUtils.isEmpty(paramArr)){//没有参数的不记录
			return;
		}
		Result result = null;
		int paramsIndex = 0;
		if(paramArr[0] instanceof Result){
			if(paramArr.length==1){
				return;
			}
			paramsIndex = 1;
			result = (Result)paramArr[0];
		}
		LogResult logResult = result.getLogResult();
		String params = JSON.toJSONString(ArrayUtils.subarray(paramArr, paramsIndex, paramArr.length));
		LogResultApi logResultApi = new LogResultApi(method, api, classMethod, params);
		logResult.beforePutApi(logResultApi);
		
//		System.out.println(logResultApi.getContent());
	}
	
	@After("pointcutExpression()")
	public void afterMethod(JoinPoint joinPoint) {
		Date endDate = new Date();
		
		String method = joinPoint.getSignature().getName();
		String cls = joinPoint.getSignature().getDeclaringTypeName();
		String classMethod = cls + "." + method;
		String api = cls.substring(cls.lastIndexOf(".") + 1, cls.length());
		Object[] paramArr = joinPoint.getArgs();
		if(ArrayUtils.isEmpty(paramArr)){//没有参数的不记录
			return;
		}
		Result result = null;
		if(paramArr[0] instanceof Result){
			if(paramArr.length==1){
				return;
			}
			result = (Result)paramArr[0];
		}
		int status = 0;
		String message = "";
		if(result!=null){
			result.getStatus();
			message = result.getMsg();
		}
		LogResult logResult = result.getLogResult();
		LogResultApi logResultApi = new LogResultApi(method, api, classMethod,status,message,endDate);
		logResult.afterPutApi(logResultApi);
		
	}
}
