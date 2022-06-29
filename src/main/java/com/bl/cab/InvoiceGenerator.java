package com.bl.cab;


import java.util.ArrayList;
import java.util.List;

public class InvoiceGenerator {
    private static final int COST_PER_KM = 10;
    private static final int COST_PER_MIN = 1;
    private static final int MIN_FARE = 5;
    List<Ride> rideList = new ArrayList<>();

    public double calculateFare(double distance, int time) {
        double totalFare = distance * COST_PER_KM + time * COST_PER_MIN;
        if (totalFare < MIN_FARE)
            return MIN_FARE;
        return totalFare;
    }

    public void addRide(double distance, int time) {
        Ride ride = new Ride(distance, time);
        rideList.add(ride);
    }

    public double getTotalFare() {
        double totalFare = 0;
        for (Ride ride : rideList) {
            totalFare += this.calculateFare(ride.getDistance(), ride.getTime());
        }
        return totalFare;
    }
}
