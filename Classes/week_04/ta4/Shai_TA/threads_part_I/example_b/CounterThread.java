public class CounterThread extends Thread {
    private Counter c;

    public CounterThread(Counter c) {
        this.c = c;
    }

    public void run() {
        for (int i = 0; i < 100; i++) {
//            System.out.println(c.getCounter());
//            synchronized (c) {
                c.increment();
//            }
        }
    }
}
