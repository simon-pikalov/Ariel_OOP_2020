package gameClient;
import Server.Game_Server_Ex2;
import api.directed_weighted_graph;
import api.edge_data;
import api.game_service;
import api.node_data;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * This class represents the simplest "Client-Game" main class
 * which uses the "server for moving the "Agents".
 * Note: this code is a very simple no algorithm no threaded mechanism - it is presented just to show the basic
 * use of the "server".
 */
public class SimpleGameClient {
	public static void main(String[] a) {
		test1();
	}
	public static void test1() {
		game_service game = Game_Server_Ex2.getServer(2); // you have [0,23] games
		String g = game.getGraph();
		directed_weighted_graph gg = game.getJava_Graph_Not_to_be_used();
		//game.login(12345);  // please use your ID only as a key. uncomment this will upload your results to the server
		node_data nn = gg.getNode(10);
		String info = game.toString();
		System.out.println(info);
		System.out.println(g);
		System.out.println(game.getPokemons());
		int src_node = 0;  // arbitrary node, you should start at one of the fruits
		game.addAgent(src_node);
		game.startGame();
		int i=0;
		while(game.isRunning()) {
			long t = game.timeToEnd();
			String lg = game.move();
			List<CL_Agent> log = Arena.getAgents(lg, gg);
			for(int a=0;a< log.size();a++) {
				CL_Agent r = log.get(a);
				int dest = r.getNextNode();
				int src = r.getSrcNode();
				int id = r.getID();
				if(dest==-1) {
					int new_dest = nextNode(gg, src);
					game.chooseNextEdge(id, new_dest);
					System.out.println(i+") "+a+") "+r+"  move to node: "+new_dest);
				}
			}
			i++;
		}
	}
	/**
	 * a very simple random walk implementation!
	 * @param g
	 * @param src
	 * @return
	 */
	private static int nextNode(directed_weighted_graph g, int src) {
		int ans = -1;
		Collection<edge_data> ee = g.getE(src);
		Iterator<edge_data> itr = ee.iterator();
		int s = ee.size();
		int r = (int)(Math.random()*s);
		int i=0;
		while(i<r) {itr.next();i++;}
		ans = itr.next().getDest();
		return ans;
	}

}
