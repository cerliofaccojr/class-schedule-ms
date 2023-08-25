package com.upwork.activity.controller;


import com.upwork.activity.dto.AttendanceInsertDTO;
import com.upwork.activity.exception.NotInClassroomException;
import com.upwork.activity.service.AttendanceService;
import com.upwork.activity.util.ValidationErrorResponse;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Base64;


@RestController
@RequestMapping(value = "/attendancies")
public class AttendanceController {
    @Autowired
    private AttendanceService attendanceService;

    @PostMapping
    public ResponseEntity<ValidationErrorResponse> insertAttendance(@RequestHeader("Authorization") String bearerToken,
                                                   @Valid @RequestBody AttendanceInsertDTO attendanceInsertDTO,
                                                   BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            ValidationErrorResponse errorResponse = new ValidationErrorResponse();
            bindingResult.getAllErrors().forEach(error -> errorResponse.addValidationError(error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(errorResponse);
        }

        try {

            attendanceService.insert(attendanceInsertDTO, getUserFromToken(bearerToken));
        } catch (NotInClassroomException e) {
            ValidationErrorResponse errorResponse = new ValidationErrorResponse();
            errorResponse.addValidationError(e.getMessage());
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public static int getUserFromToken(String bearerToken) {
        String[] chunks = bearerToken.split("\\.");
        Base64.Decoder decoder = Base64.getUrlDecoder();
        String body = new String(decoder.decode(chunks[1]));
        JSONObject json = new JSONObject(body);
        return json.getInt("sub");
    }
}


