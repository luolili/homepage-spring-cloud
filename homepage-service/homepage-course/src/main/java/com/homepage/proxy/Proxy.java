package com.homepage.proxy;

/**
 * 代理对象，需要引用Subject 的实现, 以便具有执行方法的能力
 */
public class Proxy implements Subject {
    private SubjectImpl subjectImpl;

    public Proxy(SubjectImpl subjectImpl) {
        this.subjectImpl = subjectImpl;
    }

    @Override
    public void request() {
        System.out.println("before something");
        try {
            subjectImpl.request();
        } catch (Exception e) {
            System.out.println("ex: " + e.getMessage());
        } finally {
            System.out.println("after something");
        }
    }

    @Override
    public void helo() {
        System.out.println("before something");
        try {
            subjectImpl.helo();
        } catch (Exception e) {
            System.out.println("ex: " + e.getMessage());
        } finally {
            System.out.println("after something");
        }
    }
}
