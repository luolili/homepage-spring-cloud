package com.homepage.proxy.dyn;

import com.homepage.proxy.Subject;
import com.homepage.proxy.SubjectImpl;

import java.lang.reflect.Proxy;

public class JdkClient {
    public static void main(String[] args) {
        Subject subject = (Subject) Proxy.newProxyInstance(JdkClient.class.getClassLoader(),
                new Class[]{Subject.class}, new JdkSubject(new SubjectImpl()));
        subject.helo();
        //subject.request();
    }
}
