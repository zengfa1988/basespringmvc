package com.tsh.eis.client.erp.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

public class DateUtil {

	private static String DATE_PATTERN="yyyy-MM-dd HH:mm:ss";
	
	public static String formatDateToString(Date date,String pattern){
		if(pattern==null){
			pattern = DATE_PATTERN;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(date).toString();
	}
	
	public static String formatDateToString(Date date){
		return formatDateToString(date,null);
	}
	
	/**
	 * 获得当前年月字符串
	 * 201706
	 * @return
	 */
	public static String formateNowYM(){
		return formatDateToString(new Date(),"yyyyMM");
	}
	
	public static void main(String[] args) {
//		String s = DateUtil.formatDateToString(new Date(), "yyyy-MM-dd 00:00:00.000");
//		System.out.println(s);
		
//		Double d = 0.0;
//		if(d!=0.00){
//			System.out.println(111);
//		}else{
//			System.out.println(222);
//		}
		
//		String codePre = "201206";
//		String maxCode = "";
//		
//		Integer voucher = 0;
//		if(StringUtils.isNotBlank(maxCode)&&maxCode.length()>codePre.length()){
//			voucher = Integer.parseInt(maxCode.substring(codePre.length()));
//		}
//		voucher++;
//		String voucherStr = String.format("%05d", voucher);
//		System.out.println(codePre+voucherStr);
	}
}
