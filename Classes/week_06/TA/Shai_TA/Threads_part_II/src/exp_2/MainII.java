import exp_2.Task;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainII {
    // Maximum number of threads in thread pool
    static final int kMAX_SIZE = 3;
    static final int kNUM_TASK = 15;
    public static void main(String[] args) {
        ArrayList<Runnable> run_arr = new ArrayList<>();
        for (int i = 0; i < kNUM_TASK; ++i) {
           run_arr.add(new Task("Task " + i));
        }

        ExecutorService pool = Executors.newFixedThreadPool(kMAX_SIZE);

        for(Runnable tmp_run : run_arr){
        	pool.execute(tmp_run);
		}
        pool.shutdown();
    }
} 
