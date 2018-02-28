package com.tsh.eis.client.erp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsh.eis.client.erp.dao.UserDao;
import com.tsh.eis.client.erp.vo.Result;
import com.tsh.eis.client.erp.vo.UserVo;

@Service
public class UserService {

	@Autowired private UserDao userDao;
	
	public void save(Result result,UserVo userVo,String type){
		userDao.save(result, userVo);
	}
	
	public void del(Result result,Long userId){
		userDao.deleteById(result, userId);
	}
}
