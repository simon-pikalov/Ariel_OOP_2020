import java.util.Comparator;

public class ForceComp implements Comparator<ForceCharacters> {

    @Override
    public int compare(ForceCharacters o1, ForceCharacters o2) {
        if (o1.get_side() == o2.get_side()) {
            return o1.get_name().length() - o2.get_name().length();
        }
        return o1.get_side().compareTo(o2.get_side());
    }
}