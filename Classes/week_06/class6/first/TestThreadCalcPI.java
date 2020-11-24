package first;
public class TestThreadCalcPI {
	public static void main(String[] args) {
		ThreadCalcPI t = new ThreadCalcPI ();
		Thread mt = new Thread(t);
		mt.start ();
		int i = 0;
		while (mt.isAlive ()){
		   try{
		       Thread.sleep (100); // Sleep for 200 milliseconds
		       System.out.println("Thread is alive "+(i++));
		   }
		   catch (InterruptedException e){}
		}
		System.out.println ("pi = " + t.pi);
		System.out.println ("pi = " + Math.PI);
		System.out.println(mt.isAlive());
	}
}
