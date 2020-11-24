public class Thread_101 extends Thread {
    public MyInt _c;
    public Thread_101(String name, MyInt c) {
        super(name);
        _c = c;
    }
    public void run() {
        System.out.println("**** "+
                super.getName()+"  Start!");
        for(int i=0;i<100000;i++) { _c.inc(); }
        System.out.println("**** "+
                super.getName()+"  Done!");
    }
}
