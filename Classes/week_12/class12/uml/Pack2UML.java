package uml;

import java.io.DataInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * This simple code example shows how to read all the classes in a package, and create a naive class diagram (Plant UML) from it.
 */
public class Pack2UML {
    public static void main(String[] args) {
        String pack = "uml";
        String file = pack+".puml";
        toUML(pack, file);
    }
    public static void toUML(String pack, String f) {
        List<Class> classes = null;
        try {
            FileWriter myWriter = new FileWriter(f);
            classes = getClasses(Pack2UML.class.getClassLoader(),pack);
            myWriter.write("@startuml\n");
            for(Class c:classes) {
                String cs = class2UML(c);
                System.out.println(cs);
                myWriter.write(cs);
            }
            myWriter.write("\n@enduml");
            myWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     *  * class ArrayList {
     *  * Object[] elementData
     *  * size()
     *  * }
     * @param c
     * @return
     */
    public static String class2UML(Class c) {
        String ans = "";
        Class csuper = c.getSuperclass();
        String super_name = csuper.getSimpleName();
        boolean isObj = super_name.contains("Object");
        if(!isObj) {
            String inh = super_name+" <|-- "+c.getSimpleName();
            ans +=inh+"\n";
        }
        ans += "class "+c.getSimpleName()+" { \n";
        Field[] fields = c.getDeclaredFields();
        for (Field f : fields)
        {
            String sm1 = f.getName();
            ans += sm1 + "\n";
        }
        Method[] mm = c.getMethods();
        for(Method m: mm) {
            isObj = super_name.contains("Object");
            if(!isObj) {
                String sm1 = m.getName()+"()";
                ans += sm1 + "\n";
            }
        }

        ans += "\n}\n";
        return ans;
    }
    public static List<Class> getClasses(ClassLoader cl,String pack) throws Exception{

        String dottedPackage = pack.replaceAll("[/]", ".");
        List<Class> classes = new ArrayList<Class>();
        URL upackage = cl.getResource(pack);

        DataInputStream dis = new DataInputStream((InputStream) upackage.getContent());
        String line = null;
        while ((line = dis.readLine()) != null) {
            if(line.endsWith(".class")) {
               classes.add(Class.forName(dottedPackage+"."+line.substring(0,line.lastIndexOf('.'))));
            }
        }
        return classes;
    }
}