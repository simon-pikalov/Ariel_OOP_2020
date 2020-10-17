//package Ex1;

/**
 * The interface represents a continuance function 
 * @author Boaz
 *
 */

public interface cont_function extends function{
	/**
	 * Compute a Riman's integral from x0 to x1 in eps steps. 
	 * @param x0 starting point
	 * @param x1 end point
	 * @param eps positive step value
	 * @return the approximated area above X-axis below this function bounded in the range of [x0,x1]
	 */
	public double area(double x0, double x1, double eps);
	
	/**
	 * Compute a value x' (x0<=x'<=x1) for with |f(x')| < eps
	 * assuming (f(x0)*f(x1)<=0, else should throws runtimeException 
	 * computes f(x') such that:
	 * 	(i) x0<=x'<=x1 && 
	 * 	(ii) |f(x')|<eps
	 * @param x0 starting point
	 * @param x1 end point
	 * @param eps>0 (positive) representing the epsilon range the solution should be within.
	 * @return an approximated value (root) for this (cont.) function 
	 */
	public double root(double x0, double x1, double eps);
}
