package first;
public class JoinDemo {
	public static void main(String[] args) {
		ThreadJoin t1 = new ThreadJoin("T1");
		t1.start();
		try {
			//t1.join();
			t1.join(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("main exit");
	}
}
class ThreadJoin extends  Thread{
	ThreadJoin(String name){
		super(name);
	}
	public void run(){
		for (int i=1; i<=5; i++) {
			System.out.println(i+" "+this.getName());
			int r = 10;
			try{
				sleep(r);
			}
			catch(InterruptedException ex){}
		}
		System.out.println(this.getName() +"  Done");
	}
}
