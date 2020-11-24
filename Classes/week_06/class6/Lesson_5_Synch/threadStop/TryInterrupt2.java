package Lesson_5_Synch.threadStop;
class Task extends Thread{
	int i = 0;
	public void run() {
		while (true) {
			System.out.println(i++);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				System.out.println("exit Task");
				return;
			}
		}
	}
}
public class TryInterrupt2 {
	public static void main(String[] args) {

		Task task = new Task();
		task.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		task.interrupt();
		System.out.println("main exit");
	}

}
