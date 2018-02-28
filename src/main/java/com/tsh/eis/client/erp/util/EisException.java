package com.tsh.eis.client.erp.util;

public class EisException extends Exception{
	
	private static final long serialVersionUID = 1L;
	public static final int UNKNOWN = 0;
	public static final int SYS_ERR = 1;
	public static final int CLIENT_INFO = 2;
	public static final int CLIENT_ALERT = 3;
	public static final int CLIENT_ERR = 4;
	public static final int PARAM_ERR = 5;
	public static final int IO_ERR = 6;
	public static final int SYS_DATA_ERR = 7;
	public static final int CLIENT_DATA_ERR = 8;
	public static final int SQL_ERR = 9;
	public static final int RECORD_NOT_FOUND = 10;
	public static final int DUPLICATE_KEY = 11;
	public static final int COL_VALUE_NULL = 12;
	public static final int RUNTIME_ERR = 13;

	/**
	 * 异常类型
	 */
	private Integer type;
	
	/**
	 * 错误信息
	 */
	private String errorInfo;
	
	/**
	 * 源异常
	 */
	private Throwable originException;

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getErrorInfo() {
		return errorInfo;
	}

	public void setErrorInfo(String errorInfo) {
		this.errorInfo = errorInfo;
	}
	
	public Throwable getOriginException() {
		return originException;
	}

	public void setOriginException(Throwable originException) {
		this.originException = originException;
	}

	public EisException(){
		super();
	}

	public EisException(Integer type, String errorInfo) {
		this.type = type;
		this.errorInfo = errorInfo;
	}
	
	public EisException(Integer type, String errorInfo,Throwable originException) {
		this.type = type;
		this.errorInfo = errorInfo;
		this.originException = originException;
	}
	
	public String getTypeName(){
		String str = "";
		switch (this.type){
			case 0:
				str = ""; break;
			case 1:
				str = "系统错误："; break;
			case 2:
				str = "提示："; break;
			case 3:
				str = "警告："; break;
			case 4:
				str = "错误："; break;
			case 5:
				str = "参数错误："; break;
			case 6:
				str = "输入输出错误："; break;
			case 7:
				str = "系统数据错误："; break;
			case 8:
				str = "数据输入错误："; break;
			case 9:
				str = "数据库操作错误："; break;
			case 10:
				str = "数据库记录未找到："; break;
			case 11:
				str = "主键重复："; break;
			case 12:
				str = "值不充许为空："; break;
			case 13:
				str = "运行时错误："; break;
		}
		return str;
	}

	@Override
	public String getMessage() {
		return this.getTypeName()+this.errorInfo;
	}
	
}
