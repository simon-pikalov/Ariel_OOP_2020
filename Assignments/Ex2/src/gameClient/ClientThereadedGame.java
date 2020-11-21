package gameClient;
import Server.Agent_Graph_Algo;
import Server.Game_Server_Ex2;
import api.directed_weighted_graph;
import api.edge_data;
import api.game_service;
import gameClient.util.Point3D;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.*;

public class ClientThereadedGame implements Runnable{
	private static MyFrame _win;
	private static Arena _ar;

	public static long LOW_SPEED_DT = 520, _speedyDT;
//	public static int _ind = 0;
	public static long _dt = LOW_SPEED_DT, _last, _start;
	public static boolean DYNAMIC_DT = true;
	public static void main(String[] a) {
		Thread client = new Thread(new ClientThereadedGame());
		client.start();
	}
	
	@Override
	public void run() {
		int scenario_num = 1;
		int id = 12345678;
	//	Game_Server.login(id);
		game_service game = Game_Server_Ex2.getServer(scenario_num); // you have [0,23] games
		String g = game.getGraph();
		String fruits = game.getPokemons();
		directed_weighted_graph gg = game.getJava_Graph_Not_to_be_used();
		_ar = new Arena();
		_ar.setGraph(gg);
		_win = new MyFrame("test Ex2");
		_win.update(_ar);
		_win.setSize(1000, 700);
		//initKML(gg);

	//	System.out.println(_kml.toKML());
		_win.show();
		String info = game.toString();
		JSONObject line;
		try {
			// "GameServer":{"graph":"A0","fruits":3,"robots":1}}
			line = new JSONObject(info);
			JSONObject ttt = line.getJSONObject("GameServer");
			int rs = ttt.getInt("agents");
			System.out.println(info);
			String pks = game.getPokemons();
			System.out.println(pks);
			ArrayList<CL_Pokemon> cl_fs = Agent_Graph_Algo.json2Pokemons(pks);
			for(int a = 0;a<cl_fs.size();a++) { Agent_Graph_Algo.updateEdge(cl_fs.get(a),gg);}
			for(int a = 0;a<rs;a++) {
				int ind = (a)%cl_fs.size();
				CL_Pokemon c = cl_fs.get(ind);
				int nn = c.get_edge().getDest();
				if(c.getType()>0 ) {nn = c.get_edge().getSrc();}
				game.addAgent(nn);
			}
			String r_s = game.getAgents();
			List<CL_Agent> rrs = this.getAgents(r_s);
			_ar.setAgents(rrs);
		}
		catch (JSONException e) {e.printStackTrace();}
		
		_last = new Date().getTime();
		game.startGame();
		_win.setTitle("Ex2 - OOP: (NONE optimal Solution) "+game.toString());
		int ind=0;
		long dt=100;
		
		while(game.isRunning()) {
			moveRobots(game, gg);
			try {
				if(ind%2==0) {_win.repaint();}
				Thread.sleep(dt);;
				ind++;
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		String res = game.toString();
		System.out.println(res);
		System.exit(0);
		//_win = null;
	}
// json2Pokemons
	private List<CL_Pokemon> getPokemons(String a) {
		return Agent_Graph_Algo.json2Pokemons(a);
	}
	private List<CL_Agent> getAgents(String aa) {
		return Agent_Graph_Algo.getAgents(aa,_ar.getGraph());
	}

	/** 
	 * Moves each of the robots along the edge, 
	 * in case the robot is on a node the next destination (next edge) is chosen (randomly).
	 * @param game
	 * @param gg
	 */
	private static void moveRobots1(game_service game, directed_weighted_graph gg) {
		String lg = game.move();
		List<CL_Agent> log = Agent_Graph_Algo.getAgents(lg, gg);
		_ar.setAgents(log);
		ArrayList<Point3D> rs = new ArrayList<Point3D>();
		String fs =  game.getPokemons();
		ArrayList<CL_Pokemon> ffs = Agent_Graph_Algo.json2Pokemons(fs);
		_ar.setPokemons(ffs);
		if(log!=null) {
			long t = game.timeToEnd();
			for(int i=0;i<log.size();i++) {
				CL_Agent robot = log.get(i);
					//_ar.updateRobots(log);
				int dest = robot.getNextNode();
				if(dest==-1) {
					game.chooseNextEdge(robot.getID(), dest);
				}
			}
			//testDT();
		_ar.setPokemons(ffs);
		}
	}
	private static void moveRobots(game_service game, directed_weighted_graph gg) {
		String lg = game.move();
	//	List<String> log = game.getRobots();
		String fs =  game.getPokemons();
		//_ar.set_info(log);
		List<CL_Agent> log = Agent_Graph_Algo.getAgents(lg, _ar.getGraph());
		_ar.setAgents(log);
		ArrayList<CL_Pokemon> ffs = Agent_Graph_Algo.json2Pokemons(fs);
		_ar.setPokemons(ffs);

		long dt = LOW_SPEED_DT;
		if(log!=null) {
			long t = game.timeToEnd();
			for(int i=0;i<_ar.getRobots().size();i++) {
				CL_Agent r = _ar.getRobots().get(i);
 				int src = r.getSrcNode();
				int dest = r.getNextNode();
				double speed =  r.getSpeed();
				if(dest==-1) {
					dest = nextNode(gg, r, ffs,speed);
					game.chooseNextEdge(r.getID(), dest);
					System.out.println(r+"  --> "+dest);
				}
				long dd = r.get_sg_dt();
				if(dd<dt) {dt = dd;}
			}
			if(DYNAMIC_DT) {_dt = dt;}
		//	game.move();
	//			System.out.println("Turn to node: "+dest+"  time to end:"+(t/1000));
		}
	}
	
	private static void testDT() {
		long now = new Date().getTime();
		if(now>_speedyDT) {
		//	_dt = LOW_SPEED_DT;
		}
		
	}
	/**
	 * a very simple random walk implementation!
	 * @param g
	 * @param src
	 * @return
	 */
	private static int nextNode1(directed_weighted_graph g, int src) {
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
	private static int nextNode(directed_weighted_graph g, CL_Agent r, ArrayList<CL_Pokemon> fs, double speed) {
		int ans = -1;
		ans = Agent_Graph_Algo.destenations(g,r, fs, speed);
		r.setNextNode(ans);
		r.set_SDT(LOW_SPEED_DT);
		return ans;
	}
}
