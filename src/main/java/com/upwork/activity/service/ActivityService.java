package com.upwork.activity.service;


import com.upwork.activity.entity.ActivityEntity;

import java.util.List;


public interface ActivityService {

    ActivityEntity findActivityScheduledOrAboutToStart(String classRoomId);
}
