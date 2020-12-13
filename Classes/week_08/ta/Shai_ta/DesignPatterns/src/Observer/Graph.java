package Observer;

import java.util.ArrayList;
import java.util.List;

public class Graph implements Subject
{	
	List<Listener> listeners = new ArrayList<>();
	
	public void addNode(Node node)
	{
		//add node..
		 notifyListeners();
	}
	
	public void connect(int node1, int node2, double weight)
	{
		//connect two nodes..
		 notifyListeners();
	}

	@Override
	public void register(Listener o) 
	{
		listeners.add(o);
	}

	@Override
	public void unregister(Listener o) 
	{		
		listeners.remove(o);
	}

	@Override
	public void notifyListeners()
	{
		for (Listener listener : listeners) 
		{
			listener.update();
		}
	}

}
