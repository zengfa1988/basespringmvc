package com.tsh.eis.client.erp.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tsh.eis.client.erp.service.UserService;
import com.tsh.eis.client.erp.util.ResultUtil;
import com.tsh.eis.client.erp.vo.Pagination;
import com.tsh.eis.client.erp.vo.Result;
import com.tsh.eis.client.erp.vo.UserVo;
import com.tsh.eis.client.erp.vo.UserVo2;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController{

	@Autowired private UserService userService;
	
	@ResponseBody
	@RequestMapping(value = "/add",method=RequestMethod.POST)
	public String add(UserVo userVo){
//		Result result = getResult();
		Result result = ResultUtil.getResult(request);
		userService.save(result,userVo,"add");
//		this.send(result);
		return "success";
	}
	
	@ResponseBody
	@RequestMapping(value = "/del")
	public String del(Long userId){
//		Result result = getResult();
		Result result = ResultUtil.getResult(request);
		userService.del(result, userId);
//		this.send(result);
		return "success";
	}
	
	@ResponseBody
	@RequestMapping(value = "/query")
	public Pagination query(){
		List<UserVo2> list = new ArrayList<UserVo2>();
		list.add(new UserVo2(1l, "暮雨迟", "m13714522589", new Date(), "会员", 1));
		list.add(new UserVo2(2l, "暮雨迟", "m13714522589", new Date(), "会员", 1));
		list.add(new UserVo2(3l, "暮雨迟", "m13714522589", new Date(), "会员", 1));
		list.add(new UserVo2(4l, "暮雨迟", "m13714522589", new Date(), "会员", 1));
		list.add(new UserVo2(5l, "暮雨迟", "m13714522589", new Date(), "会员", 1));
		list.add(new UserVo2(6l, "暮雨迟", "m13714522589", new Date(), "会员", 1));
		list.add(new UserVo2(7l, "暮雨迟", "m13714522589", new Date(), "会员", 1));
		list.add(new UserVo2(8l, "暮雨迟", "m13714522589", new Date(), "会员", 1));
		list.add(new UserVo2(9l, "暮雨迟", "m13714522589", new Date(), "会员", 1));
		list.add(new UserVo2(10l, "暮雨迟", "m13714522589", new Date(), "会员", 1));
		list.add(new UserVo2(11l, "暮雨迟", "m13714522589", new Date(), "会员", 1));
		list.add(new UserVo2(12l, "暮雨迟", "m13714522589", new Date(), "会员", 1));
		Pagination page = Pagination.createPagination(list.size(), list);
		return page;
	}
}
