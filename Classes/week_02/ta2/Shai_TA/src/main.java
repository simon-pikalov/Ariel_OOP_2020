import Car.*;

import java.util.ArrayList;

public class main {

    public static void main(String[] args) {
        GenericCar gen_car = new GenericCar(3, 2, CarColor.RAINBOW) {
            @Override
            public String specialMove() {
                return "Drive on sunny days";
            }
        };
        GenericCar mustang = new Mustang(CarColor.RAINBOW);
        GenericCar taranta = new Taranta(3,2,CarColor.ORANGE);

        ArrayList<GenericCar> car_arr = new ArrayList<>();
        car_arr.add(gen_car);
        car_arr.add(mustang);
        car_arr.add(taranta);

        for (GenericCar gc : car_arr) {
            try {
                gc.moveVec(20, Math.toRadians(90));
                System.out.println(gc);
            } catch (CarDontMove e){
                e.printStackTrace();
            }
        }

        for (GenericCar gc : car_arr) {
            System.out.println(gc.getType() + ":");
            System.out.println("\t" + gc.specialMove());
        }
    }
}
