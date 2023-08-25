package com.upwork.activity.util;

import com.upwork.activity.exception.NotInClassroomException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DistanceCalculatorUtilTest {

    @Test
    void testCalculateDistance() throws NotInClassroomException {
        double distance = DistanceCalculatorUtil.calculateDistance(-15.54769602953542, -47.32817269552129, -15.547999656436742, -47.32842616427606);
        Assertions.assertEquals(43, Double.valueOf(distance).intValue());
    }
}