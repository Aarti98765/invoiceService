package com.bridgelabz;

public class Ride {
    public int time;
    public double distance;
    public CabRide cabRide;

    public Ride(CabRide cabRide, double distance, int time) {
        this.cabRide = cabRide;
        this.distance = distance;
        this.time = time;
    }
}
