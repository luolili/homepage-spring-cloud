package com.homepage.entity;

import com.homepage.datalog.Datalog;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 用于aop
 * 实战：商品管理系统；记录商品的操作
 * domain:
 * Action: id, objectId, objectClass, operator, operatorTime, changes, actionType
 * ChangeItem: field, fieldName, oldVal, newVal
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Datalog(name = "产品名称")
    private String name;

    private String category;
    private String detail;
    private BigDecimal buyPrice;
    private BigDecimal sellPrice;
    private String provider;

    private Date onlineTime;
    private Date updateTime;
}
