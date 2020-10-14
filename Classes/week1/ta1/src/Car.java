import java.awt.geom.Point2D;

public class Car extends MotorVehicle implements Driveble {
    private static  final double busDelay = 0.5;

    public  Car(){
        super("","", "", 0,0, 0, 0);
    }

    public Car(String manufacturer, String model, String registrationPlate, int weight, int maxSpeed, int fuelCapacity, int seats) {
        super(manufacturer, model, registrationPlate, weight, maxSpeed, fuelCapacity, seats);
    }

    /**
     * @author Simon Pikalov
     * https://github.com/simon-pikalov
     */


    @Override
    public double drive(Point2D src, Point2D dst) {
        double distance = Point2D.distance(src.getX(), src.getY(), dst.getX(), dst.getY());
        double timeToTravel = distance/(getMaxSpeed()*busDelay);
        return timeToTravel;
    }
}
