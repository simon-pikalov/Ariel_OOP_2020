package first;

public class ThreadCalcPI implements Runnable{
	   boolean negative = true;
	   double pi=0.0; // Initializes to 0.0, by default
	   public void run (){
	      for (long i = 3; i < 100000000; i=i+2){
	           if (negative)
	               pi = pi - (1.0 / i);
	           else
	               pi = pi + (1.0 / i);
	           negative = !negative;
	      }
	      pi = pi + 1.0;
	      pi = pi*4.0;
	      System.out.println ("Finished calculating PI");
	   }
}
