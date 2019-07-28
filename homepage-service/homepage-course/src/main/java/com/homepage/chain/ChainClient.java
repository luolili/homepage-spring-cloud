package com.homepage.chain;

import java.util.Arrays;
import java.util.List;

public class ChainClient {
    static class ChainHandlerA extends ChainHandler {
        @Override
        protected void handleProcess() {
            System.out.println("chain handler by a");

        }
    }

    static class ChainHandlerB extends ChainHandler {
        @Override
        protected void handleProcess() {
            System.out.println("chain handler by b");

        }
    }

    static class ChainHandlerC extends ChainHandler {
        @Override
        protected void handleProcess() {
            System.out.println("chain handler by c");

        }
    }

    public static void main(String[] args) {
        Client.HandlerA handlerA = new Client.HandlerA();
        Client.HandlerB handlerB = new Client.HandlerB();
        Client.HandlerC handlerC = new Client.HandlerC();

        List<ChainHandler> handlers = Arrays.asList(
                new ChainHandlerA(),
                new ChainHandlerB(),
                new ChainHandlerC()
        );
        Chain chain = new Chain(handlers);
        chain.proceed();


    }
}

