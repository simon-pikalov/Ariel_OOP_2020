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

        ThreadExtends t1 = new ThreadExtends();
        ThreadExtends t2 = new ThreadExtends();
        t1.start();
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
