import java.util.ArrayList;
import java.util.Arrays;

public class DrWho {
    String _title = "Dr.";
    String _name = "Who";
    String _type = "TimeLord";
    int _doctor_num = 8;
    int _heart_num = 2;
    ArrayList<Companion> _companions = new ArrayList<Companion>(
            Arrays.asList(
                    new Companion("Amy Pond", 87),
                    new Companion("Rory Williams", 82)
            ));

    @Override
    public String toString() {
        String comp_str = "";
        for (Companion c:_companions){
            comp_str += "\n\t\t" + c.toString();
        }

        return "DrWho{" + "\n" +
                "\ttitle='" + _title + '\'' + "\n" +
                "\tname='" + _name + '\'' + "\n" +
                "\ttype='" + _type + '\'' + "\n" +
                "\tdoctor_num=" + _doctor_num + "\n" +
                "\theart_num=" + _heart_num + "\n" +
                "\tcompanions=" + comp_str + "\n" +
                '}';
    }
}
