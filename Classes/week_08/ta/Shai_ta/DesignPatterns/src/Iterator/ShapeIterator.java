package Iterator;

public class ShapeIterator implements Iterator                                                       
{
	private String[] shapes;
	private int pos;

	public ShapeIterator(String[] shapes)
	{
		this.shapes = shapes;
	}

	@Override
	public boolean hasNext()
	{
		if (pos >= shapes.length || shapes[pos] == null)
			return false;
		return true;
	}


	@Override
	public Shape next() 
	{
		String shape_str =  shapes[pos++];
		return new Shape(shape_str);
	}

	@Override
	public void remove() 
	{
		if (pos <= 0)
			throw new IllegalStateException("Illegal pos.");
		
		if (shapes[pos - 1] != null)
		{
			for (int i = pos - 1; i < (shapes.length - 1); i++) 
			{
				shapes[i] = shapes[i + 1];
			}
			
			shapes[shapes.length - 1] = null;
		}
	}
}