import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    private static final CharSequence EXIT_KEYWORD = "exit";

    /**
     * Reads the file, and prints the amount of times 'jones' and 'indiana' where mentioned.
     * @param file_path The path to the file.
     */
    public static void readFile(String file_path) {
        File file_obj = new File(file_path);
        int jones_counter = 0;
        int indiana_counter = 0;
        String jones_str = "jones";
        String indiana_str = "indiana";
        try {
            Scanner file_reader = new Scanner(file_obj);
            while (file_reader.hasNext()) {
                String line = file_reader.nextLine();
                System.out.println("|\t" + line);
                if (line.toLowerCase().contains(jones_str)) {
                    ++jones_counter;
                }
                if (line.toLowerCase().contains(indiana_str)) {
                    ++indiana_counter;
                }
            }
            file_reader.close();

            System.out.println(String.format("The number of times \'Jones\' was mentioned is %d", jones_counter));
            System.out.println(String.format("The number of times \'Indiana\' was mentioned is %d", indiana_counter));
        } catch (FileNotFoundException e) {
            System.err.println("Please check your file path!");
            e.printStackTrace();
        }
    }

    /**
     * Creates a file
     *
     * @param file_path File path
     * @param append    If false, the funtction will return false if the file exists
     * @return true if the file was created successful o.w. false
     */
    public static boolean createFile(String file_path, boolean append) {
        try {
            File myObj = new File(file_path);

            if (!(new File(myObj.getParent()).exists())) {
                System.out.println("Parent folders did not exist, creating them now..");
                File dirs = new File(myObj.getParent());
                if (!dirs.mkdirs()) {
                    System.err.println("Could not create parent folders.");
                    return false;
                }
            }
            if (myObj.createNewFile() || append) {
                System.out.println("File created: " + myObj.getName());
                return true;
            } else {
                System.err.println("File already exists.");
                return true;
            }
        } catch (IOException e) {
            System.err.println("An error occurred.");
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Writes the input from the keyboard to a file.
     * @param file_path The path to the file.
     * @param append Whether to append to a file or overwrite it.
     */
    public static void write2File(String file_path, boolean append) {
        if (!(createFile(file_path, append))) {
            return;
        }
        try {
            FileWriter myWriter = new FileWriter(file_path, append);
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.err.print("> ");
                String inputString = scanner.nextLine();
                if (inputString.contains(EXIT_KEYWORD)) {
                    break;
                }
                myWriter.write(inputString + '\n');
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {

        // Read/Write Files
//        System.out.println("Reading a file");
//        String file_path = "../output/my_script.txt";
//        String indi_script_path = "../input/raiders_of_the_lost_ark.txt";
//        readFile(indi_script_path);
//        write2File(file_path,true);
//        readFile(file_path);

        // Nested Class and Iterators
        NiceStringCollection nsc = new NiceStringCollection();
        nsc.add("Coffe is good");
        nsc.add("Tea is so so");
        nsc.add("Cola is poisson");

        for (int i = 0; i < nsc.size(); ++i) {
            System.out.println(nsc.get(i));
        }

        System.out.println("================");
        NiceStringCollection.NiceIterator n_it = nsc.iterator();

        for(String s: n_it){
            System.out.println(s);
        }
    }
}
