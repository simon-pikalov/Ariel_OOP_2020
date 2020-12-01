package producer.consumer;

import java.util.LinkedList;
import java.util.Queue;
//https://dzone.com/
public class ProducerConsumerExample2 {

    public static void main(String[] args) throws InterruptedException {
        Buffer buffer = new Buffer(2);

        Thread producerThread = new Thread(() -> {
            try {
                int value = 0;
                while (true) {
                    buffer.add(value);

                    System.out.println("Produced " + value);

                    value ++;

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

}

