package Visitor;

import java.util.LinkedList;

public class ShapePainter implements Visitor {
    LinkedList<Shape> shapes = new LinkedList<Shape>();
    private String _name;

    public ShapePainter(String name, LinkedList<Shape> shapes) {
        _name = name;
        this.shapes = shapes;
    }

    public void draw() {
        for (Shape shape : shapes) {
            shape.visit(this);
        }
    }

    public void draw(Shape s) {
		System.out.println(_name +":"+ s.toString());
    }
}

