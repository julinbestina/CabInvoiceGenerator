package com.bl.cab;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Ride {
    private double distance;
    private int time;

    public Ride(double distance, int time) {

        this.distance = distance;
        this.time = time;
    }
}