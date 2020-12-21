import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Simon Pikalov
 * https://github.com/simon-pikalov
 */

public class WordList {

    /**
     * @param num   the number to be padd
     * @param desiredLength the length of the desired string to be retuned
     * @return a String with zeros to complete the length to the desired length
     */
    public static String padding(int num, int desiredLength) {
        String aString = "" + num; //convert a to string
        int diff = desiredLength - aString.length();
        String zeroString = "";
        for (int i = 0; i < diff; i++) {
            zeroString += "0";
        }
        String paddString = zeroString + aString + "\n";
        return paddString;
    }



    /**
     * Genarates a world List of 0 to maxNumber, and writes it to file.
     * @param
     * @param maxNumber the max number of the list included
     */
    public static void generateList(String fileName,int maxNumber) {
        int length = ("" + maxNumber).length(); // calc the length of the max int
        String curr = "-1";
        try {
            FileWriter fw =  new FileWriter(fileName);
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i = 0; i <= maxNumber; i++) {
                curr = padding(i, length);
                bw.write(curr);

            }
            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void printFile(String fileName) {
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            String curr;
            curr = br.readLine();
            while (curr != null) {
                System.out.println(curr);
                curr = br.readLine();
            }
        } catch (IOException iEx) {
            iEx.getCause();

        }
    }
    public static void main(String[] args) {

        Path path = Paths.get("./passwords");
        try {
            Files.createDirectory(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String passF = "./passwords/password.txt";
        String idF  = "./passwords/id.txt";
        generateList(passF,9999);
        generateList(idF,999999999);
        printFile(passF);

    }
}
