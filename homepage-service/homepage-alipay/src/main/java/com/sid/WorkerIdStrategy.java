package com.sid;

public interface WorkerIdStrategy {

    void initialize();

    long availableWorkerId();

    void release();
}
