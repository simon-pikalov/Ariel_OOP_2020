import java.util.ArrayList;
import java.util.HashMap;

public class main {




    private static  HashMap<String ,MotorVehicle> generateLotMap(){
        Car kiaPicanto = new Car("Kia","Picanto","409-94-301",959,173,35,5);
        Car shevroletSpark = new Car("Chevrolet","Spark","479-08-801",1088,179,35,5);
        Car hundaI10 = new Car("Hyndai","i10","548-38-301",952,163,40,5);
        Car mitsubishSpaceStar = new Car("Misubushi","space-star","000-38-000",865,173,35,5);
        Bus Volvo9900 = new Bus("Volvo","9900","656-55-103",26500 ,120,480 ,52);

        HashMap<String ,MotorVehicle> studentLot = new HashMap<String, MotorVehicle>();
        studentLot.put(kiaPicanto.getRegistrationPlate(),kiaPicanto);
        studentLot.put(shevroletSpark.getRegistrationPlate(),shevroletSpark);
        studentLot.put(hundaI10.getRegistrationPlate(),hundaI10);
        studentLot.put(mitsubishSpaceStar.getRegistrationPlate(),mitsubishSpaceStar);
        studentLot.put(Volvo9900.getRegistrationPlate(),Volvo9900);
        System.out.println(studentLot);

        return studentLot;
    }
    private static ArrayList<MotorVehicle> generateLotList (){
        Car kiaPicanto = new Car("Kia","Picanto","409-94-301",959,173,35,5);
        Car shevroletSpark = new Car("Chevrolet","Spark","479-08-801",1088,179,35,5);
        Car hundaI10 = new Car("Hyndai","i10","548-38-301",952,163,40,5);
        Car mitsubishSpaceStar = new Car("Misubushi","space-star","000-38-000",865,173,35,5);
        Bus Volvo9900 = new Bus("Volvo","9900","656-55-103",26500 ,120,480 ,52);

        ArrayList <MotorVehicle> list = new ArrayList<MotorVehicle>();
        list.add(kiaPicanto);
        list.add(shevroletSpark);
        list.add(hundaI10);
        list.add(mitsubishSpaceStar);
        list.add(Volvo9900);


        return list;
    }



    public static void main(String[] args) {



        ArrayList <MotorVehicle> salfitLotList = new ArrayList<MotorVehicle>();
        salfitLotList = generateLotList();
        SalfitLot salfitLot = new SalfitLot();
        salfitLot.setLot(salfitLotList);


        System.out.println("*******************Ariel Lot*******************");
        ArielLot arielLot = new ArielLot();
        HashMap<String ,MotorVehicle> arielLotMap = generateLotMap();
        arielLot.setLot(arielLotMap);
        System.out.println(arielLotMap);
        MotorVehicle light = arielLot.getLightestVehicle();
        System.out.println("lightest Vehicle is : "+light);
        MotorVehicle fast = arielLot.getFastestVehicle();
        System.out.println("fastest Vehicle is : "+fast);

        System.out.println("*******************Salfit Lot*******************");
        System.out.println(salfitLotList);
         light = salfitLot.getLightestVehicle();
        System.out.println("lightest Vehicle is : "+light);
         fast = salfitLot.getFastestVehicle();
        System.out.println("fastest Vehicle is : "+fast);
        MotorVehicleCompareMaxSpeed maxSpeedComp = new MotorVehicleCompareMaxSpeed();
        ArrayList<MotorVehicle> sortedList = (ArrayList<MotorVehicle>) salfitLot.getAllVehicleSorted(maxSpeedComp );
        System.out.println("Sorted list max speed :"+sortedList);
        MotorVehicleCompareWeight compWeight = new MotorVehicleCompareWeight();
        ArrayList<MotorVehicle> sortedListWeight = (ArrayList<MotorVehicle>) salfitLot.getAllVehicleSorted(compWeight );
        System.out.println("Sorted list Weight :"+sortedListWeight);
    }

}
