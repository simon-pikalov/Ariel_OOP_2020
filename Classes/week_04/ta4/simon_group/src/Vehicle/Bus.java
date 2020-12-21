package Vehicle;

import java.awt.geom.Point2D;

public class Bus extends MotorVehicle implements Driveble , PublicTransfer,java.io.Serializable  {
    /**
     * @author Simon Pikalov
     * https://github.com/simon-pikalov
     */
    private static  final double busDelay = 0.3;
    private static final int minSeats = 20;
    private static final int speedLimit = 120;
    private int currPassengerCount;
    private Point2D pos;

    public void onlyBusFunction(){
        System.out.println("this is only bus function ! ");
    }

    public Bus(String manufacturer, String model, String registrationPlate, int weight, int maxSpeed, int seats) {
        super(manufacturer, model, registrationPlate, weight, maxSpeed, seats);
        //if(seats< minSeats) throw new Exception("Vehicle.Bus must have at least 20"); hard coded not good
        if(seats< minSeats) throw new RuntimeException("Vehicle.Bus must have at least "+minSeats+" seats but , You used only "+seats);
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
        MotorVehicle volvo9900 = new Bus("Volvo","9900","656-55-103",26500 ,120 ,52);
        System.out.println(volvo9900);
        Bus b = (Bus) volvo9900;
        b.onlyBusFunction();
    }
}