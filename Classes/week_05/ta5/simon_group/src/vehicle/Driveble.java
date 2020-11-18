package vehicle;

import java.awt.geom.Point2D;
/**
 * @author Simon Pikalov
 * https://github.com/simon-pikalov
 */
public interface Driveble {


    /**
     *
     * @param p set the position of vehicle to p
     */
    public void initPos(Point2D p);


    /**
     *
     * @return return the position of the vehicle
     */
    public Point2D getPos();


    /**
     *
     * @param dst 2d destination point
     * @return the time for the trip
     * This function make the car drive from sec to dst with respect to it's fuel constipation and fuel capacity
     */
    public double drive( Point2D dst);


}
