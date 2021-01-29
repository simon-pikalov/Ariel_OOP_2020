package q3;


import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class MultiAnswer {
    private Long value;
    private final AtomicBoolean isFinished;

    public MultiAnswer() {
        isFinished = new AtomicBoolean(false);// false mean that the value is not answered
        this.value = (long) -1;
    }


    private synchronized void setValue(long value) {
        if (isFinished.get()) return;
        this.value = value;
        isFinished.set(true);
    }

    long m1(List<String> a) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return a.size();
    }

    long m2(List<String> a) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return a.size();
    }

    long m12(List<String> a) {
        isFinished.set(false);
        //Anonymous thread 1
        Runnable taskM1 = new Runnable() {
            @Override
            public void run() {
                long tempAns = m1(a); // run m1
                synchronized (a) {
                    if (!isFinished.get()) { // if not finished
                        setValue(tempAns);
                        a.notify();
                        System.out.println("m1 ans is " + value);
                    } else {
                        System.out.println("m1 : isFinished is true, nothing to be done");
                    }
                }
            }
        };

        //Anonymous thread 2
        Runnable taskM2 = new Runnable() {
            @Override
            public void run() {
                long tempAns = m2(a); // run m2
                synchronized (a) {
                    if (!isFinished.get()) { // if not finished
                        setValue(tempAns);
                        a.notify();
                        System.out.println("m2 ans is " + value);
                    } else {
                        System.out.println("m2 : isFinished is true, nothing to be done");
                    }
                }

            }
        };

        Thread t1 = new Thread(taskM1);
        Thread t2 = new Thread(taskM2);
        t2.start();
        t1.start();
        synchronized (a) {
            System.out.println("starting wait");
            while (!isFinished.get()) {
                try {
                    a.wait();
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
