import exp_1.Consumer;
import exp_1.DataCenter;
import exp_1.Producer;

import java.util.ArrayList;

public class MainI {
    public static void main(String[] args) throws InterruptedException {
        DataCenter data = new DataCenter();

        ArrayList<Thread> threads_lst = new ArrayList<>();
        // Producers
        threads_lst.add(new Producer(data));
        threads_lst.add(new Producer(data));
        threads_lst.add(new Producer(data));

        // Consumers
        threads_lst.add(new Consumer(data));
        threads_lst.add(new Consumer(data));

        for(Thread t: threads_lst){
        	t.start();
		}

		for(Thread t: threads_lst){
			t.join();
		}

		System.out.println("Done");
    }
}
