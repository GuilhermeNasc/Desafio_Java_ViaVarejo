package com.nascimento.viavarejo.rest.domain;

import java.time.LocalDate;
import org.springframework.data.annotation.Id;

public class Insurance {

    @Id
    private String id;

    private String number;
    private LocalDate startDate;
    private LocalDate endDate;
    private String vehiclePlate;
    private int value;
    private String driverId;

    public Insurance() {
    }

    public Insurance(String number, LocalDate startDate, LocalDate endDate, String vehiclePlate, int value, String driverId) {
        this.setNumber(number);
        this.startDate = startDate;
        this.endDate = endDate;
        this.vehiclePlate = vehiclePlate;
        this.value = value;
        this.driverId = driverId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getVehiclePlate() {
        return vehiclePlate;
    }

    public void setVehiclePlate(String vehiclePlate) {
        this.vehiclePlate = vehiclePlate;
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriver(String driverId) {
        this.driverId = driverId;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
}