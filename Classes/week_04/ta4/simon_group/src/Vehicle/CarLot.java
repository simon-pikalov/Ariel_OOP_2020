package Vehicle;

import java.util.*;

/**
 * @author Simon Pikalov
 * https://github.com/simon-pikalov
 */
public interface CarLot  {

    /**
     *
     * @param vehicle to add to the data-structure
     */
    void addVehicle(MotorVehicle vehicle);



    /**
     * remove vehicle if present
     * @param vehicle the vehicle to be removed if present
     */
    void removeVehicle(MotorVehicle vehicle);


    /**
     *
     * @return fastet Vehicle in the lot
     */
    MotorVehicle getFastestVehicle();

    /**
     *
     * @return  Lightest Vehicle in the lot
     */
    MotorVehicle getLightestVehicle();

    /**
     *
     * @return Collection containing all vehicles
     */
   Collection<MotorVehicle> getAllVehicle();

    /**
     *
     * @param comp Comparator
     * @return the sorted data-structure
     */
    Collection<MotorVehicle> getAllVehicleSorted(Comparator<MotorVehicle> comp);




}
