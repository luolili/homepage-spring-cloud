package com.homepage.entity;

import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class OperationLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    private Date createdAt;

    @PrePersist
    public void settingTime() {
        this.createdAt = new Date();
    }
}
