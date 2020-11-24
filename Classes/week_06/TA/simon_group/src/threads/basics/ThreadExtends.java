package threads.basics;


public class ThreadExtends extends Thread {

    @Override
    public void run() {
        while (true){
            System.out.println("Hello from "+Thread.currentThread().getName());
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String args[]) {
        RunnableDemo r1 = new RunnableDemo();
        Thread t1 = new Thread(r1);
        t1.setName("t1");
        t1.start();

        Runnable r2 = new RunnableDemo();
        Thread t2 = new Thread(r2);
        t2.setName("t2");
        t2.start();

        while (true){
            System.out.println("Hello from "+Thread.currentThread().getName());
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
