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
    private double weight; // in tons
    private double fuelCapacity;
    private double fuelConsumption;
    private double fuelPercent ; //should be between 0-1
    private double minSpeed;
    private double maxSpeed;
    private double averageSpeed;
    private int seats;


    public MotorVehicle(String manufacturer, String model, String registrationPlate, double weight, double fuelCapacity, double averageSpeed,int seats) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.registrationPlate = registrationPlate;
        this.weight = weight;
        this.fuelCapacity = fuelCapacity;
        this.fuelConsumption = fuelConsumption;
        this.fuelPercent = 0;
        this.averageSpeed = averageSpeed;
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

    public double getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(double fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public double getFuelPercent() {
        return fuelPercent;
    }

    public void setFuelPercent(double fuelPercent) {
        this.fuelPercent = fuelPercent;
    }

    public double getMinSpeed() {
        return minSpeed;
    }

    public void setMinSpeed(double minSpeed) {
        this.minSpeed = minSpeed;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public double getAverageSpeed() {
        return averageSpeed;
    }

    public void setAverageSpeed(double averageSpeed) {
        this.averageSpeed = averageSpeed;
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
                ", fuelCapacity=" + fuelCapacity +
                ", fuelConsumption=" + fuelConsumption +
                ", fuelPercent=" + fuelPercent +
                ", minSpeed=" + minSpeed +
                ", maxSpeed=" + maxSpeed +
                ", averageSpeed=" + averageSpeed +
                ", seats=" + seats +
                '}';
    }
}
