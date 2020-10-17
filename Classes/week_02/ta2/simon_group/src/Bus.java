import java.awt.geom.Point2D;

public class Bus extends MotorVehicle implements Driveble , PublicTransfer  {
    /**
     * @author Simon Pikalov
     * https://github.com/simon-pikalov
     */
    private static  final double busDelay = 0.3;
    private static final int minSeats = 20;
    private int currPassengerCount;
    private Point2D pos;

    public Bus(String manufacturer, String model, String registrationPlate, int weight, int maxSpeed, int seats) {
        super(manufacturer, model, registrationPlate, weight, maxSpeed, seats);
        //if(seats< minSeats) throw new Exception("Bus must have at least 20"); hard coded not good
        if(seats< minSeats) throw new RuntimeException("Bus must have at least "+minSeats+" seats but , You used only "+seats);
        this.currPassengerCount =0;
    }

    @Override
    public void initPos(Point2D p) {
        this.pos = p;
    }

    @Override
    public Point2D getPos() {
        return pos;
    }


    @Override
    public double drive( Point2D dst) {
        if (pos ==null){
            System.out.println("you must firs init the pos ! ");
            throw new NullPointerException();}
        double distance = Point2D.distance(pos.getX(), pos.getY(), dst.getX(), dst.getY());
        double timeToTravel = distance/(getMaxSpeed()*busDelay);
        return timeToTravel;
    }


    @Override
    public int getCurrPassengerCount() {
    return  currPassengerCount;
    }

    @Override
    public void addPassenger() {
        currPassengerCount++;

    }

    @Override
    public void getOffPassenger() {
    currPassengerCount--;
    }
}
