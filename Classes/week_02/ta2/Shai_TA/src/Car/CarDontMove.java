package Car;

public class CarDontMove extends Exception {
    public CarDontMove() {
        super("Car Cannot Move! Find other car or walk!!");
    }
}
