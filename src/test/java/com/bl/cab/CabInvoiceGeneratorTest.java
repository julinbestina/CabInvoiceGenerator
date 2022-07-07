package com.bl.cab;

import org.junit.Assert;
import org.junit.Test;

public class CabInvoiceGeneratorTest {
    InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare() {

        double fare = invoiceGenerator.calculateFare(10, 15);
        Assert.assertEquals(115, fare, 0.0);
    }

    @Test
    public void givenDistanceAndTime_WhenLessThan10_ShouldReturnMinimumFare() {
        double fare = invoiceGenerator.calculateFare(0.3, 1);
        Assert.assertEquals(5, fare, 0.0);
    }

    @Test
    public void givenMultipleRide_ShouldReturnAggregateTotalFare() {
        invoiceGenerator.addRide(20, 15);
        invoiceGenerator.addRide(30, 25);
        double totalFare = invoiceGenerator.getTotalFare();
        Assert.assertEquals(540, totalFare, 0.0);
    }

    @Test
    public void givenMultipleRide_ShouldReturnInvoiceBill() {
        invoiceGenerator.addRide(20, 15);
        invoiceGenerator.addRide(30, 25);
        InvoiceBill invoiceBill = invoiceGenerator.getInvoiceBill();
        InvoiceBill expectedInvoiceBill = new InvoiceBill(2, 540, 270);
        Assert.assertEquals(expectedInvoiceBill, invoiceBill);
    }

}