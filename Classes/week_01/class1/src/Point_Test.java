import java.awt.*;
import java.util.ArrayList;

public class Point_Test {
    public static void main(String[] a) {
        test1();
        test2();
    }
    public static void test1() {
        Point_2D p1 = new Point_2D(1,2.3);
        Object p2 = new Point_2D(p1);
        shape p3 = new Point_2D(p1);
        String t = p2.getClass().getName();
        System.out.println(p2.toString()+"  "+t);
        p2 = new String("123rr");
        p1 = null;
        t = p2.getClass().getName();
        System.out.println(p2.toString()+"  "+t);
    }
    public static void test2() {
        ArrayList<shape> shapes = new ArrayList<shape>();
    }
}
