package com.homepage.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class Action {

    private String id;
    private Long objectId;
    private String objectClass;//Product.class
    private String opertor;

    private Date operateTime;
    private ActionType actionType;

    private List<ChangeItem> changes = new ArrayList<>();

}
