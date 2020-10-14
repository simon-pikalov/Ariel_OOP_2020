//package class5.Ex1;

import java.util.Iterator;

/**
 * This interface represents a general Polynom: f(x) = a_1X^b_1 + a_2*X^b_2 ... a_n*Xb_n,
 * where: a_1, a_2 ... a_n are real numbers and b_1<b_2..<b_n are none negative integers (naturals)
 * For formal definitions see: https://en.wikipedia.org/wiki/Polynomial
 * 
 * Such polygon has the following functionality:
 * 1. Init:
 * 1.1 Init(String), e.g., {"x", "3+1.4X^3-34x", "(2x^2-4)*(-1.2x-7.1)", "(3-3.4x+1)*((3.1x-1.2)-(3X^2-3.1))"};
 * 1.2 Init() // zero Polygon
 * 1.3 Polynom copy() //  deep copy semantics (from function interface!)
 * 
 * 2. Math:
 * 2.1 void multiply(Monom m) // multiply this Polygon by Monom m
 * 2.2 void add(Polygon p) // add p to this Polynon
 * 2.3 void subtract(Polygon p) // subtract p from this Polygon
 * 2.4 void multiply(Polygon p) // multiply this Polygon by p
 * 
 * 3. Utils
 * 3.1 isZero()
 * 3.2 Polynom derivative() // returns a new Polygon of the derivative ("NIGZERET").
 * 3.3 double f(x) // return this Polygon value at p(x) 
 * 3.4 boolean equals(Polygon p) // returns true iff for any x: this.f(x) == p.f(x)
 * 3.5 double root(double x0, double x1, double eps) // assuming (f(x0)*f(x1)<=0, returns f(x2) such that:
 *													//	(i) x0<=x2<=x2 & (ii) {f(x2)<eps
 * 3.6 String toString() // returns a String such that it can be used for init an equal(s) Polygon
 *													
 * 
 * 
 * @author ben-moshe
 *
 */
public interface Polynom_able extends cont_function{
	/**
	 * Add p1 to this Polynom
	 * @param p1
	 */
	public void add(Polynom_able p1);
	/**
	 * Add m1 to this Polynom
	 * @param m1 Monom
	 */
	public void add(Monom m1);
	/**
	 * Subtract p1 from this Polynom
	 * @param p1
	 */
	public void substract(Polynom_able p1);
	/**
	 * Multiply this Polynom by Monom m1
	 * @param m1
	 */
	public void multiply(Monom m1);
	/**
	 * Multiply this Polynom by p1
	 * @param p1
	 */
	public void multiply(Polynom_able p1);
	/**
	 * Test if this Polynom is logically equals to p1.
	 * @param p1
	 * @return true iff this polynom represents the same function as p1
	 */
	public boolean equals(Object p1);
	/**
	 * Test if this is the Zero Polynom
	 * @return
	 */
	public boolean isZero();
	
	/**
	 * Compute a new Polynom which is the derivative of this Polynom
	 * @return
	 */
	public Polynom_able derivative();
	/**
	 * @return an Iterator (of Monoms) over this Polynom
	 * @return
	 */
	public Iterator<Monom> iteretor();
}
