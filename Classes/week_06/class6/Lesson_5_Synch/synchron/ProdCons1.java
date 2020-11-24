package Lesson_5_Synch.synchron;
// http://www.javaworld.com/javaworld/jw-07-2002/jw-0703-java101.html?page=8

/* ProdCons1.java
  Apply wait/notify to the producer-consumer relationship
  To demonstrate wait/notify's practicality, 
  I introduce you to the producer-consumer relationship, 
  which is common among multithreaded programs where two 
  or more threads must coordinate their activities. 
  The producer-consumer relationship demonstrates coordination 
  between a pair of threads: a producer thread (producer) 
  and a consumer thread (consumer). 
  The producer produces some item that a consumer consumes. 
  For example, a producer reads items from a file and passes 
  those items to a consumer for processing. 
  The producer cannot produce an item if no room is available 
  for storing that item because the consumer has not finished 
  consuming its item(s). Also, a consumer cannot consume an item 
  that does not exist. Those restrictions prevent a producer 
  from producing items that a consumer never receives for 
  consumption, and prevents a consumer from attempting to consume 
  more items than are available. Listing 4 shows the architecture 
  of a producer-/consumer-oriented program: 
 */

public class ProdCons1{
	public static void main (String [] args){
		Shared s = new Shared ();
		new Producer(s).start ();
		new Consumer(s).start ();
	}
}
class Shared{
	private char c = 'x';
	void setSharedChar (char c) {
		this.c = c; 
		System.out.println (c + " produced by producer.");
	}
	char getSharedChar () {
		System.out.println (c + " consumed by consumer.");
		return c; 
	}
}
class Producer extends Thread{
	private Shared s;
	Producer (Shared s){
		this.s = s;
	}
	public void run (){
		for (char ch = 'A'; ch <= 'H'; ch++){
			s.setSharedChar (ch);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
class Consumer extends Thread{
	private Shared s;
	Consumer (Shared s){
		this.s = s;
	}
	public void run (){
		char ch;
		do{
			ch = s.getSharedChar ();
			try {
				Thread.sleep(8);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		while (ch != 'H');
	}
}
/*
  ProdCons1 creates producer and consumer threads. 
  The producer passes uppercase letters individually to the consumer 
  by calling s.setSharedChar (ch);. Once the producer finishes, 
  that thread terminates. The consumer receives uppercase characters, 
  from within a loop, by calling s.getSharedChar (). 
  The loop's duration depends on that method's return value. 
  When Z returns, the loop ends, and, thus, the producer informs 
  the consumer when to finish. 
   To make the code more representative of real-world programs, 
  each thread sleeps for a random time period (up to four seconds) 
  before either producing or consuming an item. 

  Because the code contains no race conditions, 
  the synchronized keyword is absent. 
  Everything seems fine: the consumer consumes every character 
  that the producer produces. In reality, some problems exist, 
  which the following partial output from one invocation of 
  this program shows: 

    consumed by consumer.
  A produced by producer.
  A consumed by consumer.
  A consumed by consumer.
  B produced by producer.
  B consumed by producer.
  B consumed by producer.
  C produced by producer.
  C consumed by consumer.
 */