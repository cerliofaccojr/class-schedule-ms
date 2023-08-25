package com.upwork.activity.entity;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "classroom")
public class ClassRoonEntity {

    @Id
    private String id;
    @Column(nullable = false)
    private Double latitude;
    @Column(nullable = false)
    private Double longitude;

    public ClassRoonEntity() {
        super();
    }
    public ClassRoonEntity(String id) {
        this.id = id;
    }

    public ClassRoonEntity(String id, Double latitude, Double longitude) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
