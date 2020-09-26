/**
 * this class represent a 2d point in the plane. <br>
 * supports several operations on points in the plane.
 */
package InterfaceSortable;
public final class Point implements Comparable<Point> {
	private double _x; 
	private double _y;
	public Point (double x1, double y1){
		_x = x1;
		_y = y1;
	}
	public Point (){
		_x = 0;
		_y = 0;
	}
	/** returns the first coordinate of the point*/
	public double x() {return _x;}
	/** returns the second coordinate of the point*/
	public double y() {return _y;}
	/** @return the distance between the point and the origin */
	public double distance ()  {
		return Math.sqrt (_x*_x + _y*_y);
	}
	/** @return a String contains the Point data*/
	public String toString()  {
		return  "(" + _x + "," + _y+")";
	}
	@Override
	public int compareTo(Point other) {
		double ans = this.distance() - other.distance();
		if (ans < 0) return -1;
		else if (ans > 0) return 1;
		else return 0;
	}
}// class Point