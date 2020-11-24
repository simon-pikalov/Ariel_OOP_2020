package api;

import java.io.Serializable;
/**
 * This interface represents the main functionality of the game-server, allowing a User the following:
 * 1. construct_a_Game(int type);
 * 2. getInfo(); getGraph(), getAgents(), getPokemon(); // JSON format:
 * 3. locateAgents();
 * 4. start_game()
 * 5. move(); // move all Agents
 * 6. chooseNextEdge(int agentID, int destNodeID); //main algorithm
 * 7. stop_game()
 * 8. login(long id): (for reporting the results of Ex2)
 * @author boaz.benmoshe
 *
 */
public interface game_service extends Serializable{	
	/**
	 * Returns a JSON representation of graph as a JSON String.
	 * @return
	 */
	public String getGraph();
	/**
	 * Returns an interface to the graph (should NOT be used) for final version - for testing only.
	 * @return
	 */
	default directed_weighted_graph getJava_Graph_Not_to_be_used() {return null;}
	/**
	 * Returns a JSON string, representing all Pokemons (fixed bonus coin).
	 * @return
	 */
	public String getPokemons();
	/**
	 * Returns a JSON string, representing all the Agents.
	 * @return
	 */
	public String getAgents();
	/** 
	 * This method allows the user to add & locate the agents,
	 * all should be located in order to start a game.   
	 * 
	 * @param start_node - the vertex in the graph from which the agent will start.
	 * @return
	 */
	public boolean addAgent(int start_node);
		/**
		 * Start a new game
		 * @return the time (new Date().getTime()) if a new game was started, else -1.
		 */
	public long startGame();
	/**
	 * Returns the current status of the game (true: is running, false: NOT running).
	 * @return
	 */
	public boolean isRunning();
	/**
	 * Stops the game, after this method the isRunning() will return false
	 * @return
	 */
	public long stopGame();
	/**
	 * This method is the main logical functionality, allows the client algorithm
	 * to direct each agent to the "next" edge.
	 * @param id - the agent id, as received from the the JSON String
	 * @param next_node - the next edge defined as (src,next_node)
	 * @return the time the action was performed (-1 if not performed).
	 */
	public long chooseNextEdge(int id, int next_node);
	/**
	 * return the number of mili-seconds till the game is over
	 * 
	 * @return
	 */
	public long timeToEnd();
	/**
	 * moves all the agents along each edge,
	 * if the agent is on the node
	 * (nothing is done - requires to chooseNextEdge(int id, int next_node)
	 * @return a JSON like String - representing status of all the agents.
	 */
	public String move();
	/**
	 * Performs a login - so the results of the game will be stored in the data-base after the game,
	 * requires Internet connection. The following data is stored: id, level, number of moves, grade & time.
	 * @param id
	 * @return: true iff the user was successfully logged-in to the server.
	 */
	public boolean login(long id);
}
