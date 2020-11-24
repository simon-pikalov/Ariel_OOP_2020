package Lesson_5_Synch.threadStop;
class Infinit extends Thread{
	public void run() {
		StopInterrupt2.fun();
	}
}
public class StopInterrupt2 {
	public static void stopFun() throws InterruptedException {
		Infinit th = new Infinit();
		th.start();
		th.join(1000);
		if (th.isAlive()) throw new InterruptedException();
	}

	public static void fun() {
		while(true);
	}
	public static void main(String[] args) {
		try {
			StopInterrupt2.stopFun();
		} catch (InterruptedException e) {
			System.out.println("stop execution - infinity loop!");
			System.exit(1);
		}
	}
}
