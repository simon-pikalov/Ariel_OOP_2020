package first;

class Th extends Thread{
	public Th(String name){
		super(name);
	}
	@Override
	public void run() {
		for (long i=1; i<=5; i++) {
			System.out.println("i = "+i+"  "+this.getName() + " Priority: "+this.getPriority());
			try {
				sleep(100);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(this.getName()+ "  DONE!");
	} 
}

public class ThSartRun {
	public static void main(String[] args) {
		Th t = new Th("Th");
		//t.start();
		t.run();
		System.out.println("main exit");

	}

}
