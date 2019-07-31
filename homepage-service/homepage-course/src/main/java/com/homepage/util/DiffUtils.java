package com.homepage.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class DiffUtils {
    //log
    private static final Logger logger = LoggerFactory.getLogger(DiffUtils.class);

    public Object getObjectById(Object target, Object id) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //通过obj获取到他的Class,通过Class获取到指定的方法
        Method findMethod = target.getClass().getDeclaredMethod("findById", Long.class);
        //通过Method.invoke获取方法所属的类对象
        Object oldObj = findMethod.invoke(target, id);
        return oldObj;

    }


}
