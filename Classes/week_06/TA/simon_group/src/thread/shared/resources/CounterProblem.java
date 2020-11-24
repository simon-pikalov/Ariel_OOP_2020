package thread.shared.resources;

public class CounterProblem {

    class Counter implements Runnable {
        private Integer count = 0;

        @Override
        public void run() {
            for(int i = 0; i < 10000; i++) {
                increment();
            }
        }
//        //      THIS GIVES 20000 which is correct every time.
//        public synchronized void increment() {
//            count++;
//        }

      public void increment() {
          synchronized(count) {
              count++;
          }
      }
    }
    public static void main(String[] args) throws InterruptedException {
        CounterProblem counterProblem = new CounterProblem();
        Counter counter = counterProblem.new Counter();
        Thread thread1 = new Thread(counter);
        Thread thread2 = new Thread(counter);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(counter.count);
    }
}