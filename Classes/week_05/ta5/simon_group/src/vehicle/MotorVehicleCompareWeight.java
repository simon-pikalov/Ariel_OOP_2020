package vehicle;

import java.util.Comparator;
/**
 * @author Simon Pikalov
 * https://github.com/simon-pikalov
 */
public class MotorVehicleCompareWeight implements Comparator<MotorVehicle> {
    @Override
    public int compare(MotorVehicle t1, MotorVehicle t2) {
       return  Double.compare(t1.getWeight(),t2.getWeight());
    }
}
