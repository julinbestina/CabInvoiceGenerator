package com.bl.cab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CabInvoiceGeneratorTest {
    @Mock
    RideRepository rideRepository;
    InvoiceGenerator invoiceGenerator;

    @Before
    public void setUp() {
        invoiceGenerator = new InvoiceGenerator(rideRepository);
    }

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
        Mockito.doNothing().when(rideRepository).add(Mockito.any(Ride.class));
        List<Ride> rideList = new ArrayList<>();
        Ride ride1 = new Ride(1, 20, 15);
        Ride ride2 = new Ride(1, 30, 25);
        rideList.add(ride1);
        rideList.add(ride2);
        Mockito.when(rideRepository.getRide(Matchers.anyInt())).thenReturn(rideList);
        invoiceGenerator.addRide(1, 20, 15);
        invoiceGenerator.addRide(1, 30, 25);
        double totalFare = invoiceGenerator.getTotalFare(1);
        Assert.assertEquals(540, totalFare, 0.0);

    }

    @Test
    public void givenMultipleRide_ShouldReturnInvoiceBill() {
        Mockito.doNothing().when(rideRepository).add(Mockito.any(Ride.class));
        List<Ride> rideList = new ArrayList<>();
        rideList.add(new Ride(1, 20, 15));
        rideList.add(new Ride(1, 30, 25));
        Mockito.when(rideRepository.getRide(Matchers.anyInt())).thenReturn(rideList);
        invoiceGenerator.addRide(1, 20, 15);
        invoiceGenerator.addRide(1, 30, 25);
        InvoiceBill invoiceBill = invoiceGenerator.getInvoiceBill(1);
        InvoiceBill expectedInvoiceBill = new InvoiceBill(2, 540, 270);
        Assert.assertEquals(expectedInvoiceBill, invoiceBill);
    }

}