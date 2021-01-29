package q3;


import java.util.LinkedList;
import java.util.List;

public class MultiAnswer {
    Long value;
    final static Object lock = new Object(); // the object that the lock ig going to be made on

    public MultiAnswer() {
        this.value = (long) -1; //  -1 mean that the value is not answered
    }

    long m1(List<String> a) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return a.size();
    }

    long m2(List<String> a) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println();
        return a.size();
    }

    long m12(List<String> a) {
        //Anonymous thread 1
        Runnable taskM1 = new Runnable() {
            @Override
            public void run() {
                long tempAns = m1(a);
                synchronized (lock) {
                    if (value == -1) {
                        value = tempAns;
                        lock.notify();
                        System.out.println("m1 ans is " + value);
                    } else {
                        System.out.println("m1 : value is already not -1 , nothing to be done");
                    }

                }
            }
        };

        //Anonymous thread 2
        Runnable taskM2 = new Runnable() {
            @Override
            public void run() {
                long tempAns = m2(a);
                synchronized (lock) {
                    if (value == -1) {
                        value = tempAns;
                        lock.notify();
                        System.out.println("m2 ans is " + value);
                    } else {
                        System.out.println("m2 :value is already not -1 , nothing to be done");
                    }
                }

            }
        };

        Thread t1 = new Thread(taskM1);
        Thread t2 = new Thread(taskM2);

        t2.start();
        t1.start();
        synchronized (lock) {
            System.out.println("starting wait");
            while (value == -1) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        return value;

    }


    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        list.add("1");
        list.add("2");
        list.add("1");
        list.add("1");
        MultiAnswer ma = new MultiAnswer();
        System.out.println("ans is " + ma.m12(list));
    }
}
