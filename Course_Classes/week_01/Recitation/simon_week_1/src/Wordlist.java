import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Simon Pikalov
 * https://github.com/simon-pikalov
 */

public class Wordlist {

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
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            for (int i = 0; i <= maxNumber; i++) {
                curr = padding(i, length);
                writer.write(curr);

            }
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        String passF = "password.txt";
        String idF  = "id.txt";
        generateList(passF,9999);
        generateList(idF,999999999);
    }
}
