package store.producer.consumer;

public class Producer implements Runnable{

    Store store;
    Producer(Store store){
        this.store=store;
    }
    @Override
    public void run(){
        while (true){
            try {
                Thread.sleep((long)(Math.random()*(1000)));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            store.put();
        }

    }
}