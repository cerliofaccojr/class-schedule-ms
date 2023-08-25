package com.upwork.activity.service;

import com.upwork.activity.entity.ActivityEntity;
import com.upwork.activity.repository.ActivityRepository;
import com.upwork.activity.service.impl.ActivityServiceImpl;
import com.upwork.activity.util.ScheduleUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;


class ActivityServiceTest {

    @Mock
    private ActivityRepository activityRepository;

    @Mock
    private ScheduleUtils scheduleUtils;

    @InjectMocks
    private ActivityServiceImpl activityService;


    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        //Simulate now
        LocalDateTime now = LocalDateTime.of(2023, 8, 24,17, 10, 00);
        when(scheduleUtils.getCurrentDateTime()).thenReturn(now);
    }

    @Test
    void testListAllActivity() {
        when(activityRepository.findAll()).thenReturn(getActivityEntities());
        List<ActivityEntity> result = activityService.listAllActivity();
        assertEquals(2, result.size());
    }

    @Test
    void testFindActivityScheduledOrAboutToStart() {
        LocalDateTime now = scheduleUtils.getCurrentDateTime();
        LocalDateTime startDate = now.minus(15, ChronoUnit.MINUTES);
        LocalDateTime endDate = now.plus(15, ChronoUnit.MINUTES);
        when(activityRepository.findActivitiesScheduledOrAboutToStart(startDate, endDate)).thenReturn(getActivityEntities());
        ActivityEntity result = activityService.findActivityScheduledOrAboutToStart();
        assertNotNull(result);
        assertEquals("CR101", result.getClassRoom().getId());
    }

    private static List<ActivityEntity> getActivityEntities() {
        List<ActivityEntity> expectedActivities = new ArrayList<>();

        ActivityEntity activity1 = new ActivityEntity(1,
                LocalDateTime.of(2023, 8, 24, 17, 00, 00),
                LocalDateTime.of(2023, 8, 24, 18, 30, 00),
                "CR101");

        ActivityEntity activity2 = new ActivityEntity(1,
                LocalDateTime.of(2023, 9, 24, 14, 00, 00),
                LocalDateTime.of(2023, 9, 24, 15, 00, 00),
                "CR101");

        expectedActivities.add(activity1);
        expectedActivities.add(activity2);
        return expectedActivities;
    }
}