package store.producer.consumer;


public class Consumer implements Runnable {

    Store store;

    Consumer(Store store) {
        this.store = store;
    }
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep((long) (Math.random() * (1000)));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            store.get();
        }
    }
}
