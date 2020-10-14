//package class5.Ex1;
/**
 * This interface represents a collection of mathematical functions
 *  which can be presented on a GUI window and can be saved (and load) to file. 
 */
import java.io.IOException;
import java.util.Collection;


public interface functions extends Collection<function>{
	/**
	 * Init a new collection of functions from a file
	 * @param file - the file name
	 * @throws IOException if the file does not exists of unreadable (wrong format)
	 */
	public void initFromFile(String file) throws IOException;
/**
 * 
 * @param file - the file name
 * @throws IOException if the file is not writable
 */
	public void saveToFile(String file) throws IOException;
/**
 * Draws all the functions in the collection in a GUI window using the
 * given parameters for the GUI windo and the range & resolution
 * @param width - the width of the window - in pixels
 * @param height - the height of the window - in pixels
 * @param rx - the range of the horizontal axis
 * @param ry - the range of the vertical axis
 * @param resolution - the number of samples with in rx: the X_step = rx/resulution
 */
	public void drawFunctions(int width, int height, Range rx, Range ry, int resolution);
/**
 * Draws all the functions in the collection in a GUI window using the given JSON file
 * @param json_file - the file with all the parameters for the GUI window. 
 * Note: is the file id not readable or in wrong format should use default values. 
 */
	public void drawFunctions(String json_file);
}
