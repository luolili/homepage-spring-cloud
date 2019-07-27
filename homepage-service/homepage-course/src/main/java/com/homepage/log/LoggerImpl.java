package com.homepage.log;

import org.springframework.stereotype.Service;

@Service
public class LoggerImpl implements Logger {
    @Override
    public void log() {
        System.out.println("logger service impl");
    }
}
