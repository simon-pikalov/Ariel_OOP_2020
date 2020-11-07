package Vehicle;

import Vehicle.Bus;
import Vehicle.Car;
import Vehicle.MotorVehicle;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class MotorVehicleTest {
    private MotorVehicle car;
    private MotorVehicle bus;


    @BeforeEach
    void setUp() {
        System.out.println("Entered BeforeEach ");
        car = new Car("Kia","Picanto","409-94-301",959,173,5);
        bus = new Bus("Volvo","9900","656-55-103",26500 ,120 ,52);
    }

    @Test
    @DisplayName("Manufacturer Test <3")
    void getManufacturer() {
        String carManufacturer = "Kia";
        String busManufacturer = "Volvo";
        Assertions.assertEquals(carManufacturer,car.getManufacturer());
        Assertions.assertEquals(busManufacturer,bus.getManufacturer());
    }




    @org.junit.jupiter.api.Test
    void testWeight() {
        fail("not yed implemented");
       assertThrows(RuntimeException.class,()->car.setWeight(-1)); //example of an error -> good thing for development
        car.setWeight(100);
        assertEquals(100,car.getWeight());
    }

    @org.junit.jupiter.api.Test
    void testSeats() {
        try { // an ugly way for those who afraid of lambda
            car.setSeats(-1);
            fail();
        }
        catch (Exception e){
        }

    }





}

