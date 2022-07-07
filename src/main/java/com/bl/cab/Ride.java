package com.bl.cab;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Ride {
    private int userID;
    private double distance;
    private int time;

    public Ride(int userID, double distance, int time) {
        this.userID = userID;
        this.distance = distance;
        this.time = time;
    }
}