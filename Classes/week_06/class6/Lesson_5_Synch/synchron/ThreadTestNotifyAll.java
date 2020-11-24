package Lesson_5_Synch.synchron;

public class ThreadTestNotifyAll implements Runnable {
	final static private Object shared=new Object();
	private int type, num;
	public ThreadTestNotifyAll(int i, int num) {
		type=i;
		this.num = num;
	}

	public void run() {
		if (type>=0 && type<num) {
			synchronized (shared) {
				try {
					shared.wait();
				} catch (InterruptedException e) {}
				System.out.println("Thread "+type+" after wait()");
			}
		} else {
			synchronized (shared) {
				shared.notifyAll();
				//shared.notify();
				System.out.println("Thread "+type+" after notifyAll()");
			}
		}
	}
	public static void test(){
		int num = 3;
		Thread threads[] =  new Thread[10];
		for(int i=0; i<num; i++){
			threads[i] = new Thread(new ThreadTestNotifyAll(i, num));
		}
		for(int i=0; i<num; i++){
			threads[i].start();
		}
		System.out.println("all threads are started");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {}
		for(int i=0; i<num; i++){
			System.out.println(threads[i].getName() + "  isAlive? "+threads[i].isAlive());
		}
		Thread t = new Thread(new ThreadTestNotifyAll(num, num));
		t.start();
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {}
		System.out.println();
		for(int i=0; i<num; i++){
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for(int i=0; i<num; i++){
			System.out.println(threads[i].getName()+" isAlive? "+threads[i].isAlive());
		}
	}
	
	
	public static void main(String s[]) {
		test();
	}
}