package Car;

public class Mustang extends GenericCar {

    public Mustang(CarColor c_color){
        super(4,2,c_color);
        _top_speed = 20;
        _type = CarType.Sport;
    }

    @Override
    public String toString() {
        return "Mustang{" +
                "_wheel_num=" + _wheel_num +
                ", _door_num=" + _door_num +
                ", _c_color=" + _c_color +
                ", _pos=" + _pos +
                ", _top_speed=" + _top_speed +
                '}';
    }

    @Override
    public String specialMove() {
        return "Going really fast and looking Good!";
    }

}
