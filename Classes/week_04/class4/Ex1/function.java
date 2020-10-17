//package class5.Ex1;

import java.io.Serializable;

/** This interface represents a simple function of type y=f(x), where both y and x are real numbers.
**/

public interface function extends Serializable{
	public double f(double x);
	/** 
	 * return a String representing this complex function
	 */
	public String toString();
	public function initFromString(String s);
	public function copy(); // clone
	public boolean equals(Object obj);
}
