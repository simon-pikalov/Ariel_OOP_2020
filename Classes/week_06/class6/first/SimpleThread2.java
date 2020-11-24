package first;

class MyThread1 implements Runnable{
	String name;
	public MyThread1(String name){
		this.name = name;
	}
	@Override
	public void run() {
		int r = 500;
		for (int i=1; i<=5; i++){
			System.out.println("i = "+i+", current thread name = "+Thread.currentThread().getName()); 
			try{
				Thread.sleep(r);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}		
		System.out.println(name+ "  DONE!");
	}	
}
public class SimpleThread2{
	public static void main(String[] args) {
		Thread t1 = new Thread(new MyThread1("T1"));
		Thread t2 = new Thread(new MyThread1("T2"));
		t2.start();
		t1.start();
		try {
			Thread.sleep(1000);
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("t1 is alive? " + t1.isAlive());
		System.out.println("t2 is alive? " + t2.isAlive());
		System.out.println("current thread name: "+Thread.currentThread().getName());
		System.out.println("current thread is alive? "+Thread.currentThread().isAlive());
		try {
			Thread.sleep(1000);
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("t1 is alive? " + t1.isAlive());
		System.out.println("t2 is alive? " + t2.isAlive());
		System.out.println("main exit");
	}
}
