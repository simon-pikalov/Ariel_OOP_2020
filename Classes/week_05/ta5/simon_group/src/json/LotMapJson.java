package json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import vehicle.Bus;
import vehicle.Car;
import vehicle.MotorVehicle;

import java.util.HashMap;

public class LotMapJson {
    static String star = "********************************";
    static boolean print = true;

    private static HashMap<String ,MotorVehicle> generateLotMap(){
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




    /**
     * Simple Serialization example
     */
    private static String lotSerializeVehicle(){
        if(print)System.out.println(star+"lotDeSerialization"+star+"\n");
        HashMap<String,MotorVehicle> lotMap= generateLotMap();
        Gson gson = new GsonBuilder().create();
        String json = gson.toJson(lotMap);
        if(print)System.out.println(json);
        return json;
    }

    /**
     * Simple Deserialization example
     */
    private static void lotDeSerialization(){
        String json = "{\"409-94-301\":{\"manufacturer\":\"Kia\",\"model\":\"Picanto\",\"registrationPlate\":\"409-94-301\",\"weight\":959.0,\"maxSpeed\":173,\"seats\":5,\"engine\":{\"engineName\":\"\",\"id\":\"\"}},\"479-08-801\":{\"manufacturer\":\"Chevrolet\",\"model\":\"Spark\",\"registrationPlate\":\"479-08-801\",\"weight\":1088.0,\"maxSpeed\":179,\"seats\":5,\"engine\":{\"engineName\":\"\",\"id\":\"\"}},\"548-38-301\":{\"manufacturer\":\"Hyndai\",\"model\":\"i10\",\"registrationPlate\":\"548-38-301\",\"weight\":952.0,\"maxSpeed\":163,\"seats\":5,\"engine\":{\"engineName\":\"\",\"id\":\"\"}},\"000-38-000\":{\"manufacturer\":\"Misubushi\",\"model\":\"space-star\",\"registrationPlate\":\"000-38-000\",\"weight\":865.0,\"maxSpeed\":173,\"seats\":5,\"engine\":{\"engineName\":\"\",\"id\":\"\"}},\"656-55-103\":{\"currPassengerCount\":0,\"manufacturer\":\"Volvo\",\"model\":\"9900\",\"registrationPlate\":\"656-55-103\",\"weight\":26500.0,\"maxSpeed\":120,\"seats\":52,\"engine\":{\"engineName\":\"\",\"id\":\"\"}}}\n";
        if(print)System.out.println(star+"lotDeSerialization"+star+"\n");
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        HashMap<String,MotorVehicle> lotMap = gson.fromJson(json, HashMap.class);;
        if(print)System.out.println(lotMap);
    }


    public static void turnOffPrint(){
        print = false;
    }
    public static void turnOnPrint(){
        print = true;
    }



    public static void main(String[] args) {
        turnOffPrint();
        lotSerializeVehicle();
        lotDeSerialization();

    }
}
