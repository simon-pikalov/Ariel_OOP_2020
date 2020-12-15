package Iterator;

public class Shape
{
	private String name;
	
	public Shape(String name) 
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}
	
	@Override
	public String toString() 
	{
		return "Shape name: " + getName();
	}
}
