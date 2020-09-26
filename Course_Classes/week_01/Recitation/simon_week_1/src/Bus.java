import java.awt.geom.Point2D;

public class Bus extends MotorVehicle implements Driveble  {
    /**
     * @author Simon Pikalov
     * https://github.com/simon-pikalov
     */
    private double price;
    private static  final double busDelay = 0.3;
    public Bus(String manufacturer, String model, String registrationPlate, double weight, double fuelCapacity, double averageSpeed, int seats) {
        super(manufacturer, model, registrationPlate, weight, fuelCapacity, averageSpeed, seats);
    }

    @Override
    public double drive(Point2D src, Point2D dst) {
        double distance = Point2D.distance(src.getX(), src.getY(), dst.getX(), dst.getY());
        double timeToTravel = distance/getAverageSpeed()*busDelay;
        return timeToTravel;
    }


}
