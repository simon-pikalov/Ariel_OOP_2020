package Visitor;

public class Circle implements Shape
{
	@Override
	public void visit(Visitor v) 
	{
		v.draw(this);
	}
	@Override
	public String toString(){
		return "Circle";
	}
}
