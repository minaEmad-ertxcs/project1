package com.example.project1.Services;

import java.util.ArrayList;

public class Rating {
    private double average;
    private ArrayList<Double> rates = new ArrayList<>();

    public Rating() {
    }

    public void setRate(double rate) {
        rates.add(rate);
        average = this.calculateAvg();
    }

    public double calculateAvg() {
        double sum = 0;
        for (Double rate : rates) {
            sum = sum + rate;
        }

        return sum / (double) rates.size();
    }

    public double getAverage() {
        return average;
    }

}
