package com.tsh.eis.client.erp.util;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.dozer.MappingException;

public class BeanMapperUtil {
    
    /**
     * 对象复制
     */
    private static DozerBeanMapper mapper;

    private synchronized static Mapper getMapper() {
        if (mapper == null) {
            mapper = new DozerBeanMapper();
            List<String> mappingFiles = new ArrayList<String>();
            mappingFiles.add("dozerBeanMapping.xml");
            mapper.setMappingFiles(mappingFiles);
        }

        return mapper;
    }

    /**
     * 对象值复制..
     * 
     * @param source
     * @param destinationClass
     * @return 复制后的对象.
     */
    public static <T> T map(Object source, Class<T> destinationClass) throws MappingException {
        if (source == null) {
            return null;
        }
        return getMapper().map(source, destinationClass);
    }

    /**
     * 复制一个对象列表...
     * 
     * @param sources
     * @param destinationClass
     * @return
     * @throws MappingException
     */
    public static <T> List<T> map(List<? extends Object> sources, Class<T> destinationClass) throws MappingException {
    	if(null == sources || null == destinationClass){
    		return null;
    	}
        List<T> rtn = new ArrayList<T>();
        for (Object s : sources) {
            T temp = getMapper().map(s, destinationClass);
            rtn.add(temp);
        }
        return rtn;
    }

    /**
     * 对象值复制.
     * 
     * @param source 复制源对象.
     * @param destination 复制输出对象.
     */
    public static void map(Object source, Object destination) throws MappingException {
        if (source == null) {
            return;
        }

        getMapper().map(source, destination);
    }
}
