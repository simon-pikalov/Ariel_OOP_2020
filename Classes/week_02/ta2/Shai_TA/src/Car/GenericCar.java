package Car;

public abstract class GenericCar {

    protected final int _wheel_num;
    protected final int _door_num;
    protected final CarColor _c_color;
    protected Pos _pos = new Pos();
    protected CarType _type = CarType.Generic;
    protected float _top_speed = 10; // m/s

    public GenericCar() {
        _wheel_num = 0;
        _door_num = 0;
        _c_color = CarColor.BLUE;
    }

    public GenericCar(int wheel_num, int door_num, CarColor c_color) {
        _wheel_num = wheel_num;
        _door_num = door_num;
        _c_color = c_color;
    }

    public void setSpeed(float new_speed) {
        new_speed = Math.max(0, new_speed);
        _top_speed = new_speed;
    }

    @Override
    public String toString() {
        return "GenericCar{" +
                "_wheel_num=" + getWheelNum() +
                ", _door_num=" + getDoorNum() +
                ", _c_color=" + getColor() +
                ", _pos=" + getPosition() +
                ", _top_speed=" + _top_speed +
                '}';
    }

    public Pos getPosition() {
        return _pos;
    }

    public CarColor getColor() {
        return _c_color;
    }

    public void move(double x, double y){
        this.move((float) x, (float) y);
    }

    public void move(float x, float y) {
        double mag = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
        double angle = Math.atan2(y, x);
        moveVec(mag, angle);
    }

    public void moveVec(double mag, double angle) {
        mag = Math.min(mag, _top_speed);
        this.moveVec((float) mag, (float) angle);
    }

    public void moveVec(float mag, float angle) {
        double x = mag * Math.cos(angle);
        double y = mag * Math.sin(angle);
        _pos.x += x;
        _pos.y += y;
    }

    public int getDoorNum() {
        return _door_num;
    }

    public int getWheelNum() {
        return _wheel_num;
    }

    public abstract String specialMove();

    public CarType getType() {
        return _type;
    }
}
