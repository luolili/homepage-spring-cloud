package com.homepage.chain;

public abstract class ChainHandler {

    //引入Chain ，借助他来完成链式调用
    public void execute(Chain chain) {
        //-1 本类的方法调用
        handleProcess();
        //-2 chain 完成链式调用
        chain.proceed();
    }

    protected abstract void handleProcess();

}
