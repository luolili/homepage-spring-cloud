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
        return null;
    }
}
