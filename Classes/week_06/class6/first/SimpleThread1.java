package first;

class MyThread extends Thread{
	public MyThread(String name){
		super(name);
	}
	public void run() {
		for (long i=1; i<=5; i++) {
			System.out.println("i = "+i+"  "+this.getName() + " Priority: "+this.getPriority());
/*			try {
				sleep(500);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
*/		}
		System.out.println(this.getName()+ "  DONE!");
	} 
}

public class SimpleThread1 {

	public static void main(String[] args) {
		MyThread t1 = new MyThread("T1");
		System.out.println("t1 State:  " + t1.getState());
		MyThread t2 = new MyThread("T2");
		System.out.println("t2 State:  " + t2.getState());
		t1.setPriority(Thread.MAX_PRIORITY);
		t2.setPriority(Thread.MIN_PRIORITY);
		t1.start();
		t2.start();
		System.out.println("t1 State:  " + t1.getState());
		System.out.println("t2 State:  " + t2.getState());
		for(int i=1; i<=10; i++)
			System.out.println("main after t1.start & t2.start");
/*		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
*/		System.out.println("t1 State:  " + t1.getState());
		System.out.println("t2 State:  " + t2.getState());
		System.out.println("main exit");
	}

}
