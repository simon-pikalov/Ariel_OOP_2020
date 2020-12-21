import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Arrays;

public class Bus extends MotorVehicle implements Driveble , PublicTransfer  {
    /**
     * @author Simon Pikalov
     * https://github.com/simon-pikalov
     */
    private static  final double busDelay = 0.3;
    private static final int minSeats = 20;
    private static final int speedLimit = 120;
    private int currPassengerCount;
    private Point2D pos;

    public Bus(String manufacturer, String model, String registrationPlate, int weight, int maxSpeed, int seats) {
        super(manufacturer, model, registrationPlate, weight, maxSpeed, seats);
        //if(seats< minSeats) throw new Exception("Bus must have at least 20"); hard coded not good
        if(seats< minSeats) throw new RuntimeException("Bus must have at least "+minSeats+" seats but , You used only "+seats);
        this.currPassengerCount =0;
    }
    @Override
    public void setMaxSpeed(int maxSpeed) {
        int constrainedMaxSpeed = (maxSpeed<=speedLimit) ? maxSpeed: speedLimit;
    }

    @Override
    public int getMaxSpeed(){
        //return this.getMaxSpeed(); //-> stack overflow
        return super.getMaxSpeed();
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


    public static void main(String[] args) {
        Bus volvo9900 = new Bus("Volvo","9900","656-55-103",26500 ,120 ,52);
        volvo9900.setMaxSpeed(200);
        System.out.println(volvo9900.getMaxSpeed());
        MotorVehicle m = volvo9900;
        System.out.println(m.getMaxSpeed());
        final int a =5;
        final int[]b ={1,24,4};
        int []c = {1,2,3};

    }
}