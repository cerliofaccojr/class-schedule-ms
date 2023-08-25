package com.upwork.activity.service.impl;


import com.upwork.activity.entity.ActivityEntity;
import com.upwork.activity.repository.ActivityRepository;
import com.upwork.activity.service.ActivityService;
import com.upwork.activity.util.ScheduleUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class ActivityServiceImpl implements ActivityService {


    private Integer timeBuffer = 15;

    @Autowired
    private ActivityRepository activityRepository;

    @Autowired
    private ScheduleUtils scheduleUtils;

    @Override
    public List<ActivityEntity> listAllActivity(){
        return activityRepository.findAll();
    }

    @Override
    //Find the activity that is taking place. The student is able to checking in the activity
    // if it is between 15 minutos earlier or 15 minutes later the start date of the activity(Defined in variable 'timeBuffer')
    public ActivityEntity findActivityScheduledOrAboutToStart() {
        LocalDateTime now = scheduleUtils.getCurrentDateTime();
        LocalDateTime startDate = now.minus(timeBuffer, ChronoUnit.MINUTES);
        LocalDateTime endDate = now.plus(timeBuffer, ChronoUnit.MINUTES);
        List<ActivityEntity> activities = activityRepository.findActivitiesScheduledOrAboutToStart(startDate,endDate);
        return CollectionUtils.isEmpty(activities) ? null : activities.get(0);
    }
}
