import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;

public class GmcLot implements CarLot {

    private HashMap<String,MotorVehicle> lot;

    public GmcLot(){
        this.lot = new HashMap<String,MotorVehicle>();
    }

    public GmcLot(HashMap<String,MotorVehicle> lot) {
        this.lot = lot;
    }

    /**
     * @param vehicle to add to the data-structure
     */
    @Override
    public void addVehicle(MotorVehicle vehicle) {
    this.lot.put(vehicle.getRegistrationPlate(),vehicle);
    }

    /**
     * @return the FastestVehicle
     */
    @Override
    public MotorVehicle getFastestVehicle() {
        return null;
    }

    /**
     * @return the most Economy Vehicle
     */
    @Override
    public MotorVehicle getEconomyVehicle() {
        return null;
    }

    /**
     * @return all the Vehicles
     */
    @Override
    public HashMap<String,MotorVehicle> getAllVehicle() {
        return  this.lot;
    }

    /**
     * @param comp Comparator
     * @return
     */
    @Override
    public LinkedList<MotorVehicle> getAllVehicleSorted(Comparator<Car> comp) {
        return null;
    }
}
