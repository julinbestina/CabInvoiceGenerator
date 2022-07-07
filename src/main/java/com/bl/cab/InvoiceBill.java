package com.bl.cab;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class InvoiceBill {
    int totalRide;
    double totalFare;
    int avgFare;

    public InvoiceBill(int totalRide, double totalFare, int avgFare) {
        this.totalRide = totalRide;
        this.totalFare = totalFare;
        this.avgFare = avgFare;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceBill that = (InvoiceBill) o;
        return totalRide == that.totalRide && Double.compare(that.totalFare, totalFare) == 0 && avgFare == that.avgFare;
    }

}