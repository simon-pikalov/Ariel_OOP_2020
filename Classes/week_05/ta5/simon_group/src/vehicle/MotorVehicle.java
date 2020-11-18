package vehicle;

import java.io.File;
import java.io.IOException;

/**
 * @author simon pikalov
 * This class represents a motor vehicle
 * A motor vehicle, also known as motorized vehicle or automotive vehicle,
 * is a self-propelled vehicle, commonly wheeled,
 * that does not operate on rails (such as trains or trams) and is used for the transportation of people or cargo.
 * https://en.wikipedia.org/wiki/Motor_vehicle
 */

public abstract class MotorVehicle implements java.io.Serializable {

    private String manufacturer;
    private String model;
    private String registrationPlate;
    private double weight; // in kilograms
    private int maxSpeed;
    private int seats;
    private Engine engine;

    public MotorVehicle() {
        //System.out.println("empty constructor called");
        this.engine = new Engine();
        this.manufacturer = "NONE";
        this.model = "NONE";
        this.registrationPlate = "NONE";
        this.weight = -1;
        this.maxSpeed = -1;
        this.seats = -1;
    }


    public MotorVehicle(MotorVehicle other) {
        this.engine = new Engine();
        this.manufacturer = other.manufacturer;
        this.model = other.model;
        this.registrationPlate = other.registrationPlate;
        this.weight = other.weight;
        this.maxSpeed = other.maxSpeed;
        this.seats = other.seats;
    }

    public MotorVehicle(String manufacturer, String model, String registrationPlate, int weight, int maxSpeed, int seats) {
       // System.out.println("args constructor called");
        if (seats < 0) throw new RuntimeException("seats must be positive number , you used  " + seats);
        if (weight < 0) throw new RuntimeException("weight must be positive number , you used  " + weight);
        if (maxSpeed < 0) throw new RuntimeException("maxSpeed must be positive number , you used  " + maxSpeed);
        this.engine = new Engine();
        this.maxSpeed = maxSpeed;
        this.manufacturer = manufacturer;
        this.model = model;
        this.registrationPlate = registrationPlate;
        this.weight = weight;
        this.seats = seats;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MotorVehicle that = (MotorVehicle) o;

        if (Double.compare(that.weight, weight) != 0) return false;
        if (maxSpeed != that.maxSpeed) return false;
        if (seats != that.seats) return false;
        if (manufacturer != null ? !manufacturer.equals(that.manufacturer) : that.manufacturer != null) return false;
        if (model != null ? !model.equals(that.model) : that.model != null) return false;
        return registrationPlate != null ? registrationPlate.equals(that.registrationPlate) : that.registrationPlate == null;
    }


    @Override
    public int hashCode() {
        int result;
        long temp;
        result = manufacturer != null ? manufacturer.hashCode() : 0;
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + (registrationPlate != null ? registrationPlate.hashCode() : 0);
        temp = Double.doubleToLongBits(weight);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + maxSpeed;
        result = 31 * result + seats;
        return result;
    }




    public String getEngineName() {
        return engine.engineName;
    }

    public void setEngineName(String engineName) {
        this.engine.engineName = engineName;
    }

    public String getId() {
        return engine.id;
    }

    public void setEngineId(String id) {
        this.engine.id = id;

    }


    private class Engine implements java.io.Serializable {
        private String engineName;
        private String id;


        public Engine() {

            this.engineName = "";
            this.id = "";
        }

        public Engine(String engineName, String id) {
            this.engineName = engineName;
            this.id = id;
        }



        public String getEngineName() {
            return engineName;
        }

        public void setEngineName(String engineName) {
            this.engineName = engineName;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return "Engine{" +
                    ", engineName='" + engineName + '\'' +
                    ", id='" + id + '\'' +
                    '}';
        }
    }


    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getRegistrationPlate() {
        return registrationPlate;
    }

    public void setRegistrationPlate(String registrationPlate) {
        this.registrationPlate = registrationPlate;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        if (weight < 0) throw new RuntimeException("weight must be positive number , you used  " + weight);
        this.weight = weight;
    }


    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }


    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        if (seats < 0) throw new RuntimeException("seats must be positive number , you used  " + seats);
        this.seats = seats;

    }


    @Override
    public String toString() {
        return "MotorVehicle{" +
                "manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", registrationPlate='" + registrationPlate + '\'' +
                ", weight=" + weight +
                ", maxSpeed=" + maxSpeed +
                ", seats=" + seats +
                ", engine=" + engine +
                '}';
    }



    public static void main(String[] args) {

    }

}