package com.bridgelabz.invoiceservice;

import com.bridgelabz.InvoiceGenerator;
import org.junit.Assert;
import org.junit.Test;

public class InvoiceServiceTest {
    
    @Test
    public void givenDistanceAndTime_shouldReturnTotalFare() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        double distance = 0.1;
        int time = 1;
        double fare = invoiceGenerator.calculateFare(distance, time);
        Assert.assertEquals(5,fare,0.0);
    }
}
