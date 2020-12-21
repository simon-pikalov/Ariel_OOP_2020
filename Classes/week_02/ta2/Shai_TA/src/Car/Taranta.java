package Car;

public class Taranta extends GenericCar {
    public Taranta(int wheel_num, int door_num, CarColor c_color) {
        super(wheel_num, door_num, c_color);
        _top_speed = 0;
        _type = CarType.Sedan;
    }

    @Override
    public void moveVec(float mag, float angle) throws CarDontMove {
        throw new CarDontMove();
    }

    @Override
    public String specialMove() {
        return null;
    }
}
