package Iterator;

import java.util.ArrayList;

public class Main
{
	public static void main(String[] args) 
	{
		ShapeStorage storage = new ShapeStorage();

		storage.addShape("c");
		storage.addShape("r");

		Iterator iterator = storage.iterator();

		while (iterator.hasNext())
		{
			System.out.println(iterator.next());
		}
	}
}
