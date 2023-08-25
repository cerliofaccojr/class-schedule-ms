package com.upwork.activity.entity;


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "activity")
public class ActivityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private LocalDateTime  startDate;

    @Column(nullable = false)
    private LocalDateTime endDate;

    @ManyToOne
    @JoinColumn(name="CLASS_ROOM_ID", referencedColumnName = "id", nullable=false)
    private ClassRoonEntity classRoom;

    public ActivityEntity(){
        super();
    }

    public ActivityEntity(Integer id, LocalDateTime  startDate, LocalDateTime endDate, String classRoomId){
        this(id, startDate, endDate, new ClassRoonEntity(classRoomId));

    }

    public ActivityEntity(int id, LocalDateTime startDate, LocalDateTime endDate, ClassRoonEntity classRoonEntity) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.classRoom = classRoonEntity;
    }
}
