package com.upwork.activity.service;

import com.upwork.activity.dto.AttendanceInsertDTO;
import com.upwork.activity.dto.PositionDTO;
import com.upwork.activity.entity.ActivityEntity;
import com.upwork.activity.entity.AttendanceEntity;
import com.upwork.activity.entity.ClassRoonEntity;
import com.upwork.activity.exception.NotInClassroomException;
import com.upwork.activity.repository.ActivityRepository;
import com.upwork.activity.repository.AttendanceRepository;
import com.upwork.activity.service.impl.AttendanceServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


class AttendanceServiceTest {

    @Mock
    private AttendanceRepository attendanceRepository;

    @Mock
    private ActivityRepository activityRepository;

    @InjectMocks
    private AttendanceServiceImpl attendanceService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        ActivityEntity activityEntity = new ActivityEntity(
                2 ,
                LocalDateTime.now(),
                LocalDateTime.now(),
                new ClassRoonEntity("CR101", -15.54769602953542, -47.32817269552129));
        when(activityRepository.findById(2)).thenReturn(Optional.of(activityEntity));

    }

    @Test
    void testInsert() throws NotInClassroomException {
        Integer userId = 5;
        AttendanceInsertDTO dto = new AttendanceInsertDTO(2);
        PositionDTO position = new PositionDTO(-15.54769602953542, -47.32817269552129);
        dto.setPosition(position);
        attendanceService.insert(dto, userId);
        AttendanceEntity entity = dto.toEntity();
        entity.setUserId(userId);
        verify(attendanceRepository).save(entity);
    }
}