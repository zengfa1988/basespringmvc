package com.tsh.eis.client.erp.util;

import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.tsh.eis.client.erp.vo.Result;
import com.tsh.eis.client.erp.vo.UserInfo;

public class ResultUtil {

	public static Result getResult(HttpServletRequest request){
//		HttpSession session = request.getSession();
//		ServletContext app = session.getServletContext();
//		String resultId = null;
		Result result = null;
		if(request.getAttribute("result")!=null){
			result = (Result)request.getAttribute("result");
//			resultId = (String)request.getAttribute("resultId");
//			result = (Result)app.getAttribute("resultId_"+resultId);
		}else{
//			resultId = UUID.randomUUID().toString().replace("-", "");
			UserInfo userInfo = UserUtil.getUserInfo(request);
			result = new Result(request,"eis",userInfo);
			request.setAttribute("result", result);
//			app.setAttribute("resultId_"+resultId, result);
		}
		
//		session.setAttribute("resultId", resultId);
//		session.setAttribute("resultId_"+resultId, result);
		return result;
	}
}
