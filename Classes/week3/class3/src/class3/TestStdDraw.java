//package stdDraw;

public class TestStdDraw {
	public static void main(String[] args) {
		StdDraw.setCanvasSize(400, 400);
		StdDraw.setPenRadius(0.07);
		StdDraw.setPenColor(StdDraw.BLUE);
		StdDraw.point(0.5, 0.5);
		StdDraw.setPenColor(StdDraw.MAGENTA);
		StdDraw.line(0.2, 0.2, 0.8, 0.3);
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.setPenRadius(0.05);
		StdDraw.point(0.6, 0.7);
	}

}
