package json;

import com.google.gson.*;
import vehicle.Car;


import java.lang.reflect.Type;

public  class MotorJson {
    static String star = "********************************";
    static boolean print = true;
    /**
     * Simple Serialization example
     */
    private static String carSerializeVehicle(){
        if(print)System.out.println(star+"carSerializeVehicle"+star+"\n");
        Car kiaPicanto = new Car("Kia", "Picanto", "409-94-301", 959, 173, 5);
        Gson gson = new Gson();
        String jsonS = gson.toJson(kiaPicanto);
        if(print)System.out.println(jsonS);
        return jsonS;
    }

    /**
     * Simple Deserialization example
     */
    private static void carDeSerialization(){
        if(print)System.out.println(star+"carDeSerialization"+star+"\n");
        String kiaJson = "{\"manufacturer\":\"Kia\",\"model\":\"Picanto\",\"registrationPlate\":\"409-94-301\",\"weight\":959.0,\"maxSpeed\":173,\"seats\":5}";
        String kiaJsonNice = "{'manufacturer':'Kia','model':'Picanto','registrationPlate':'409-94-301','weight':959.0,'maxSpeed':173,'seats':5}";
        Gson gson = new Gson();
        Car kia ;
        Car kiaNice ;
        kia = gson.fromJson(kiaJson,Car.class);
        kiaNice = gson.fromJson(kiaJsonNice,Car.class);
        if(print)System.out.println(kia);
        if(print)System.out.println(kiaNice);
    }

    /**
     * Nested Serialization example
     */
    private static void nestedCarSerializeVehicle(){
        if(print)System.out.println(star+"nestedCarSerializeVehicle"+star+"\n");
        Car kiaPicanto = new Car("Kia", "Picanto", "409-94-301", 959, 173, 5);
        kiaPicanto.setEngineId("0645343424");
        kiaPicanto.setEngineName("GDI turbo I3");
        Gson gson = new Gson();
        String jsonS = gson.toJson(kiaPicanto);
        if(print)System.out.println(jsonS);
    }


    /**
     * Nested Deserialization example
     */
    private static void nestedCarDeSerialization(){
        if(print)System.out.println(star+"nestedCarDeSerialization"+star+"\n");
        String kiaJson = "{\"manufacturer\":\"Kia\",\"model\":\"Picanto\",\"registrationPlate\":\"409-94-301\",\"weight\":959.0,\"maxSpeed\":173,\"seats\":5,\"engine\":{\"engineName\":\"GDI turbo I3\",\"id\":\"0645343424\"}}";
        Gson gson = new Gson();
        Car kia ;
        kia = gson.fromJson(kiaJson,Car.class);
        if(print)System.out.println(kia);

    }

    /**
     * Nested automatic Deserialization example - this method will return all fields empty !
     */
    private static void nestedCarDeSerializationAutoFail(){
        if(print)System.out.println(star+"nestedCarDeSerialization"+star+"\n");
        String kiaJson = "{\"car_producer\":\"Kia\",\"car_model\":\"Picanto\",\"car_id\":\"409-94-301\",\"car_weight\":959.0,\"car_max_speed\":173,\"car_seats\":5,\"engine_name\":\"GDI turbo I3\",\"engine_id\":\"0645343424\"}";
        System.out.println(kiaJson);
        Car kia ;
        Gson gson = new Gson();
        kia = gson.fromJson(kiaJson,Car.class);
        if(print)System.out.println(kia);
    }

    /**
     * Nested automatic Deserialization example.
     */

    private static void nestedCarDeSerializationManual(){
        if(print)System.out.println(star+"nestedCarDeSerializationManual"+star+"\n");
        String kiaJson = "{\"car_producer\":\"Kia\",\"car_model\":\"Picanto\",\"car_id\":\"409-94-301\",\"car_weight\":959.0,\"car_max_speed\":173,\"car_seats\":5,\"engine_name\":\"GDI turbo I3\",\"engine_id\":\"0645343424\"}";
        GsonBuilder gsonBuilder = new GsonBuilder();


        // change serialization for specific types
        JsonDeserializer<Car> deserializer = new JsonDeserializer<Car>() {
            @Override
            public Car deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                JsonObject jsonObject = json.getAsJsonObject();
                Car car = new Car(
                        jsonObject.get("car_producer").getAsString(),
                        jsonObject.get("car_model").getAsString(),
                        jsonObject.get("car_id").getAsString(),
                        jsonObject.get("car_weight").getAsInt(),
                        jsonObject.get("car_max_speed").getAsInt(),
                        jsonObject.get("car_seats").getAsInt()
                );

                car.setEngineName(jsonObject.get("engine_name").getAsString());
                car.setEngineId(jsonObject.get("engine_id").getAsString());
                return car;
            }};


        gsonBuilder.registerTypeAdapter(Car.class, deserializer);
        Gson customGson = gsonBuilder.create();
        Car car =  customGson.fromJson(kiaJson, Car.class);
        System.out.println(car);

    }




    public static void turnOffPrint(){
        print = false;
    }
    public static void turnOnPrint(){
        print = true;
    }

    public static void main(String[] args) {
        turnOnPrint();
        carSerializeVehicle();
        carDeSerialization();
        nestedCarSerializeVehicle();
        nestedCarDeSerialization();
        nestedCarDeSerializationAutoFail();
        nestedCarDeSerializationManual();
    }
}
