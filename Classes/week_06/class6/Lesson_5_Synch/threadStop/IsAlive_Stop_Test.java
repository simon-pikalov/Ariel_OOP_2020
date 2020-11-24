package Lesson_5_Synch.threadStop;
class FirstThread extends Thread{
	public FirstThread(String name){
		super(name);
	}
	private boolean keepGoing = true;
	public void setKeepGoing(boolean keepGoing){
		this.keepGoing = keepGoing;
	}
	@Override
	public void run(){
		int i = 1;
		while (keepGoing){
			try{
				System.out.println(Thread.currentThread().getName()+" i = "+i++);
				Thread.sleep(100);
			}catch(Throwable ex){}
		}

	}
}
class SecondThread extends Thread{
	FirstThread t;
	int i = 1;
	public SecondThread(String name, FirstThread t){
		super(name);
		this.t = t;
	}
	public void run(){
		try{
			Thread.sleep(1000);
		}
		catch(Throwable ex){}
		System.out.println("SecondThread:  t.isAlive()? "+t.isAlive()); 
		System.out.println(Thread.currentThread().getName()+" stops t1");
		t.setKeepGoing(false);
		try{
			Thread.sleep(110);
		}
		catch(Throwable ex){}
		System.out.println("First Thread is Alive? "+t.isAlive()); 
	}
}
public class IsAlive_Stop_Test {
	public static void main(String[] args) {
		FirstThread ft = new FirstThread("FirstThread");
		SecondThread st = new SecondThread("SecondThread", ft);
		ft.start();
		st.start();
		System.out.println("st is Alive? "+st.isAlive()); 
		try{
			Thread.sleep(100);
		}
		catch(Throwable ex){}
		System.out.println("st is Alive? "+st.isAlive()); 
		System.out.println("in main " +Thread.currentThread().getName());
	}
}
