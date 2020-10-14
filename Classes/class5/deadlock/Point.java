package class5.deadlock;
public class Point{
	private double x,y;            
	public Point (double x1, double y1){
		x = x1;
		y = y1;
	}
	public Point (){
		x = 0;
		y = 0;
	}
 // ********** public methods *********
	public double getX() {
		return x;
	}	
	public double getY() {
		return y;
	}
	public double distance() {
		return Math.sqrt(this.x*this.x + this.y*this.y);
	}
}
