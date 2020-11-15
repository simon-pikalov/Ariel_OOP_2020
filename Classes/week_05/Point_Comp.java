import java.util.Comparator;

public class Point_Comp implements Comparator<Point3D> {

    public Point_Comp() {;}
    @Override
    public int compare(Point3D o1, Point3D o2) {
        int ans = 0;
        double d1 = o1.distance3D();
        double d2 = o2.distance3D();
        if(d1<d2) {ans = -1;}
        if(d1>d2) {ans = 1;}
        return ans;
    }
}
