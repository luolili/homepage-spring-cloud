package com.homepage.datalog;

import com.netflix.appinfo.InstanceInfo;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Aspect
@Component
public class DatalogAspect {

    private static final Logger logger = LoggerFactory.getLogger(DatalogAspect.class);


    @Autowired
    private ActionRepo actionRepo;

    //八村和更新操作
    @Pointcut("execution(public * com.homepage.dao.*.save*(..))")
    public void save() {

    }

    //删除操作
    @Pointcut("execution(public * com.homepage.dao.*.delete*(..))")
    public void delete() {

    }

    @Around("save() || delete()")
    public Object addOperationLog(ProceedingJoinPoint pjp) {
        System.out.println("enter aspect");
        Class<?> cls = pjp.getTarget().getClass();

        Object service = pjp.getTarget();
        //方法
        String methodName = pjp.getSignature().getName();
        //方法参数
        Object[] args = pjp.getArgs();
        InstanceInfo.ActionType actionType = null;

        Object returnObj = null;
        try {
            Object obj = args[0];
            String objectClass = obj.getClass().getName();

            Date operationTime = new Date();

        } catch (Exception e) {

        }

        return null;

    }

}
