package Lesson_5_Synch.threadStop;
// Java Program to illustrate the 
//concept of interrupt() method 
//while a thread does not stops working 
class MyThread extends Thread { 
	public void run(){ 
		try { 
			for (int i = 0; i < 5; i++) { 
				System.out.println("Child Thread executing"); 

				// Here current threads goes to sleeping state 
				// Another thread gets the chance to execute 
				Thread.sleep(500); 
			} 
		} 
		catch (InterruptedException e) { 
			System.out.println("InterruptedException occur"); 
		} 
	} 
}  

public class MyClassInterrupt { 
	public static void main(String[] args) {// throws InterruptedException { 
		MyThread thread = new MyThread(); 
		thread.start(); 
		thread.interrupt();
		System.out.println("Main thread execution completes ,"+thread.isInterrupted()); 
	} 
}