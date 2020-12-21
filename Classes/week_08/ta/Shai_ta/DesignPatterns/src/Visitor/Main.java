package Visitor;

import java.util.LinkedList;

public class Main
{
	public static void main(String[] args)
	{
		LinkedList<Shape> shapes = new LinkedList<Shape>();

		shapes.add(new Circle());
		shapes.add(new Square());
		shapes.add(new Triangle());

		ShapePainter painter = new ShapePainter(shapes);
		
		painter.draw();

	}
}
