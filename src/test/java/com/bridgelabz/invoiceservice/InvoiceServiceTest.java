package com.bridgelabz.invoiceservice;

import com.bridgelabz.InvoiceGenerator;
import com.bridgelabz.Ride;
import org.junit.Assert;
import org.junit.Test;

public class InvoiceServiceTest {

    @Test
    public void givenDistanceAndTime_shouldReturnTotalFare() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        double distance = 2.0;
        int time = 5;
        double fare = invoiceGenerator.calculateFare(distance, time);
        Assert.assertEquals(25,fare,0.0);
    }

    @Test
    public void givenLessDistanceOrTime_shouldReturnMinFare() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        double distance = 0.1;
        int time = 1;
        double fare = invoiceGenerator.calculateFare(distance, time);
        Assert.assertEquals(5,fare,0.0);
    }

    @Test
    public void givenMultipleRides_shouldReturnTotalFare() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        Ride[] rides = {  new Ride(2.0, 5),
                          new Ride(0.1, 1)
                       };
        invoiceGenerator.calculateFare(rides);
    }
}
