/**
 * This class represents a simple demo for using text files as logger.
 */
package class1;
public class FileLoggerTest {
    public static void main(String[] a) {
        test1();

    }
    public static void test1() {
        MyRandom r = new MyRandom(123);
        FileLogger fl = new FileLogger(); // date based (now) file name
        System.out.println("***** FileLogger - Tester: *****");
        fl.log("this is a first line");
        fl.log("second line");
        for(int i=0;i<100;i++) {
            String a = ""+i+","+r.nextGaussian();
            fl.log(a);
        }
        fl.close();
    }
}
