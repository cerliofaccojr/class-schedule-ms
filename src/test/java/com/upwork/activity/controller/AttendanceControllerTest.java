package com.upwork.activity.controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AttendanceControllerTest {

    @Test
    void testGetUserFromToken() {
        String bearerToken =  "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c";
        Integer userId = AttendanceController.getUserFromToken(bearerToken);
        assertEquals(1234567890, userId);
    }
}