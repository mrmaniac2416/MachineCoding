package entity;

import lombok.AllArgsConstructor;
import lombok.ToString;

/**
 * Created by chiragchandnani on 3/6/23.
 */

@AllArgsConstructor
@ToString
public class Location {
    private double x;
    private double y;

    public double calculateDistanceTo(Location other) {
        double xDiff = x- other.x;
        double yDiff = y-other.y;
        return xDiff*xDiff + yDiff*yDiff;
    }
}