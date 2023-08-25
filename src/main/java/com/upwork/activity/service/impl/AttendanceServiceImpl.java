package com.upwork.activity.service.impl;


import com.upwork.activity.dto.AttendanceInsertDTO;
import com.upwork.activity.dto.PositionDTO;
import com.upwork.activity.entity.ActivityEntity;
import com.upwork.activity.entity.AttendanceEntity;
import com.upwork.activity.exception.NotInClassroomException;
import com.upwork.activity.repository.ActivityRepository;
import com.upwork.activity.repository.AttendanceRepository;
import com.upwork.activity.service.AttendanceService;
import com.upwork.activity.util.DistanceCalculatorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AttendanceServiceImpl implements AttendanceService {

    // TODO Move to properties file
    private double mimDistanceInMt = 30;

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Autowired
    private ActivityRepository activityRepository;

    @Override
    public void insert(AttendanceInsertDTO attendanceInsertDTO, Integer userId)throws NotInClassroomException {
        validateDistance(attendanceInsertDTO);
        AttendanceEntity entity = attendanceInsertDTO.toEntity();
        entity.setUserId(userId);
        attendanceRepository.save(entity);
    }

    //Calculate the distance between the class room and the student to make sure he/she is indeed in the class
    private void validateDistance(AttendanceInsertDTO attendanceInsertDTO) throws NotInClassroomException {
        Optional<ActivityEntity> activity =  activityRepository.findById(attendanceInsertDTO.getActivityId());
        PositionDTO position = attendanceInsertDTO.getPosition();

        double distance = DistanceCalculatorUtil.calculateDistance(position.getLatitude(),
                position.getLngitude(),
                activity.get().getClassRoom().getLatitude(),
                activity.get().getClassRoom().getLongitude());

        //if the distance is higher of the mimDistanceInMt, the student is not in the class
        if(distance > mimDistanceInMt){
            throw new NotInClassroomException();
        }
    }
}
