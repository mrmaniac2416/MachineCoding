import core.Cabmanager;
import core.RiderManager;
import core.TripManager;
import entity.*;

import java.util.Arrays;

/**
 * Created by chiragchandnani on 3/8/23.
 */
public class Tester {

    /*
      Add expection hadling
     */

    public static void main(String[] args) {
        Cab c1 = new Cab(CabType.BASIC,"Swift Dzire", "GJ06");
        Cab c2 = new Cab(CabType.BASIC, "Verna", "GJ05");

        Driver d1 = new Driver("d1", true, new Location(10,10),0.0,c1);
        Driver d2 = new Driver("d2", true, new Location(5,5),0.0,c2);

        TripManager tripManager = new TripManager();
        RiderManager riderManager = new RiderManager();
        Cabmanager cabmanager = new Cabmanager(tripManager, riderManager);

        cabmanager.registerDriver(d1);
        cabmanager.registerDriver(d2);


        Rider r1 = new Rider("r1", new Location(15,15));
        Rider r2 = new Rider("r2", new Location(0,0));

        riderManager.registerRider(r1);
        riderManager.registerRider(r2);

        debug(cabmanager.findRides(r1,r1.getLocation(), new Location(20,20)));
        Trip t1 = cabmanager.chooseRide(r1,d1,r1.getLocation(),new Location(20,20));
        tripManager.endTrip(t1);

        debug(tripManager.getRiderHistory("r1"));

        debug(cabmanager.getEarnings());

    }

    public static  void debug(Object ...o){
        System.out.println(Arrays.deepToString(o));
    }
}