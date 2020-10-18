//package class1;//package week1;
import java.util.ArrayList;

/**
 * This class represents a simple (not JUnןt) tester for the Random class
 Output example:
 ***** Test1: *****
 a[1]=17.0% , a[2]=17.89% , a[3]=17.39% , a[4]=14.7% , a[5]=15.8% , a[6]=17.2% ,

 Minor change - for testing


 */

public class RandomTest {
    public static void main(String[] a) {
        test1();
        test2();
        test3();
    }
    public static void test1() {
        System.out.println("***** Test1: *****");
        MyRandom r = new MyRandom(1);
        int[] arr = new int[7];
        double size = 1000;
        for(int i=0;i<size;i++) {
            int dd=r.randomInt(1,7); //[1,7)
            arr[dd]++;
        }
        for(int i=1;i<=6;i++) {
            double d =  (100.0 * arr[i]/size);
            d = ((int)(d*100.00))/100.0;
            System.out.print("a["+i+"]="+d+"% , ");
        }
        System.out.println();
    }
    public static void test2() {
        System.out.println();
        System.out.println("***** Test2: *****");
        int size = 1000;
        double sum=0, sum2=0;
        int seed = 12345;
        MyRandom r = new MyRandom(seed);
        ArrayList<Double> arr = new ArrayList<Double>();
        for(int i=0;i<size;i++) {
            double d = r.random();
            sum+=d;
            arr.add(d);
        }
        double ave = sum / size;
        for(int i=0;i<size;i++) {
            double dd = Math.abs(ave-arr.get(i));
            sum2 += dd;
        }
        double sd = sum2 / size;

        System.out.println("ave: "+ave+", sd: "+sd);
    }
    public static void test3() {
        System.out.println();
        System.out.println("***** Test3: *****");
        int size = 10000;
        double sum=0, sum2=0;
        int seed = 12345;
        int[] his = new int[100];
        MyRandom r = new MyRandom(seed);
        for(int i=0;i<size;i++) {
            double d = r.nextGaussian();
            double in = 50 + (d*10);
            his[(int)in]++;
        }
        for(int i=0;i<100;i++) {
            System.out.println(i+", "+his[i]+",");
        }
    }
}
