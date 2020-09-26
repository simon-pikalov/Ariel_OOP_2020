import java.awt.geom.Point2D;
/**
 * @author Simon Pikalov
 * https://github.com/simon-pikalov
 */
public class MiniBus extends MotorVehicle implements Driveble {

    double price;
    public static  final double busDelay = 0.1;
    public static  final double miniSeats  = 6;
    public MiniBus(String manufacturer, String model, String registrationPlate, double weight, double fuelCapacity, double averageSpeed, int seats) {
        super(manufacturer, model, registrationPlate, weight, fuelCapacity, averageSpeed, seats);
    }

    @Override
    public double drive(Point2D src, Point2D dst) {
        double distance = Point2D.distance(src.getX(), src.getY(), dst.getX(), dst.getY());
        double timeToTravel = distance/averageSpeed*busDelay;
        return timeToTravel;
    }

}
