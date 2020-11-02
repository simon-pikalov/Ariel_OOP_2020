import Car.*;

import java.util.ArrayList;

public class main {

    public static void main(String[] args) throws CarDontMove {
        GenericCar gen_car = new GenericCar(3, 2, CarColor.RAINBOW) {
            @Override
            public String specialMove() {
                return "Nothing really";
            }
        };
        Mustang mustang = new Mustang(CarColor.RAINBOW);
        GenericCar taranta = new Taranta(3, 2, CarColor.ORANGE);

        ArrayList<GenericCar> car_arr = new ArrayList<>();
        car_arr.add(gen_car);
        car_arr.add(mustang);
        car_arr.add(taranta);

        for (GenericCar gc : car_arr) {
            gc.moveVec(20, Math.toRadians(90));
            System.out.println(gc);
        }

//        for (int i = 0; i < car_arr.size() + 1; ++i) {
//            GenericCar gc = null;
//            try {
//                gc = car_arr.get(i);
//                i = i / 0;
//            }
//            catch (IndexOutOfBoundsException e) {
//                System.err.println(e.getMessage());
//                gc = car_arr.get(i % car_arr.size());
//            }
//            catch(Exception e){
//                System.err.println("Exception");
//            }
//            System.out.println(gc.getType() + ":");
//            System.out.println("\t" + gc.specialMove());
//        }

        System.out.println("\n\nThat's it folks..");
    }
}
