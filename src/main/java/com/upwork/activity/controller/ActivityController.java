package com.upwork.activity.controller;


import com.upwork.activity.entity.ActivityEntity;
import com.upwork.activity.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@RestController
@RequestMapping(value = "/activities")
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @GetMapping
    public List<ActivityEntity> listActivityItens() {
        return activityService.listAllActivity();
    }

    @GetMapping("/elegible")
    public ActivityEntity findElegibleActivity() {
        return activityService.findActivityScheduledOrAboutToStart();
    }
    
}


