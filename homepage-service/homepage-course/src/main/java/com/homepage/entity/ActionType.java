package com.homepage.entity;

import lombok.Data;

//@Data
public enum ActionType {
    ADD("添加", 1),
    UPDATE("更新", 2),
    DELETE("删除", 3),
    ;


    private String name;
    private int index;

    ActionType(String name, int index) {
        this.name = name;
        this.index = index;
    }
}
