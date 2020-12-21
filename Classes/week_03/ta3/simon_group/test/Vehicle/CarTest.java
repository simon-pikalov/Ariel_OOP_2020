package Vehicle;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import Vehicle.Bus;
import Vehicle.Car;
import Vehicle.MotorVehicle;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
public class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        System.out.println("Entered BeforeEach ");
        car = new Car("Kia","Picanto","409-94-301",959,173,5);
    }

    @Test
    @DisplayName("file.txt test &*&*&*")
    void checkEqOfTwoCars() {
        Car other =new Car(car);
        assertEquals(car,other,"not equal :(");
    }

}
