
/**
 * This interface represents the set of operations applicable on a 
 * node (vertex) in an (undirectional) unweighted graph.
 * @author boaz.benmoshe
 *
 */
public interface node_data {
	/**
	 * Return the key (id) associated with this node.
	 * @return
	 */
	public int getKey();
	/**
	 * return the remark (meta data) associated with this node.
	 * @return
	 */
	public String getInfo();
	/**
	 * Allows changing the remark (meta data) associated with this node.
	 * @param s
	 */
	public void setInfo(String s);
	/**
	 * Temporal data (aka color: e,g, white, gray, black) 
	 * which can be used be algorithms 
	 * @return
	 */
	public int getTag();
	/** 
	 * Allow setting the "tag" value for temporal marking an node - common 
	 * practice for marking by algorithms.
	 * @param t - the new value of the tag
	 */
	public void setTag(int t);
}
