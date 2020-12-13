package producer.consumer;

import java.util.LinkedList;
import java.util.Queue;

//https://dzone.com/
public class ProducerConsumerExample {

    static class Buffer {

        private Queue<Integer> list;
        private int size;

        public Buffer(int size) {
            this.list = new LinkedList<>();
            this.size = size;
        }

        public void add(int value) throws InterruptedException {
            synchronized (this) {
                while (list.size() >= size) {
                    wait();
                }
                list.add(value);
                notify();
            }
        }

        public int poll() throws InterruptedException {
            synchronized (this) {
                while (list.size() == 0) {
                    wait();
                }

                int value = list.poll();
                notify();
                return value;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Buffer buffer = new Buffer(2);

        Thread producerThread = new Thread(() -> {
            try {
                int value = 0;
                while (true) {

                    value = (int)(Math.random()*100);
                    buffer.add(value);
                    value = (int)(Math.random()*100);
                    buffer.add(value);
                    System.out.println("Produced " + value);
                    System.out.println("buffer after Produce :"+buffer.list.toString());

                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread consumerThread = new Thread(() -> {
            try {
                while (true) {
                    int value = buffer.poll();

                    System.out.println("Consume " + value);
                    System.out.println("buffer after  Consume :"+buffer.list.toString());
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

