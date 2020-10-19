public class Circle_2D implements shape {
    private double _radius;
    private Point_2D _center;

    public Circle_2D(Point_2D cen, double rad) {
        _center = new Point_2D(cen);
        _radius = rad;
    }
    public Circle_2D(Circle_2D ot) {
        this(ot._center, ot._radius);
    }
    @Override
    public double distance(Point_2D a) {
        double ans = 0;
        double d = a.distance(_center) - _radius;
        ans = Math.max(d,0);
        return ans;
    }

    @Override
    public void move(Point_2D vec) {

    }

    @Override
    public double area() {
        return Math.PI*_radius*_radius;
    }

    @Override
    public double premiter() {
        return Math.PI*2*_radius;
    }

    /**
     *
     * @param ot query Point
     * @return true iff the query point falls within this circle.
     */
    @Override
    public boolean isInSide(Point_2D ot) {
        return _center.distance(ot)<=_radius;
    }
}
