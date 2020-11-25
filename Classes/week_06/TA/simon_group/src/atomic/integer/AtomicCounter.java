package atomic.integer;

import java.util.concurrent.atomic.AtomicInteger;



public class AtomicCounter {
    //public   int count ; non safe without sync
    private AtomicInteger count = new AtomicInteger ();

    public AtomicCounter() {
       //this.count = 0; non safe without sync
        this.count = new AtomicInteger (0);;
    }


    public void increment (){
        count.incrementAndGet();
    }

    public long getCount() {
        return count.get();
    }


}