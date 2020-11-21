package threads;


public class AnonymousThreadTest {


    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("Anonymous Thread  ");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start(); // end of Anonymous class


        new Thread(() -> {
            while (true) {
                System.out.println("Anonymous Thread Lambda ");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }).start();

    }
}