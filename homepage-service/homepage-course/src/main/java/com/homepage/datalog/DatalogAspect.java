package com.homepage.datalog;

import com.homepage.entity.Action;
import com.homepage.entity.ActionType;
import com.homepage.entity.ChangeItem;
import com.homepage.util.DiffUtils;
import com.netflix.appinfo.InstanceInfo;
import org.apache.commons.beanutils.PropertyUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Aspect
@Component
public class DatalogAspect {

    private static final Logger logger = LoggerFactory.getLogger(DatalogAspect.class);

    /*@Autowired
    private ActionRepo actionRepo;
*/
    //保存和更新操作
    @Pointcut("execution(public * com.homepage.dao.*.save*(..))")
    public void save() {

    }
    //删除操作
    @Pointcut("execution(public * com.homepage.dao.*.delete*(..))")
    public void delete() {

    }

    @Around("save() || delete()")
    public Object addOperationLog(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("enter aspect");
        Object returnObj = null;
        Class<?> cls = pjp.getTarget().getClass();

        Object service = pjp.getTarget();
        //方法
        String methodName = pjp.getSignature().getName();
        //方法参数
        Object[] args = pjp.getArgs();
        ActionType actionType = null;
        Action action = new Action();
        Long id = null;
        Object oldObj = null;

        if ("save".equals(methodName)) {
            Object obj = pjp.getArgs()[0];
            try {
                id = Long.valueOf(PropertyUtils.getProperty(obj, "id").toString());
            } catch (Exception e) {

            }
            if (id == null) {
                actionType = ActionType.ADD;
                List<ChangeItem> changeItems = DiffUtils.getInsertChangeItems(obj);
                action.getChanges().addAll(changeItems);
                action.setObjectClass(obj.getClass().getName());
            } else {
                actionType = ActionType.UPDATE;
                action.setObjectId(id);
                oldObj = DiffUtils.getObjectById(pjp.getTarget(), id);
                action.setObjectClass(oldObj.getClass().getName());
            }
        } else if ("delete".equals(methodName)) {
            actionType = ActionType.DELETE;
            oldObj = DiffUtils.getObjectById(pjp.getTarget(), id);
            ChangeItem changeItem = DiffUtils.getDeleteChangeItem(oldObj);
            action.getChanges().add(changeItem);
            action.setObjectId(Long.valueOf(pjp.getArgs()[0].toString()));
            action.setObjectClass(oldObj.getClass().getName());
        }
        returnObj = pjp.proceed(pjp.getArgs());

        action.setActionType(actionType);
        if (ActionType.ADD == actionType) {
            Object newId = PropertyUtils.getIndexedProperty(returnObj, "id");
            action.setObjectId(Long.valueOf(newId.toString()));
        } else if (ActionType.UPDATE == actionType) {
            Object newObj = DiffUtils.getObjectById(pjp, id);
            List<ChangeItem> changeITems = DiffUtils.getChangeITems(oldObj, newObj);

            action.getChanges().addAll(changeITems);
        }
        action.setOpertor("admin");
        action.setOperateTime(new Date());
        //actionRepo.save(action);


        return null;

    }

}
