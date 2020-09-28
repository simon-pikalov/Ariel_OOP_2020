import java.awt.*;
import java.awt.geom.Point2D;
import java.util.LinkedList;

public class main {


//    private  static List<MotorVehicle> init(){
//
//    }

    public static void main(String[] args) {

        Car Mazda = new Car("Maza","mx5","025555531",0.8,43,120,4);
        System.out.println(Mazda);
        System.out.println(Mazda.drive(new Point2D.Double(0,0),new Point2D.Double(100,100)));

    }

}
