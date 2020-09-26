import java.util.Comparator;
import java.util.LinkedList;

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
     * @return Linked list containing all vehicles
     */
    LinkedList<MotorVehicle> getAllVehicle();

    /**
     *
     * @param comp Comparator
     * @return the sorted data-structure
     */
    LinkedList<MotorVehicle> getAllVehicleSorted(Comparator<Car> comp);
}
