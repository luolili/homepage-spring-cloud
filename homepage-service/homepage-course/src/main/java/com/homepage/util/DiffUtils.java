package com.homepage.util;

import com.homepage.datalog.Datalog;
import com.homepage.entity.ChangeItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    public static String getValue(Object o) {
        if (o != null) {
            if (o instanceof Date) {
                return formatDate((Date) o);
            } else {
                return o.toString();
            }
        }
        return "";
    }

    //从注解读取中文名：filed name--ann name
    public static Map<String, String> getFieldNameMap(Class<?> cls) {
        Map<String, String> map = new HashMap<>();
        for (Field field : cls.getDeclaredFields()) {

            if (field.isAnnotationPresent(Datalog.class)) {
                Datalog annotation = field.getAnnotation(Datalog.class);
                map.put(field.getName(), annotation.name());
            }
        }
        return map;
    }
    public static String formatDate(Date date) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd 'T' HH:mm:ss");
        String text = df.format(date);
        String res = text.substring(0, 22) + ":" + text.substring(22);

        return res;

    }

    /**
     * 获取bean 的filed name and value
     *
     * @param bean       bean
     * @param filterNull
     * @return map
     */
    public static Map<String, String> getBeanSimpleFieldValueMap(Object bean, boolean filterNull) {
        Map<String, String> map = new HashMap<>();
        if (bean == null) {
            return map;
        }

        Class<?> clazz = bean.getClass();
        try {
            //不获取父类的字段
            Field[] fields = clazz.getDeclaredFields();
            for (int i = 0; i < fields.length; i++) {
                Class<?> fieldType = fields[i].getType();
                String name = fields[i].getName();
                Method method = clazz.getMethod("get" + name.substring(0, 1).toUpperCase() + name.substring(1));

                Object value = method.invoke(bean);
                if (filterNull && value == null) {
                    continue;
                }
                if (isBaseDataType(fieldType)) {
                    String stringValue = getFieldStringValue(fieldType, value);
                    map.put(name, stringValue);//field name--field val
                }

            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return map;

    }

    public static String getFieldStringValue(Class type, Object value) {
        if (type == Date.class) {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return format.format((Date) value);
        }
        return value.toString();
    }
    //判断一个类是否为基本数据类型或包装类，或日期。
    public static boolean isBaseDataType(Class clazz) {
        return (
                clazz.equals(String.class) ||
                        clazz.equals(Integer.class) ||
                        clazz.equals(Long.class) ||
                        clazz.equals(Float.class) ||
                        clazz.equals(Double.class) ||
                        clazz.equals(Short.class) ||
                        clazz.equals(Byte.class) ||
                        clazz.equals(Character.class) ||
                        clazz.equals(Boolean.class) ||
                        clazz.equals(BigInteger.class) ||
                        clazz.equals(BigDecimal.class) ||
                        clazz.equals(Date.class) ||
                        clazz.isPrimitive()


        );
    }

}
