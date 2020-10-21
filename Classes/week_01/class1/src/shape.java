import java.awt.*;

/**
 * This interface represents a simple geometric shape,
 * with area, distance (Point2D),
 */
public interface shape {
    /** computes a none negative value (distance) between the closest
     * point on this shape and the querey point ot
     *
     * @param ot
     * @return
     */
    public double distance(Point_2D ot);

    /**
     * This method translate the geometric shape according to the given vector
     * represented by a Point_2D as a vector (from .
     * @param vec
     */
    public void move(Point_2D vec);
    public double area();
    public double perimeter();
    public boolean isInSide(Point_2D ot);
}
