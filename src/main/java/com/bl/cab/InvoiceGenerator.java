package com.bl.cab;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InvoiceGenerator {
    private static final int COST_PER_KM = 10;
    private static final int COST_PER_MIN = 1;
    private static  final int MIN_FARE = 5;


    public double calculateFare(double distance, int time) {
        double totalFare = distance * COST_PER_KM + time *COST_PER_MIN;
        if(totalFare < MIN_FARE)
            return MIN_FARE;
        return totalFare;
    }
}
