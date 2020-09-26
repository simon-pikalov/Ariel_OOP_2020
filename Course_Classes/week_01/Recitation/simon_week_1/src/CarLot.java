import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

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
    MotorVehicle getEconomyVehicle();

    /**
     *
     * @return HashMap containing all vehicles
     */
    HashMap<String,MotorVehicle> getAllVehicle();

    /**
     *
     * @param comp Comparator
     * @return the sorted data-structure
     */
    List<MotorVehicle> getAllVehicleSorted(Comparator<Car> comp);
}
