import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class main {


    private static  HashMap<String ,Driveble> generateLotMap(){
        Car kiaPicanto = new Car("Kia","Picanto","409-94-301",959,173,5);
        Car shevroletSpark = new Car("Chevrolet","Spark","479-08-801",1088,179,5);
        Car hundaI10 = new Car("Hyndai","i10","548-38-301",952,163,5);
        Car mitsubishSpaceStar = new Car("Misubushi","space-star","000-38-000",865,173,5);
        Bus volvo9900 = new Bus("Volvo","9900","656-55-103",26500 ,120 ,52);

        HashMap<String ,Driveble> studentLot = new HashMap<String, Driveble>();

        studentLot.put(kiaPicanto.getRegistrationPlate(),kiaPicanto);
        studentLot.put(shevroletSpark.getRegistrationPlate(),shevroletSpark);
        studentLot.put(hundaI10.getRegistrationPlate(),hundaI10);
        studentLot.put(mitsubishSpaceStar.getRegistrationPlate(),mitsubishSpaceStar);
        studentLot.put(volvo9900.getRegistrationPlate(),volvo9900);
        System.out.println(studentLot);

        


        return studentLot;
    }
    private static ArrayList<Driveble> generateDrivableList (){
        Driveble kiaPicanto = new Car("Kia","Picanto","409-94-301",959,173,5);
        Driveble shevroletSpark = new Car("Chevrolet","Spark","479-08-801",1088,179,5);
        Driveble hundaI10 = new Car("Hyndai","i10","548-38-301",952,163,5);
        Driveble mitsubishSpaceStar = new Car("Misubushi","space-star","000-38-000",865,173,5);
        Driveble volvo9900 = new Bus("Volvo","9900","656-55-103",26500 ,120 ,52);
        ArrayList <Driveble> list = new ArrayList<Driveble>();

        list.add(kiaPicanto);
        list.add(shevroletSpark);
        list.add(hundaI10);
        list.add(mitsubishSpaceStar);
        list.add(volvo9900);
        return list;
    }


    private static ArrayList<MotorVehicle> generateMotorVehicleList (){
        Car kiaPicanto = new Car("Kia","Picanto","409-94-301",959,173,5);
        Car shevroletSpark = new Car("Chevrolet","Spark","479-08-801",1088,179,5);
        Car hundaI10 = new Car("Hyndai","i10","548-38-301",952,163,5);
        Car mitsubishSpaceStar = new Car("Misubushi","space-star","000-38-000",865,173,5);
        Bus volvo9900 = new Bus("Volvo","9900","656-55-103",26500 ,120 ,52);
        ArrayList <MotorVehicle> list = new ArrayList<MotorVehicle>();
        list.add(kiaPicanto);
        list.add(shevroletSpark);
        list.add(hundaI10);
        list.add(mitsubishSpaceStar);
        list.add(volvo9900);
        return list;
    }




    public static void main(String[] args) {
        System.out.println("\n\n***************************Driveble***************************\n\n");
        ArrayList <Driveble> drivebleArrayList ;
        drivebleArrayList = generateDrivableList();
        for(Driveble d :drivebleArrayList){
            d.initPos(new Point2D.Double(0,0));
            double time = d.drive(new Point2D.Double(100,100));
            System.out.println(d+" "+time);
        }
        System.out.println("\n\n***************************MotorVehicle***************************\n\n");
        ArrayList <MotorVehicle> motorArrayList = new ArrayList<MotorVehicle>();
        motorArrayList = generateMotorVehicleList();
        for(MotorVehicle m :motorArrayList){
            System.out.println(m.getWeight());







            ///


            //test
            HashMap<String,Driveble> map= generateLotMap();
            map.values();

        }





    }

}
