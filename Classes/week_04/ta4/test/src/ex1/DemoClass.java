package ex1;

public class DemoClass {

    public DemoClass(){
        Class cls = getClass();
        System.out.println("This is my Package: " + cls.getPackageName());
    }
}
