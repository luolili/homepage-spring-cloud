package com.homepage.chain;

public class Client {

    static class HandlerA extends Handler {
        @Override
        protected void handleProcess() {
            System.out.println("handler by a");

        }
    }

    static class HandlerB extends Handler {
        @Override
        protected void handleProcess() {
            System.out.println("handler by b");

        }
    }

    static class HandlerC extends Handler {
        @Override
        protected void handleProcess() {
            System.out.println("handler by c");

        }
    }

    public static void main(String[] args) {
        HandlerA handlerA = new HandlerA();
        HandlerB handlerB = new HandlerB();
        HandlerC handlerC = new HandlerC();

        //设置后面的人
        handlerA.setSucessor(handlerB);
        handlerB.setSucessor(handlerC);
        //实现链式 调用
        handlerA.execute();
    }
}
