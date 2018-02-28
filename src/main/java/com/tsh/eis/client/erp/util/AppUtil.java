package com.tsh.eis.client.erp.util;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

/**
 * 应用工具类
 * @author zengfa
 *
 */
public class AppUtil {

	public static Map<String,String> config = new HashMap<String,String>();
	
	static{
		String mainDb = PropertiesUtil.readKeyValue("config.properties", "mainDb");//主数据库名
		String chemicalsDb = PropertiesUtil.readKeyValue("config.properties", "chemicalsDb");//日化数据库
		String commonDb = PropertiesUtil.readKeyValue("config.properties", "commonDb");//商贸数据库
		String chemicalsSuppliers = PropertiesUtil.readKeyValue("config.properties", "chemicalsSuppliers");//日化供应商
		String commonSuppliers = PropertiesUtil.readKeyValue("config.properties", "commonSuppliers");//商贸供应商
		
		config.put("mainDb", mainDb);
		config.put("chemicalsDb", chemicalsDb);
		config.put("commonDb", commonDb);
		config.put("chemicalsSuppliers", chemicalsSuppliers);
		config.put("commonSuppliers", commonSuppliers);
	}
	
	public static void initConfig(){
		
	}
	
	/**
	 * 获得供应商对应的数据库
	 * @param supplierId
	 * @return
	 */
	public static String getSupplierDb(String supplierId){
		if(ischemicalsSupplier(supplierId)){
			return getChemicalsDb();
		}else{
			return getCommonDbDb();
		}
	}
	
	/**
	 * 获得主数据库
	 * @return
	 */
	public static String getMainDb(){
		return config.get("mainDb");
	}
	
	/**
	 * 获得日化数据库
	 * @return
	 */
	public static String getChemicalsDb(){
		return config.get("chemicalsDb");
	}
	
	/**
	 * 获得商贸数据库
	 * @return
	 */
	public static String getCommonDbDb(){
		return config.get("commonDb");
	}
	
	/**
	 * 判断是否是商贸供应商
	 * @param supplierId
	 * @return
	 */
	public static boolean isCommonSupplier(String supplierId){
		String commonSuppliers = config.get("commonSuppliers");
		return containsStr(commonSuppliers,supplierId);
	}
	
	/**
	 * 判断是否是日化供应商
	 * @param supplierId
	 * @return
	 */
	public static boolean ischemicalsSupplier(String supplierId){
		String chemicalsSuppliers = config.get("chemicalsSuppliers");
		return containsStr(chemicalsSuppliers,supplierId);
	}
	
	/**
	 * 判断str里是否包含str2
	 * @param str
	 * @param str2
	 * @return
	 */
	public static boolean containsStr(String str,String str2){
		if(StringUtils.isBlank(str)){
			return false;
		}
		String[] strArray = str.split(",");
		for(String s : strArray){
			if(s.equals(str2)){
				return true;
			}
		}
		return false;
	}
}
