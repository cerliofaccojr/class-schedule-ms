package com.upwork.activity.service;


import com.upwork.activity.dto.AttendanceInsertDTO;
import com.upwork.activity.exception.NotInClassroomException;


public interface AttendanceService {

    void insert(AttendanceInsertDTO attendanceInsertDTO,  Integer userId) throws NotInClassroomException;
}
