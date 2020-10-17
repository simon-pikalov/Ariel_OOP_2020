import java.awt.geom.Point2D;

public class Car extends MotorVehicle implements Driveble {
    private static  final double busDelay = 0.5;
    private Point2D pos ;

    public  Car(){
        super("","", "",0, 0, 0);
    }

    public Car(String manufacturer, String model, String registrationPlate, int weight, int maxSpeed, int seats) {
        super(manufacturer, model, registrationPlate, weight, maxSpeed, seats);
    }

    @Override
    public void initPos(Point2D p) {
        this.pos = p;
    }

    @Override
    public Point2D getPos() {
        return pos;
    }

    /**
     * @author Simon Pikalov
     * https://github.com/simon-pikalov
     */


    @Override
    public double drive( Point2D dst) {

        if (pos ==null){
            System.out.println("you must firs init the pos ! ");
            throw new NullPointerException();}

        double distance = Point2D.distance(pos.getX(), pos.getY(), dst.getX(), dst.getY());
        double timeToTravel = distance/(getMaxSpeed()*busDelay);
        return timeToTravel;
    }
}
