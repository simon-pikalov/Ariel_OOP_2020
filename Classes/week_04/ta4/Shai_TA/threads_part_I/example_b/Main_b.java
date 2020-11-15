import java.util.ArrayList;

/**
 * Based on Yael Landau's code
 */

public class Main_b {
    public static void main(String[] args) throws InterruptedException {
        Counter c = new Counter();
        ArrayList<CounterThread> count_lst = new ArrayList<>();
        int count_n = 1000;
        for (int i = 0; i < count_n; ++i) {
            count_lst.add(new CounterThread(c));
        }
        for (CounterThread ct : count_lst) {
            ct.start();
        }

//		t1.join();
//		t2.join();
        while (true) {
//            System.out.println(c.getCounter());

            boolean all_dead = true;
            for (CounterThread ct : count_lst) {
                if (ct.isAlive()) {
                    all_dead = false;
                    break;
                }
            }
            if (all_dead) {
                break;
            }
        }

        System.out.println("Final Count:" + c.getCounter());
    }
}
