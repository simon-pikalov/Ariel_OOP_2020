import java.util.*;

public class SalfitLot implements CarLot {

    private ArrayList<MotorVehicle> lot;

    public SalfitLot(){
        this.lot = new ArrayList<MotorVehicle>();
    }

    public SalfitLot(ArrayList<MotorVehicle> lot) {
        this.lot = lot;
    }


    public void setLot(ArrayList<MotorVehicle> lot) {
        this.lot = lot;
    }

    /**
     * @param vehicle to add to the data-structure
     */
    @Override
    public void addVehicle(MotorVehicle vehicle) {
        this.lot.add(vehicle);
    }

    /**
     * @return the FastestVehicle
     */
    @Override
    public MotorVehicle getFastestVehicle() {
        MotorVehicle fastest = new Car();
        for (MotorVehicle m:this.lot) {
            if (m.getMaxSpeed()> fastest.getMaxSpeed() ) fastest = m;
        }
        return  fastest;
    }

    /**
     * @return the most Economy Vehicle
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
        ArrayList <MotorVehicle> old = new ArrayList<MotorVehicle>(lot); //copy the old
        lot.sort(comp); // sort it using comperator
        ArrayList<MotorVehicle> sorted = new ArrayList<>(lot); //generate a copy of sorted
        lot = sorted; //get the old list
        return sorted;
    }
}
