import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * This class represents a collection of Points3D in space.
 * with the following public methods:
 * 1. Init
 * 2. Java.utils.collection <Point3D>
 * 3. save(String file_name)
 * 4. load(Stirng file_name)
 */
public class Points3D extends ArrayList<Point3D> {
    public Points3D() {super();}

    /**
     * taken from:
     *      * https://stackoverflow.com/questions/17293991/how-to-write-and-read-java-serialized-objects-into-a-file
     *
     *
     * @param file_name
     * @return
     */
    public boolean save(String file_name){
        boolean ans = false;
        ObjectOutputStream oos;
        try {
            FileOutputStream fout = new FileOutputStream(file_name, true);
            oos = new ObjectOutputStream(fout);
            oos.writeObject(this);
            ans= true;
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return ans;
    }

    /**
     * taken from:
     * https://stackoverflow.com/questions/17293991/how-to-write-and-read-java-serialized-objects-into-a-file
     * @param file_name
     * @return
     *
     */
    public boolean load(String file_name) {
        try {
            FileInputStream streamIn = new FileInputStream(file_name);
            ObjectInputStream objectinputstream = new ObjectInputStream(streamIn);
            Points3D readCase = (Points3D) objectinputstream.readObject();
            this.clear();
            this.addAll(readCase);
        }
        catch(Exception e) {
            e.printStackTrace();
        }

        return false;
    }
    public boolean equals(Object oth){
        boolean ans = false;
        if(oth!=null && oth instanceof Collection) {
            ans = true;
            Collection t = (Collection)oth;
            Iterator itr = t.iterator();
            while(ans && itr.hasNext()) {
                if(!this.contains(itr.next())) {
                    ans = false;
                }
            }
            itr = this.iterator();
            while(ans && itr.hasNext()) {
                if(!t.contains(itr.next())) {
                    ans = false;
                }
            }
        }

        return ans;
    }
}
