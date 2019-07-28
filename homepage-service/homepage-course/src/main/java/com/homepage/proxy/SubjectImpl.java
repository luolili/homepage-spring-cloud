package com.homepage.proxy;

public class SubjectImpl implements Subject {
    @Override
    public void request() {
        System.out.println("real subject  exec request");
    }
}
