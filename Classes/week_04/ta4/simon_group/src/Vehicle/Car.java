package Vehicle;

import java.awt.geom.Point2D;
/**
 * @author Simon Pikalov
 * https://github.com/simon-pikalov
 */
public class Car extends MotorVehicle implements Driveble,java.io.Serializable {
    private Point2D pos ;
    public static int a = 5;


    public Car(Car c){
        super(c);
    }


    public void onlyCarFunction(){
        System.out.println("this is only car function ! ");
    }

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
        double timeToTravel = distance/(getMaxSpeed());
        return timeToTravel;

    }


    public static void main(String[] args) {
        MotorVehicle kiaPicanto = new Car("Kia","Picanto","409-94-301",959,173,5);
        MotorVehicle volvo9900 = new Bus("Volvo","9900","656-55-103",26500 ,120 ,52);
        //kiaPicanto.engine = kiaPicanto.new Engine(98000,"1.25 L Kappa","8574653"); if it were public
        kiaPicanto.setEngineKm(98000);
        kiaPicanto.setEngineName("1.25 L Kappa");
        kiaPicanto.setEngineId("8574653");
        System.out.println(kiaPicanto.getEngine());



    }

}
