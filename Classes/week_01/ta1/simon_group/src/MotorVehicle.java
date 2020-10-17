/**@author simon pikalov
 * This class represents a motor vehicle
 A motor vehicle, also known as motorized vehicle or automotive vehicle,
 is a self-propelled vehicle, commonly wheeled,
 that does not operate on rails (such as trains or trams) and is used for the transportation of people or cargo.
 https://en.wikipedia.org/wiki/Motor_vehicle
 */
public abstract class MotorVehicle {

    private String manufacturer;
    private String model;
    private String registrationPlate;
    private double weight; // in kilograms
    private int maxSpeed;
    private int seats;


    public MotorVehicle(String manufacturer, String model, String registrationPlate, int weight,int maxSpeed,int seats) {
        if(seats< 0) throw new RuntimeException("seats must be positive number , you used  "+seats);
        if(weight< 0) throw new RuntimeException("weight must be positive number , you used  "+weight);
        if(maxSpeed< 0) throw new RuntimeException("maxSpeed must be positive number , you used  "+maxSpeed);
        this.maxSpeed = maxSpeed;
        this.manufacturer = manufacturer;
        this.model = model;
        this.registrationPlate = registrationPlate;
        this.weight = weight;

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
                '}';
    }
}
