package entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by chiragchandnani on 3/6/23.
 */
@Getter
@AllArgsConstructor
@ToString
public class Rider {
    String riderID;


    @Setter
    Location location;

}