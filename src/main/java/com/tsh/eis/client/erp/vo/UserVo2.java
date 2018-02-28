package com.tsh.eis.client.erp.vo;

import java.io.Serializable;
import java.util.Date;

public class UserVo2 implements Serializable{

	private Long id;
	
	private String userName;
	
	private String loginName;
	
	private Date createDate;
	
	private String roleName;
	
	private Integer status;
	
	public UserVo2(){
		
	}
	
	public UserVo2(Long id, String userName, String loginName, Date createDate, String roleName, Integer status) {
		super();
		this.id = id;
		this.userName = userName;
		this.loginName = loginName;
		this.createDate = createDate;
		this.roleName = roleName;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "UserVo2 [id=" + id + ", userName=" + userName + ", loginName=" + loginName + ", createDate="
				+ createDate + ", roleName=" + roleName + ", status=" + status + "]";
	}
	
}
