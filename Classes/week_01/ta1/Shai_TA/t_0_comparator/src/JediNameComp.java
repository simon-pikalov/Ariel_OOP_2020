import java.util.Comparator;

public class JediNameComp implements Comparator<ForceCharacters> {

    @Override
    public int compare(ForceCharacters o1, ForceCharacters o2) {
        return o1.get_name().length() - o2.get_name().length();
    }
}