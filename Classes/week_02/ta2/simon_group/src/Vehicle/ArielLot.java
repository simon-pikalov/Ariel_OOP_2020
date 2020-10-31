package Vehicle;

import java.util.*;
/**
 * @author Simon Pikalov
 * https://github.com/simon-pikalov
 */
public class ArielLot implements CarLot ,Iterable<MotorVehicle>{

    private HashMap<String,MotorVehicle> lot;

    public ArielLot(){
        this.lot = new HashMap<String,MotorVehicle>();
    }

    public ArielLot(HashMap<String,MotorVehicle> lot) {
        this.lot = lot;
    }


    /**
     * @param vehicle to add to the data-structure
     */
    @Override
    public void addVehicle(MotorVehicle vehicle) {
    this.lot.put(vehicle.getRegistrationPlate(),vehicle);
    }

    @Override
    public void removeVehicle(MotorVehicle vehicle) {
        lot.remove(vehicle.getRegistrationPlate());
    }

    /**
     * @return the FastestVehicle
     */
    @Override
    public MotorVehicle getFastestVehicle() {
//        Vehicle.MotorVehicle fastest = new Vehicle.Car();
//    Vehicle.MotorVehicle curr = null;
//        for (String s:this.lot.keySet()) {
//            curr = this.lot.get(s);
//            if (curr.getMaxSpeed() > fastest.getMaxSpeed() ) fastest = curr;
//        }
//
//
//    return  fastest;

        MotorVehicleCompareMaxSpeed speedComp = new MotorVehicleCompareMaxSpeed();
        MotorVehicle fastest =  Collections.max(lot.values(),speedComp);
        return  fastest;

    }

    /**
     * @return the most Economy Vehicle
     */
    @Override
    public MotorVehicle getLightestVehicle() {
        MotorVehicle lightest = new Car();
        lightest.setWeight(Double.MAX_VALUE); //this uses max value of aa double
        MotorVehicle curr = null;

        for (String s:this.lot.keySet()) {
            curr = this.lot.get(s);
            if (curr.getWeight() < lightest.getWeight() ) lightest = curr;
        }
        return  lightest;
    }

    /**
     * @return all the Vehicles
     */
    @Override
    public Collection<MotorVehicle> getAllVehicle() {
    return this.lot.values();
    }

    /**
     * @param comp Comparator
     * @return
     */
    @Override
    public Collection<MotorVehicle> getAllVehicleSorted(Comparator<MotorVehicle> comp) {
        ArrayList <MotorVehicle> sorted = new ArrayList<MotorVehicle>(lot.values()); //deep copy the list
        sorted.sort(comp); // sort it
        return sorted;
    }


    @Override
    public Iterator<MotorVehicle> iterator() {
        return  lot.values().iterator();
    }
}
