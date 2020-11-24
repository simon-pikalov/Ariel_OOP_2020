package Lesson_5_Synch.synchron;
// http://www.jchq.net/tutorial/07_03Tut.htm

/* The synchronized keyword
  The synchronized keyword can be used to mark a statement or block 
  of code so that only one thread may execute an instance of the 
  code at a time. Entry to the code is protected by a monitor 
  lock around it. This process is implemented by a system of locks. 
  Thus when a thread starts to execute a synchronized block it 
  grabs the lock on it. Any other thread will not be able to execute 
  the code until the first thread has finished and released the lock. 
  Note that the lock is based on the object and not on the method.

  For a method the synchronized keyword is placed before the method 
  thus synchronized void amethod() {   method body  }
  For a block of code the synchronized keyword comes before opening 
  and closing brackets thus.

  synchronized (ObjectReference) {  Block body  }
  The value in parentheses indicates the object or class whose 
  monitor the code needs to obtain. It is generally more common 
  to synchronize the whole method rather than a block of code.
 
  When a synchronized block is executed, its object is locked 
  and it cannot be called by any other code until the lock is freed.
 */
 
/* wait/notify 
Java includes an elegant interprocess communication mechanism via the wait( ), notify( ), and notifyAll( ) methods. 
These methods are implemented as final methods in Object, so all classes have them. 
All three methods can be called only from within a synchronized method. 
Although conceptually advanced from a computer science perspective, the rules for using these methods are actually quite simple:

wait( ) tells the calling thread to give up the monitor and go to sleep until some other 
thread enters the same monitor and calls notify( ). 
notify( ) wakes up the first thread that called wait( ) on the same object. 
notifyAll( ) wakes up all the threads that called wait( ) on the same object. 
The highest priority thread will run first. 

These methods are declared within Object, as shown here:

final void wait( ) throws InterruptedException 
final void notify( ) 
final void notifyAll( )

Inside get( ), wait( ) is called. This causes its execution to suspend until the Producer 
notifies you that some data is ready. When this happens, execution inside get( ) resumes. 
After the data has been obtained, get( ) calls notify( ). 
This tells Producer that it is okay to put more data in the queue. 
Inside put( ), wait( ) suspends execution until the Consumer has removed the item from the queue. 
When execution resumes, the next item of data is put in the queue, and notify( ) is called. 
This tells the Consumer that it should now remove it.


 */
// ProdCons2.java
class ProdCons2{
   public static void main (String [] args){
      Shared2 s = new Shared2 (true);
      Producer2 p = new Producer2 (s);
      p.start ();
      Consumer2 c = new Consumer2 (s);
      c.start ();
   }
}
class Shared2{
   private char c = 'x';
   private boolean writeable = true;
   public Shared2(boolean w){
	   writeable = w;
   }
   synchronized void setSharedChar (char c){
      if (!writeable){
         try{
            wait ();
         }
         catch (InterruptedException e) {}
      }
      this.c = c;
      System.out.println (c + " produced by producer.");
      writeable = false;
      notify ();
   }
   synchronized char getSharedChar (){
      if (writeable){
         try{
            wait ();
         }
         catch (InterruptedException e) {}
      }
      System.out.println (c + " consumed by consumer.");
      writeable = true;
      notify ();
      return c;
   }
}
class Producer2 extends Thread{
   private Shared2 s;
   Producer2 (Shared2 s){
      this.s = s;
   }
   public void run (){
      for (char ch = 'A'; ch <= 'H'; ch++){
           s.setSharedChar (ch);
      }
   }
}
class Consumer2 extends Thread{
   private Shared2 s;
   Consumer2 (Shared2 s){
      this.s = s;
   }
   public void run (){
      char ch;
      do{
         ch = s.getSharedChar ();
      }
      while (ch != 'H');
   }
}
