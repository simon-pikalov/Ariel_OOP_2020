package producer.consumer;


//https://dzone.com/

import java.util.concurrent.*;

public class ProducerConsumerExecutorService {

    public static void main(String[] args) {
        BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>(2);
        ExecutorService executor = Executors.newFixedThreadPool(2);

        Runnable producerTask = () -> {
            try {
                int value = 0;
                while (true) {
                    if(blockingQueue.size()<2){
                        value = (int)(Math.random()*100);
                        blockingQueue.put(value);
                    }

                    if(blockingQueue.size()<2){
                        value = (int)(Math.random()*100);
                        blockingQueue.put(value);
                    }
                    System.out.println("Produced " + value);
                    System.out.println("buffer after  Produce :"+blockingQueue.toString());

                    value++;

                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Runnable consumerTask = () -> {
            try {
                while (true) {
                    int value = blockingQueue.take();

                    System.out.println("Consume " + value);
                    System.out.println("buffer after  Consume :"+blockingQueue.toString());

                    Thread.sleep(1000);
                }

            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        executor.execute(producerTask);
        executor.execute(consumerTask);
        executor.shutdown();
    }
}