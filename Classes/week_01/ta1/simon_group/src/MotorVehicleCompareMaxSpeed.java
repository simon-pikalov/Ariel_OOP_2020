import java.util.Comparator;
/**
 * @author Simon Pikalov
 * https://github.com/simon-pikalov
 */
public class MotorVehicleCompareMaxSpeed implements Comparator<MotorVehicle>  {
    @Override
    public int compare(MotorVehicle m1, MotorVehicle m2) {
        return Double.compare(m1.getMaxSpeed(),m2.getMaxSpeed());
    }
}
