package com.homepage.proxy;

/**
 * 调用放caller
 */
public class Client {

    public static void main(String[] args) {
        Subject proxy = new Proxy(new SubjectImpl());
        proxy.request();
    }
}
