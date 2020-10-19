import java.awt.*;

/**
 * This interface represents a simple geometric shape,
 * with area, distance (Point2D),
 */
public interface shape {
    public double distance(Point_2D a);

    /**
     * This method translate the geometric shape according to the given vector
     * represented by a Point_2D as a vector (from .
     * @param vec
     */
    public void move(Point_2D vec);
    public double are();
    public double premiter();
    public boolean isInSide(Point_2D ot);
}
