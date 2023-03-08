package entity;

import lombok.*;

/**
 * Created by chiragchandnani on 3/6/23.
 */

@AllArgsConstructor
@Builder
@Getter
@ToString
public class Trip {
    int tripId;
    Location from;
    Location to;


    Rider rider;

    Driver driver;

    double amount;

    @Setter
    boolean isActive;
}