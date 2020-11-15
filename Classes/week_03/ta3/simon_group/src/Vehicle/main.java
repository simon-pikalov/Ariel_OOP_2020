package Vehicle;

import java.util.ArrayList;
import java.util.HashMap;

public class main {




    private static  HashMap<String ,MotorVehicle> generateLotMap(){

        Car kiaPicanto = new Car("Kia","Picanto","409-94-301",959,173,5);
        Car shevroletSpark = new Car("Chevrolet","Spark","479-08-801",1088,179,5);
        Car hundaI10 = new Car("Hyndai","i10","548-38-301",952,163,5);
        Car mitsubishSpaceStar = new Car("Misubushi","space-star","000-38-000",865,173,5);
        Bus volvo9900 = new Bus("Volvo","9900","656-55-103",26500 ,120 ,52);



        HashMap<String ,MotorVehicle> studentLot = new HashMap<String, MotorVehicle>();
        studentLot.put(kiaPicanto.getRegistrationPlate(),kiaPicanto);
        studentLot.put(shevroletSpark.getRegistrationPlate(),shevroletSpark);
        studentLot.put(hundaI10.getRegistrationPlate(),hundaI10);
        studentLot.put(mitsubishSpaceStar.getRegistrationPlate(),mitsubishSpaceStar);
        studentLot.put(volvo9900.getRegistrationPlate(),volvo9900);
        return studentLot;
    }
    private static ArrayList<MotorVehicle> generateLotList (){
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



    public static void showLot(CarLot lot){
        System.out.println("\n\n\n");
        System.out.println("*******************"+lot.getClass()+"*******************");
        System.out.println(lot.getAllVehicle());
        MotorVehicle light = lot.getLightestVehicle();
        System.out.println("lightest Vehicle is : "+light);
        MotorVehicle fast = lot.getFastestVehicle();
        System.out.println("fastest Vehicle is : "+fast);
        MotorVehicleCompareMaxSpeed maxSpeedComp = new MotorVehicleCompareMaxSpeed();
        ArrayList<MotorVehicle> sortedList = (ArrayList<MotorVehicle>) lot.getAllVehicleSorted(maxSpeedComp );
        System.out.println("Sorted list max speed :"+sortedList);
        MotorVehicleCompareWeight compWeight = new MotorVehicleCompareWeight();
        ArrayList<MotorVehicle> sortedListWeight = (ArrayList<MotorVehicle>) lot.getAllVehicleSorted(compWeight );
        System.out.println("Sorted list Weight :"+sortedListWeight);
        System.out.println("The unsorted "+lot.getAllVehicle());//show that the data-structure hasnt been changed
        System.out.println("\n\n\n");

    }



    public static void main(String[] args) {
        ArrayList <MotorVehicle> salfitLotList = new ArrayList<MotorVehicle>();
        salfitLotList = generateLotList();
        SalfitLot salfitLot = new SalfitLot(salfitLotList);
        showLot(salfitLot);

        HashMap<String ,MotorVehicle> arielLotMap = generateLotMap();
        ArielLot arielLot = new ArielLot(arielLotMap);
        showLot(arielLot);

        System.out.println("my for : ");
        for(MotorVehicle m : arielLot){
            System.out.println(m);
        }

    }

}