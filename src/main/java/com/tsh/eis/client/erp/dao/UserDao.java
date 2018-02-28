package com.tsh.eis.client.erp.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tsh.eis.client.erp.vo.Result;
import com.tsh.eis.client.erp.vo.UserVo;

@Repository
public class UserDao{

	@Autowired private SessionFactory sessionFactory;
	
	public void save(Result result,UserVo userVo){
//		sessionFactory.getCurrentSession().save(object);
	}
	
	public void deleteById(Result result,Long userId){
		
	}
}
