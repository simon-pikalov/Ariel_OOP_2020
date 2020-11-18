import java.util.ArrayList;

/**
 * Based on Yael Landau's code
 */

public class Main_b {

    /**
     * Checks if all the threads have ended
     * @param ct_lst List of all Threads
     * @return True if all threads have ended, else False
     */
    public static boolean allDead(ArrayList<CounterThread> ct_lst){
        for (CounterThread ct : ct_lst) {
            if (ct.isAlive()) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Counter c = new Counter();
        ArrayList<CounterThread> count_lst = new ArrayList<>();

        // Create new threads
        int count_n = 10000;
        for (int i = 0; i < count_n; ++i) {
            count_lst.add(new CounterThread(c));
        }

        // Start the threads
        for (CounterThread ct : count_lst) {
            ct.start();
        }

        do {
            System.out.println(c.getCounter());
        } while (!allDead(count_lst));

        System.out.println("Final Count:" + c.getCounter());
    }
}
