package com.upwork.activity.entity;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "attendance")
public class AttendanceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(nullable = false)
    private Integer userId;
    @Column(nullable = false)
    private Integer activityId;
}
