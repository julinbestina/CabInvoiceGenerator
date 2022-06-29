package com.bl.cab;

public class InvoiceGenerator {
    private static final int COST_PER_KM = 10;
    private static final int COST_PER_MIN = 1;
    private static  final int MIN_FARE = 5;


    public double calculateFare(double distance, int time) {
        double fare = distance * COST_PER_KM + time *COST_PER_MIN;
        return fare;
    }
}
