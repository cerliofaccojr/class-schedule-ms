package com.upwork.activity.repository;

import com.upwork.activity.entity.ActivityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ActivityRepository extends JpaRepository<ActivityEntity, Integer> {

    @Query("SELECT a FROM ActivityEntity a " +
            "WHERE a.startDate BETWEEN :startDate and :endDate ")
    List<ActivityEntity> findActivitiesScheduledOrAboutToStart(LocalDateTime startDate, LocalDateTime endDate);
}
