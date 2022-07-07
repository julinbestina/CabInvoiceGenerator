package com.bl.cab;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@ToString
@Getter
@Setter
public class RideRepository {
    List<Ride> rideList = new ArrayList<>();

    public void add(Ride ride) {
        // System.out.println("I am inside Add Method");
        rideList.add(ride);
    }

    public List<Ride> getRide(int userID) {
        return rideList.stream().filter(n -> n.getUserID() == userID).collect(Collectors.toList());
    }
}