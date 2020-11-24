package first;

public class AnonimThread{
	public static void threadAnonim(){
		new Thread(new Runnable() {
			  int i=0;
			  public void run() {
			    try {
			      while (i++<10) {
			        Thread.sleep(1000); 
			        System.out.print((i)+" ");
			      }
			    }
			    catch(InterruptedException ex) {}
			  }
			}).start();
	}
	public static void main(String[] args) {
		threadAnonim();
	}
}
