package atomic.integer;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter {
    public AtomicInteger count; // java Thread safe Integer

    public Counter() {
        this.count = new AtomicInteger(0);
    }

    public void increment() {
        count.incrementAndGet();
    } // no need to sync due to use of AtomicInteger

    public int getCount() {
        return count.get();
    }
}