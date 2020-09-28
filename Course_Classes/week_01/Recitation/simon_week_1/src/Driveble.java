import java.awt.geom.Point2D;

public interface Driveble {


    /**
     *
     * @param src 2d Source point
     * @param dst 2d destination point
     * @return the time for the trip
     * This function make the car drive from sec to dst with respect to it's fuel constipation and fuel capacity
     */
    public double drive(Point2D src, Point2D dst);


}
