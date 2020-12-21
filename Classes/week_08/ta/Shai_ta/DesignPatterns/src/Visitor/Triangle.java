package Visitor;

public class Triangle implements Shape
{
	@Override
	public void visit(Visitor v) 
	{
		v.draw(this);
	}

	@Override
	public String toString(){
		return "Triangle";
	}
}
