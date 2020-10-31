package Vehicle;

import java.util.*;

public class SalfitLot implements CarLot {

    private ArrayList<MotorVehicle> lot;

    public SalfitLot(){
        this.lot = new ArrayList<MotorVehicle>();
    }

    public SalfitLot(ArrayList<MotorVehicle> lot) {
        this.lot = lot;
    }




    /**
     * @param vehicle to add to the data-structure
     */
    @Override
    public void addVehicle(MotorVehicle vehicle) {
        this.lot.add(vehicle);
    }

    @Override
    public void removeVehicle(MotorVehicle vehicle) {
        lot.remove(vehicle);
    }

    /**
     * @return the FastestVehicle
     */
    @Override
    public MotorVehicle getFastestVehicle() {
//        Vehicle.MotorVehicle fastest = new Vehicle.Car();
//        for (Vehicle.MotorVehicle m:this.lot) {
//            if (m.getMaxSpeed()> fastest.getMaxSpeed() ) fastest = m;
//        }

        MotorVehicleCompareMaxSpeed speedComp = new MotorVehicleCompareMaxSpeed();
        MotorVehicle fastest =  Collections.max(lot,speedComp);
        return  fastest;
    }

    /**
     * @return the most Lightes Vehicle
     */
    @Override
    public MotorVehicle getLightestVehicle() {
        MotorVehicle light = new Car();
        light.setWeight(Double.MAX_VALUE);
        for (MotorVehicle m:this.lot) {
            if (m.getWeight()< light.getWeight() ) light = m;
        }
        return  light;
    }

    /**
     * @return all the Vehicles
     */
    @Override
    public Collection<MotorVehicle> getAllVehicle() {
        return  this.lot;
    }

    /**
     * @param comp Comparator
     * @return soted list
     */
    @Override
    public Collection<MotorVehicle> getAllVehicleSorted(Comparator<MotorVehicle> comp){
        ArrayList <MotorVehicle> sorted = new ArrayList<MotorVehicle>(lot); //deep copy the list
        sorted.sort(comp);
        return sorted;
    }


}
