package com.upwork.activity.util;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ScheduleUtils {
    public LocalDateTime getCurrentDateTime(){
        return LocalDateTime.now();
    }
}
