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
     *
     * @return fastet Vehicle in the lot
     */
    MotorVehicle getFastestVehicle();

    /**
     *
     * @return most fuel economic Vehicle in the lot
     */
    MotorVehicle getLightestVehicle();

    /**
     *
     * @return HashMap containing all vehicles
     */
   Collection<MotorVehicle> getAllVehicle();

    /**
     *
     * @param comp Comparator
     * @return the sorted data-structure
     */
    Collection<MotorVehicle> getAllVehicleSorted(Comparator<MotorVehicle> comp);

}
