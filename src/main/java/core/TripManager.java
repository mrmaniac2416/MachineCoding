package core;

import entity.Location;
import entity.Trip;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by chiragchandnani on 3/7/23.
 */

public class TripManager {



    List<Trip> tripList;

    public TripManager() {
        tripList = new ArrayList<>();
    }


    Trip registerTrip(Trip trip) {
        tripList.add(trip);
        return trip;
    }

    public int getNextTripId() {
        return tripList.size()+1;
    }

    public double calculateFare(Location to, Location from) {
        return from.calculateDistanceTo(to)*Constants.RATE_PER_KM;
    }

    public List<Trip> getRiderHistory(String riderId) {
        return tripList.stream().filter(trip -> trip.getRider().getRiderID().equals(riderId)).collect(Collectors.toList());
    }

    public Trip endTrip(Trip trip) {
        trip.setActive(false);
        trip.getDriver().setAvailable(true);
        trip.getDriver().setTotalEarning(trip.getDriver().getTotalEarning() + trip.getAmount());
        return trip;
    }
}