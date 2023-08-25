package com.upwork.activity.dto;

import com.upwork.activity.entity.AttendanceEntity;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class AttendanceInsertDTO {

    @NotNull(message = "Field 'activityId' is mandatory")
    private Integer activityId;
    @NotNull(message = "Field 'position' is mandatory")
    private PositionDTO position;

    public AttendanceInsertDTO() {
        super();
    }

    public AttendanceInsertDTO(Integer activityId) {
        this.activityId = activityId;
    }

    public AttendanceEntity toEntity() {
        AttendanceEntity attendanceEntity = new AttendanceEntity();
        attendanceEntity.setActivityId(activityId);
        return attendanceEntity;
    }
}
