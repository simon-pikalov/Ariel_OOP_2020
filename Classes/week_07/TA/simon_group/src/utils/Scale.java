package utils;


public class Scale {

    /**
     *
     * @param data denote some data to be scaled
     * @param r_min the minimum of the range of your data
     * @param r_max the maximum of the range of your data
     * @param t_min the minimum of the range of your desired target scaling
     * @param t_max the maximum of the range of your desired target scaling
     * @return
     */
    private double scale(double data, double r_min, double r_max,
                         double t_min, double t_max)
    {
        double res = ((data - r_min) / (r_max-r_min)) * (t_max - t_min) + t_min;
        return res;

        //32.343434343 -> 100
        //33.0001


    }

}
