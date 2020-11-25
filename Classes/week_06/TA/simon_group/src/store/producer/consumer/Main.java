package store.producer.consumer;
//https://metanit.com/java/tutorial/8.5.php code taken from here.


 class Main { //package private class

    public static void main(String[] args) {
        Store store=new Store();
        Producer producer = new Producer(store);
        Consumer consumer = new Consumer(store);
        new Thread(producer).start();
        new Thread(consumer).start();
    }

}