package com.upwork.activity.util;

import java.util.ArrayList;
import java.util.List;

public class ValidationErrorResponse {
    private List<String> errors = new ArrayList<>();

    public ValidationErrorResponse() {
    }

    public void addValidationError(String error) {
        errors.add(error);
    }

    public List<String> getErrors() {
        return errors;
    }
}
