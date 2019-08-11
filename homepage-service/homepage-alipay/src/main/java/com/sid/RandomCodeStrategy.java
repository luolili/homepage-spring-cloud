package com.sid;

public interface RandomCodeStrategy {

    void init();

    void prefix();

    void next();

    void release();
}
