package com.upwork.activity.controller;


import com.upwork.activity.entity.ActivityEntity;
import com.upwork.activity.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(value = "/activities")
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @GetMapping("/elegible")
    public ResponseEntity findElegibleActivity(@RequestParam Optional<String> classRoomId) {
        if(classRoomId.isPresent()) {
            ActivityEntity activity = activityService.findActivityScheduledOrAboutToStart(classRoomId.get());
            return ResponseEntity.ok(activity);
        }
        return ResponseEntity.badRequest().body("Parameter 'classRoomId' is mandatory");
    }
    
}


