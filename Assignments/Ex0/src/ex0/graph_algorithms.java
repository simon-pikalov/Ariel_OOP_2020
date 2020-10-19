package ex0;
/**
 * This interface represents the "regular" Graph Theory algorithms including:
 * 0. clone(); (copy)
 * 1. init(graph);
 * 3. isConnected();
 * 5. int shortestPathDist(int src, int dest);
 * 6. List<Node> shortestPath(int src, int dest);
 *
 * @author boaz.benmoshe
 *
 */

import java.util.List;

public interface graph_algorithms {
	/**
	 * Init this set of algorithms on the parameter - graph.
	 * @param g
	 */
	public void init(graph g);
	/** 
	 * Compute a deep copy of this graph.
	 * @return
	 */
	public graph copy();
/**
 * Returns true if and only if (iff) there is a valid path from EVREY node to each
 * other node. NOTE: assume ubdirectional graph.
 * @return
 */
	public boolean isConnected();
	/**
	 * returns the length of the shortest path between src to dest
	 * @param src - start node
	 * @param dest - end (target) node
	 * @return
	 */
	public int shortestPathDist(int src, int dest);
	/**
	 * returns the the shortest path between src to dest - as an ordered List of nodes:
	 * src--> n1-->n2-->...dest
	 * see: https://en.wikipedia.org/wiki/Shortest_path_problem
	 * @param src - start node
	 * @param dest - end (target) node
	 * @return
	 */
	public List<node_data> shortestPath(int src, int dest);
}

