package com.homepage.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Flow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String flowNum;

    private String orderNum;

    private String productId;

    private String paidAmount;

    private Integer paidMethod;

    private Integer buyCounts;

    private Date createTime;
}
