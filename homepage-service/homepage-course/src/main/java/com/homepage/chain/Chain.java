package com.homepage.chain;

import java.util.List;

/**
 * 用来封装多个handler实现之间的关系
 */
public class Chain {
    List<ChainHandler> handlers;
    //游标
    private int index;

    public Chain(List<ChainHandler> handlers) {
        this.handlers = handlers;
    }

    public void proceed() {
        //-1 检查index的范围
        if (this.index >= this.handlers.size()) {
            return;
        }
        //遍历 的 调用handler实现的方法
        handlers.get(this.index++).execute(this);


    }
}
