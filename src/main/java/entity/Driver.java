package entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by chiragchandnani on 3/6/23.
 */

@AllArgsConstructor
@Getter
@ToString
public class Driver {
    String driverId;


    @Setter
    boolean isAvailable;

    @Setter
    private Location currentLocation;

    @Setter
    private double totalEarning;

    Cab cab;


}