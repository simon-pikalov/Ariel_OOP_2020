package store.producer.consumer;

// The Store class that have
public class Store{

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
                    e.printStackTrace();
                }
            }
            product++;
            System.out.println("one product was added");
            System.out.println("remaining products amount: " + product);
            notify();
        }}
}
