package com.homepage.proxy.dyn;

import com.homepage.proxy.SubjectImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class JdkSubject implements InvocationHandler {
    private SubjectImpl subjectImpl;

    public JdkSubject(SubjectImpl subjectImpl) {
        this.subjectImpl = subjectImpl;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before something");
        Object result = null;
        try {
            result = method.invoke(subjectImpl, args);
        } catch (Exception e) {
            System.out.println("ex: " + e.getMessage());
        } finally {
            System.out.println("after something");
        }

        return result;
    }

}
