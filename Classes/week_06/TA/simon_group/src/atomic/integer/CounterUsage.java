package atomic.integer;

public class CounterUsage implements Runnable {

    Counter c;

    public CounterUsage() {
        Counter c = new Counter();
    }

    public CounterUsage(Counter c ) {
        this.c = c;
    }


//100000
    @Override
    public void run() {
        for (int i=0 ; i < 10000; i++){
            c.increment();
            //System.out.println(Thread.currentThread().getName()+" : "+c.count);
            //System.out.println(c.getCount());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        CounterUsage counterUsage = new CounterUsage(counter);
        CounterUsage counterUsageTwo = new CounterUsage(counter);
        Thread thread1 = new Thread(counterUsage);
        Thread thread2 = new Thread(counterUsageTwo);
//        thread1.setPriority(Thread.MAX_PRIORITY);
//        thread2.setPriority(Thread.MIN_PRIORITY);
        thread1.start();
        thread2.start();
       //while (thread1.isAlive()||thread2.isAlive()) {}
        thread1.join();
        thread2.join();
        System.out.println(counter.getCount());

    }
}
