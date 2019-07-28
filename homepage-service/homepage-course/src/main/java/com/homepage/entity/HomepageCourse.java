package com.homepage.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)//填充创建时间
@Table(name = "homepage_course")
public class HomepageCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Basic
    @Column(name = "course_name", nullable = false, unique = true)
    private String courseName;

    @Basic
    @Column(name = "course_intro", nullable = false)
    private String courseIntro;

    @Basic
    @Column(name = "course_icon", nullable = false)
    private String courseIcon;

    @Basic
    @Column(name = "course_type", nullable = false)
    private Integer courseType;

    @Basic
    @Column(name = "create_time", nullable = false)
    @CreatedDate
    private Date createTime;


    @Basic
    @Column(name = "update_time", nullable = false)
    @LastModifiedDate
    private Date updateTime;

    public HomepageCourse(String courseName, String courseIntro, String courseIcon, Integer courseType) {
        this.courseName = courseName;
        this.courseIntro = courseIntro;
        this.courseIcon = courseIcon;
        this.courseType = courseType;
    }

    public static HomepageCourse invalid() {
        HomepageCourse invalid =
                new HomepageCourse("", "", "", 0);

        invalid.setId(-1L);
        return invalid;
    }
}
