import java.util.Comparator;

public class JediLightSaberComp implements Comparator<ForceCharacters> {

    @Override
    public int compare(ForceCharacters o1, ForceCharacters o2) {
        return o1.get_LightSaberColor().compareTo(o2.get_LightSaberColor());
    }
}