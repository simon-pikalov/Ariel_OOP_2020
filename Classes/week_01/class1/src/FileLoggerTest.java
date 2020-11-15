//package class1;

/**
 * This class represents a simple demo for using text files as logger.
 */
//package week1
public class FileLoggerTest {
    public static void main(String[] a) {
        test1();

    }
    public static void test1() {
        MyRandom r = new MyRandom(123);
        FileLogger fl = new FileLogger("1.txt"); // date based (now) file name
        System.out.println("***** class1.FileLogger - Tester: *****");
        fl.log("this is a first line 123");
        fl.log("second line");
        for(int i=0;i<100;i++) {
            String a = ""+i+","+r.nextGaussian();
            fl.log(a);
        }
        fl.close();
    }
}
