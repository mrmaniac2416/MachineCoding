package entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by chiragchandnani on 3/6/23.
 */

@AllArgsConstructor
@Getter
public class Cab {
    CabType cabtype;
    String model;
    String numberPlate;

}