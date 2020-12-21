package Vehicle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class ArielLotTest {

    private ArielLot lot;
    String filename = "lot.ser";

    @BeforeEach
    void init(){

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
        lot = new ArielLot(studentLot);
    }

    @Test
    void saveCars() {
        lot.saveCars(filename);

    }

    @Test
    void loadCars() {
        lot = new ArielLot();
        lot.loadCars(filename);
    }

    @Test
    void eq(){
        lot.saveCars(filename);
        ArielLot loaded = new ArielLot();
        loaded.loadCars(filename);
        assertEquals(lot,loaded);
    }

}