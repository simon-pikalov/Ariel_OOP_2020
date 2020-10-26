package Car;

public class Mustang extends GenericCar {

    public Mustang(CarColor c_color){
        super(4,2,c_color);
        _top_speed = 20;
        _type = CarType.Sport;
    }

    @Override
    public String toString() {
        return "Mustang:\n\t" + super.toString();
    }

    @Override
    public String specialMove() {
        return "Going really fast and looking Good!";
    }

}
