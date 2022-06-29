package com.bl.cab;

import org.junit.Assert;
import org.junit.Test;

public class CabInvoiceGeneratorTest {
    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        double fare = invoiceGenerator.calculateFare(10, 15);
        Assert.assertEquals(115, fare, 0.0);
    }

    @Test
    public void givenDistanceAndTime_WhenLessThan10_ShouldReturnMinimumFare() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        double fare = invoiceGenerator.calculateFare(0.3, 1);
        Assert.assertEquals(5,fare,0.0);
    }
}
