package com.bridgelabz.invoiceservice;

import com.bridgelabz.InvoiceService;
import com.bridgelabz.InvoiceSummary;
import com.bridgelabz.Ride;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InvoiceServiceTest {
    InvoiceService invoiceService = null;

    @Before
    public void setUp() throws Exception {
        invoiceService = new InvoiceService();
    }

    @Test
    public void givenDistanceAndTime_shouldReturnTotalFare() {
        double distance = 2.0;
        int time = 5;
        double fare = invoiceService.calculateFare(distance, time);
        Assert.assertEquals(25,fare,0.0);
    }

    @Test
    public void givenLessDistanceOrTime_shouldReturnMinFare() {
        double distance = 0.1;
        int time = 1;
        double fare = invoiceService.calculateFare(distance, time);
        Assert.assertEquals(5,fare,0.0);
    }

   @Test
    public void givenMultipleRides_shouldReturnTotalFare() {
        Ride[] rides = {  new Ride(2.0, 5),
                          new Ride(0.1, 1)
        };
        double fare = invoiceService.calculateFareOfMultipleRides(rides);
        Assert.assertEquals(30,fare,0.0);
    }

    @Test
    public void givenMultipleRides_shouldReturnInvoiceSummary() {
        Ride[] rides = {  new Ride(2.0, 5),
                new Ride(0.1, 1)
        };
        InvoiceSummary summary = invoiceService.calculateFareForInvoiceSummary(rides);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30.0);
        Assert.assertEquals(expectedInvoiceSummary,summary);
    }

    @Test
    public void givenUserIdAndSummary_shouldReturnInvoiceSummary() {
        String userId = "a@b.com";
        Ride[] rides = {  new Ride(2.0, 5),
                          new Ride(0.1, 1)};
        double[] result = invoiceService.calculateFare(rides);
        Assert.assertEquals(30.0, result[1], 0.0);
    }

}
