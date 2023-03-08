package core;

import entity.Location;
import entity.Rider;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chiragchandnani on 3/7/23.
 */
public class RiderManager {
    private List<Rider> riders;

    public RiderManager() {
        riders = new ArrayList<>();
    }


    public Rider registerRider(Rider rider) {
        riders.add(rider);
        return rider;
    }

    void updateLocation(Rider rider, Location location) {
        rider.setLocation(location);
    }


}