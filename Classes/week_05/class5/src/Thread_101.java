public class Thread_101 extends Thread {
    public Thread_101(String name) {
        super(name);
    }
    public void run() {
        System.out.println("**** "+
                super.getName()+"  Start!");
        for(int i=0;i<20;i++) {
            System.out.print(""+i+") ");
            for(int j=0;j<10;j++) {
                System.out.print(super.getName());
                 //    try{ sleep(1); }
                 //    catch(Exception e ) {e.printStackTrace();}
            }
            System.out.println();
        }
        System.out.println("**** "+
                super.getName()+"  Done!");
    }
}
