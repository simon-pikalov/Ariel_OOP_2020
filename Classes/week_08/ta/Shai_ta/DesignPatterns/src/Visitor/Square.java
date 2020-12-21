package Visitor;

public class Square implements Shape
{
	@Override
	public void visit(Visitor v) 
	{
		v.draw(this);
	}

	@Override
	public String toString(){
		return "Square";
	}
}
