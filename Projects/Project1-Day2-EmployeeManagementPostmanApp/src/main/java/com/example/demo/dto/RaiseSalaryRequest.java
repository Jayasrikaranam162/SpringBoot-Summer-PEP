package com.example.demo.dto;

public class RaiseSalaryRequest {

    private String name;

    private double percentage;

    public RaiseSalaryRequest() {

    }

    public RaiseSalaryRequest(String name, double percentage) {
        this.name = name;
        this.percentage = percentage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

}