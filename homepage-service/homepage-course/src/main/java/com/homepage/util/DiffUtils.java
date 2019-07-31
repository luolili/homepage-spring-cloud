package com.homepage.util;

import com.homepage.entity.ChangeItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiffUtils {
    //log
    private static final Logger logger = LoggerFactory.getLogger(DiffUtils.class);

    //静态方法
    public static Object getObjectById(Object target, Object id) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //通过obj获取到他的Class,通过Class获取到指定的方法
        Method findMethod = target.getClass().getDeclaredMethod("findById", Long.class);
        //通过Method.invoke获取方法所属的类对象
        Object oldObj = findMethod.invoke(target, id);
        return oldObj;

    }

    public static List<ChangeItem> getInsertChangeItems(Object obj) {


        return null;
    }


    /**
     * 获取bean 的filed name and value
     *
     * @param bean       bean
     * @param filterNull
     * @return
     */
    public static Map<String, String> getBeanSimpleFieldValueMap(Object bean, boolean filterNull) {


        Map<String, String> map = new HashMap<>();

        if (bean == null) {
            return map;
        }

        Class<?> clazz = bean.getClass();
        try {
            //不获取父类的i段
            Field[] fields = clazz.getDeclaredFields();
            for (int i = 0; i < fields.length; i++) {

                Class<?> fieldType = fields[i].getType();
                String name = fields[i].getName();
                Method method = clazz.getMethod("get" + name.substring(0, 1).toUpperCase() + name.substring(1));

                Object value = method.invoke(bean);
                if (filterNull && value == null) {
                    continue;
                }


            }
        } catch (Exception e) {

        }


    }



}
