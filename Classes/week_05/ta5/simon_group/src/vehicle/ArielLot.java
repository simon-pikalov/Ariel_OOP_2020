package vehicle;

import java.io.*;
import java.util.*;
/**
 * @author Simon Pikalov
 * https://github.com/simon-pikalov
 */
public class ArielLot implements CarLot ,Iterable<MotorVehicle>


{

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
        MotorVehicleCompareWeight lightComp = new MotorVehicleCompareWeight();
        MotorVehicle lightest =  Collections.max(lot.values(),lightComp);
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

    public boolean saveCars(String file){
        System.out.println("starting Serialize to "+file+"\n");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream
                    = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(this.lot);

            fileOutputStream.close();
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        System.out.println("end of Serialize \n\n");
        return true;
    }



    public boolean loadCars(String file){
        System.out.println("Deserialize from : "+file);
        // Deserialize HashMap of user-defined object values
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream
                    = new ObjectInputStream(fileInputStream);

            HashMap<String,MotorVehicle> deserializedAriel = (HashMap<String,MotorVehicle>) objectInputStream.readObject();
            deserializedAriel.entrySet().forEach(entry -> {
                System.out.println(entry.getKey() + " = " + entry.getValue());
            });
            fileInputStream.close();
            objectInputStream.close();
            this.lot = deserializedAriel;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }

        return true;

}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ArielLot that = (ArielLot) o;

       for(MotorVehicle m : this.getAllVehicle()){
          if(!that.lot.containsKey(m.getRegistrationPlate())) {
              return false;
          }
       }

        for(MotorVehicle m : that.getAllVehicle()){
            if(!this.lot.containsKey(m.getRegistrationPlate())) {
                return false;
            }
        }


        return true;
    }

    @Override
    public int hashCode() {
        return lot != null ? lot.hashCode() : 0;
    }
}
