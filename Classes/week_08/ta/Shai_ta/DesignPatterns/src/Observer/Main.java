package Observer;

public class Main {

	public static void main(String[] args) 
	{
		GUI gui = new GUI();
		Graph graph = new Graph();
		graph.register(gui);
	}

}
