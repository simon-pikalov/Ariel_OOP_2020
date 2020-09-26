import java.util.Comparator;
/**
 * @author Simon Pikalov
 * https://github.com/simon-pikalov
 */
public class MotorVehicleCompareFuelEconomy implements Comparator<MotorVehicle> {
    @Override
    public int compare(MotorVehicle t1, MotorVehicle t2) {
       return  Double.compare(t1.getFuelConsumption(),t2.getFuelConsumption());
    }
}
