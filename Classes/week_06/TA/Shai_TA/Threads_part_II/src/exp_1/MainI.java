import exp_1.Consumer;
import exp_1.DataCenter;
import exp_1.Producer;

import java.util.ArrayList;

public class MainI {
    public static void main(String[] args) throws InterruptedException {
        DataCenter data_center = new DataCenter();

        ArrayList<Thread> threads_lst = new ArrayList<>();
        // Producers
        threads_lst.add(new Producer(data_center));
        threads_lst.add(new Producer(data_center));
        threads_lst.add(new Producer(data_center));

        // Consumers
        threads_lst.add(new Consumer(data_center));
        threads_lst.add(new Consumer(data_center));

        for(Thread t: threads_lst){
        	t.start();
		}

		for(Thread t: threads_lst){
			t.join();
		}

		System.out.println("Done");
    }
}
