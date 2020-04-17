package com.bridgelabz;

public class InvoiceService {
    private static final int COST_PER_TIME = 1;
    private static final double MINIMUM_COST_PER_KILOMETER = 10;
    private static final double MINIMUM_FARE = 5;
    RideRepository rideRepository = new RideRepository();

    public double calculateFare(double distance,int time) {
        double totalFare = distance * MINIMUM_COST_PER_KILOMETER + time *COST_PER_TIME;
        return Math.max(totalFare, MINIMUM_FARE);
    }

    public double calculateFareOfMultipleRides(Ride[] rides) {
        double totalFare = 0;
        for (Ride ride:rides) {
            totalFare += calculateFare(ride.distance, ride.time);
        }
        return totalFare;
    }

    public InvoiceSummary calculateFareForInvoiceSummary(Ride[] rides) {
        double totalFare = 0;
        double[] result = new double[3];
        for(Ride ride : rides) {
            totalFare += calculateFare(ride.distance, ride.time);
        }
        result[0] = rides.length;
        result[1] = totalFare;
        result[2] = totalFare/rides.length;
        return new InvoiceSummary(rides.length, totalFare);
    }

    public double[] calculateFare(Ride[] rides) {
        double totalFare = 0;
        double[] result = new double[3];
        for(Ride ride : rides) {
            totalFare += calculateFare(ride.distance, ride.time);
        }
        result[0] = rides.length;
        result[1] = totalFare;
        result[2] = totalFare/rides.length;
        return result;
    }

    public void addRides(String userId, Ride[] rides) {
        rideRepository.addRides(userId,rides);
    }

    public double[] getInvoiceSummary(String userId) {
        return this.calculateFare(rideRepository.getRides(userId));
    }
}
