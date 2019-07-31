package com.homepage.entity;

import lombok.Data;

@Data
public class ChangeItem {

    private String field;
    private String fieldName;

    private String oldValue;
    private String newValue;
}
