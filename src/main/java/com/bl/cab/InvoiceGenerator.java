package com.bl.cab;

import java.util.List;

public class InvoiceGenerator {
    private static final int COST_PER_KM = 10;
    private static final int COST_PER_MIN = 1;
    private static final int MIN_FARE = 5;

    RideRepository rideRepository;

    public InvoiceGenerator() {
        rideRepository = new RideRepository();
    }

    public InvoiceGenerator(RideRepository rideRepository) {
        this.rideRepository = rideRepository;
    }

    public double calculateFare(double distance, int time) {
        double totalFare = distance * COST_PER_KM + time * COST_PER_MIN;
        if (totalFare < MIN_FARE)
            return MIN_FARE;
        return totalFare;
    }

    public void addRide(int userID, double distance, int time) {
        Ride ride = new Ride(userID, distance, time);
        rideRepository.add(ride);
    }

    public double getTotalFare(int userID) {
        double totalFare = 0;
        List<Ride> rides = rideRepository.getRide(userID);

        for (Ride ride : rides) {
            totalFare += this.calculateFare(ride.getDistance(), ride.getTime());
        }
        return totalFare;
    }

    public InvoiceBill getInvoiceBill(int userID) {
        int totalRide = rideRepository.getRide(userID).size();
        double totalFare = this.getTotalFare(userID);
        int avgFare = (int) totalFare / totalRide;
        return new InvoiceBill(totalRide, totalFare, avgFare);
    }
}