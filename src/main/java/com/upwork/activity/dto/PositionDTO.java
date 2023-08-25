package com.upwork.activity.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class PositionDTO {

    @NotNull(message = "Field 'latitude' is mandatory")
    private double latitude;
    @NotNull(message = "Field 'lngitude' is mandatory")
    private double lngitude;

    public PositionDTO() {
        super();
    }

    public PositionDTO(double latitude, double lngitude) {
        this.latitude = latitude;
        this.lngitude = lngitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLngitude() {
        return lngitude;
    }

    public void setLngitude(double lngitude) {
        this.lngitude = lngitude;
    }
}
