package threads.basics;


public class AnonymousThreadTest {


    public static void main(String[] args) {

        Thread t1 = new Thread(){
            @Override
            public  void run(){
                while (true){
                    Thread.currentThread().setName("Anon Thread");
                    System.out.println("Hello from "+Thread.currentThread().getName());
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t1.start();

        Thread t2 = new Thread(()->{

            while (true){
                Thread.currentThread().setName("Lambda Thread");
                System.out.println("Hello from "+Thread.currentThread().getName());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });

        t2.start();


    }
}