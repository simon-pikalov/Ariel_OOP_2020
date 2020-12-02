package producer.consumer;
//https://metanit.com/java/tutorial/8.5.php code taken from here.


import java.util.Random;

public class SimpleProducerConsumerExample {

    public static void main(String[] args) {
        Store store=new Store();
        Producer producer = new Producer(store);
        Consumer consumer = new Consumer(store);
        new Thread(producer).start();
        new Thread(consumer).start();
    }
}
// The Store class that have
class Store{
    private int product=0;
    public synchronized void get() { //method one synchronized function
        while (product<1) {
            try {
                wait();
            }
            catch (InterruptedException e) {
            }
        }
        product--;
        System.out.println("one product was bought");
        System.out.println("remaining products amount: " + product);
        notify();
    }
    public  void put() {
        synchronized (this){ ////method two synchronized block
        while (product>=3) { //generate a dead lock
            try {
                wait();
            }
            catch (InterruptedException e) {
            }
        }
        product++;
        System.out.println("one product was added");
        System.out.println("remaining products amount: " + product);
        notify();
    }}
}

class Producer implements Runnable{

    Store store;
    Producer(Store store){
        this.store=store;
    }
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
// Класс Потребитель
class Consumer implements Runnable {

    Store store;

    Consumer(Store store) {
        this.store = store;
    }

    public void run() {
        while (true){
            try {
                Thread.sleep((long)(Math.random()*(1000)));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            store.get();
        }
    }
}