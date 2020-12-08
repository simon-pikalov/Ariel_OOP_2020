package producer.consumer;

//https://dzone.com/

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class ProducerConsumerWithBlockingQueue {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> blockingQueue = new LinkedBlockingDeque<>(2);

        Thread producerThread = new Thread(() -> {
            try {
                int value = 0;
                while (true) {
                    value = (int) (Math.random() * 100);
                    blockingQueue.put(value);
                    value = (int) (Math.random() * 100);
                    blockingQueue.put(value);
                    System.out.println("Produced " + value);
                    System.out.println("buffer after  Produce :" + blockingQueue.toString());


                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread consumerThread = new Thread(() -> {
            try {
                while (true) {
                    int value = blockingQueue.take();

                    System.out.println("Consume " + value);
                    System.out.println("buffer after  Consume :" + blockingQueue.toString());

                    Thread.sleep(1000);
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        producerThread.start();
        consumerThread.start();
        producerThread.join();
        consumerThread.join();
    }
}