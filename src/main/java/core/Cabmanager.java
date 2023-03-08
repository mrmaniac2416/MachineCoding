package core;

import entity.Driver;
import entity.Location;
import entity.Rider;
import entity.Trip;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by chiragchandnani on 3/7/23.
 */
public class Cabmanager {

    private List<Driver> drivers;
    RiderManager riderManager;
    TripManager tripManager;

    public Cabmanager(TripManager tripManager, RiderManager riderManager) {
        drivers = new ArrayList<>();
        this.tripManager = tripManager;
        this.riderManager = riderManager;
    }



    public Driver registerDriver(Driver d) {
        boolean isNumberPlateUnique = drivers.stream().anyMatch(driver -> driver.getCab().getNumberPlate().equals(d.getCab().getNumberPlate()));
        if(!isNumberPlateUnique)

        drivers.add(d);
        return d;
    }

    public void updateLocation(Driver d, Location location) {
        d.setCurrentLocation(location);
    }

    public void updateStatus(Driver d, boolean status) {
        d.setAvailable(status);
    }

    /**
     * Finds the drivers within 5 units who are available
     *
     * @param rider rider asking for rides
     * @param source
     * @param destination
     * @return
     */
    public List<Driver> findRides(Rider rider, Location source, Location destination) {
        return drivers.
                stream()
                .filter(driver -> driver.isAvailable()
                        && driver.getCurrentLocation().calculateDistanceTo(rider.getLocation()) <= Constants.MAX_ALLOWED_DISTANCE)
                .collect(Collectors.toList());
    }


    public Trip chooseRide(Rider rider,Driver driver,Location source, Location destination) {
        if(!driver.isAvailable() || driver.getCurrentLocation().calculateDistanceTo(rider.getLocation()) <= Constants.MAX_ALLOWED_DISTANCE) {

        }
        Trip trip = Trip.builder()
                .tripId(tripManager.getNextTripId())
                .from(source)
                .to(destination)
                .driver(driver)
                .rider(rider)
                .amount(tripManager.calculateFare(source, destination))
                .isActive(true)
                .build();

        driver.setAvailable(false);

        tripManager.registerTrip(trip);

        return trip;
    }

    public Map<Driver,Double> getEarnings() {
        return drivers.stream().collect(Collectors.toMap(Function.identity(),Driver::getTotalEarning));
    }









}