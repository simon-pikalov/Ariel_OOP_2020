package Iterator;

public class ShapeStorage
{
	private static final int CAPACITY = 5;
	private String[] shapes = new String[CAPACITY];
	private int size = 0;
	
	public void addShape(String s)
	{
		if(size<CAPACITY)
			shapes[size++] = s;
	}
	
	public Iterator iterator()
	{
		return new ShapeIterator(shapes);
	}
}
