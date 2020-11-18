public class CounterThread extends Thread {
    private final Counter _counter;

    public CounterThread(Counter counter) {
        _counter = counter;
    }

    public void run() {
        for (int i = 0; i < 10000; i++) {
//            synchronized (_counter) {
                _counter.increment();
//            }
        }
    }
}
